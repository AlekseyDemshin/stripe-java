package com.stripe.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import com.stripe.Stripe;

import com.stripe.param.common.EmptyParam;
import java.io.IOException;
import java.util.Map;

/**
 * Converter to map an api request object to an untyped map.
 * It is not called a *Serializer because the outcome is not a JSON data.
 * It is not called *UntypedMapDeserializer because it is not converting from JSON.
 */
class ApiRequestParamsConverter {
  /**
   * Strategy to flatten extra params in the API request parameters.
   */
  private static class ExtraParamsFlatteningStrategy implements UntypedMapDeserializer.Strategy {
    @Override
    public void deserializeAndTransform(Map<String, Object> outerMap,
                                        Map.Entry<String, JsonElement> jsonEntry,
                                        UntypedMapDeserializer untypedMapDeserializer) {
      String key = jsonEntry.getKey();
      JsonElement value = jsonEntry.getValue();
      if (ApiRequestParams.EXTRA_PARAMS_KEY.equals(key)) {
        if (!value.isJsonObject()) {
          throw new IllegalStateException(String.format(
              "Unexpected schema for extra params. JSON object is expected at key `%s`, but found"
                  + " `%s`. This is likely a problem with this current library version `%s`. "
                  + "Please contact support@stripe.com for assistance.",
              ApiRequestParams.EXTRA_PARAMS_KEY, value, Stripe.VERSION));
        }
        // `key` value indicating extra params is dropped, and instead the extra params are
        // flattened and set at this outer map instead.
        Map<String, Object> extraParamsMap =
            untypedMapDeserializer.deserialize(value.getAsJsonObject());
        outerMap.putAll(extraParamsMap);
      } else {
        // normal deserialization where output map has the same structure as given JSON content.
        outerMap.put(key, untypedMapDeserializer.deserializeJsonElement(value));
      }
    }
  }

  /**
   * Type adapter to convert an empty enum to null value to comply with the lower-lever encoding
   * logic for the API request parameters.
   */
  private static class HasEmptyEnumTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
      if (!ApiRequestParams.EnumParam.class.isAssignableFrom(type.getRawType())) {
        return null;
      }

      TypeAdapter<ApiRequestParams.EnumParam> paramEnum =
          new TypeAdapter<ApiRequestParams.EnumParam>() {
            @Override
            public void write(JsonWriter out, ApiRequestParams.EnumParam value) throws IOException {
              if (value.getValue().equals("")) {
                // need to restore serialize null setting
                // not to affect other fields
                boolean previousSetting = out.getSerializeNulls();
                out.setSerializeNulls(true);
                out.nullValue();
                out.setSerializeNulls(previousSetting);
              } else {
                out.value(value.getValue());
              }
            }

            @Override
            public ApiRequestParams.EnumParam read(JsonReader in) {
              throw new UnsupportedOperationException(
                  "No deserialization is expected from this private type adapter for enum param.");
            }
          };
      return (TypeAdapter<T>) paramEnum.nullSafe();
    }
  }

  private static final Gson GSON = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .registerTypeAdapterFactory(new ApiRequestParamsConverter.HasEmptyEnumTypeAdapterFactory())
      .create();

  private static final UntypedMapDeserializer FLATTENING_EXTRA_PARAMS_DESERIALIZER =
      new UntypedMapDeserializer(new ExtraParamsFlatteningStrategy());

  /**
   * Convert the given request params into an untyped map. This map is
   * composed of {@code Map<String, Object>}, {@code List<Object>}, and basic Java data types.
   * This allows you to test building the request params and verify compatibility with your
   * prior integrations using the untyped params map
   * {@link ApiResource#request(ApiResource.RequestMethod, String, Map, Class, RequestOptions)}.
   *
   * <p>There are two peculiarities in this conversion:
   *
   * <p>1) {@link EmptyParam#EMPTY}, containing a raw empty string value, is converted to null.
   * This is because the form-encoding layer prohibits passing empty string as a param map value.
   * It, however, allows a null value in the map (present key but null value).
   * Because of the translation from `EMPTY` enum to null, deserializing this map back to a
   * request instance is lossy. The null value will not be converted back to the `EMPTY` enum.
   *
   * <p>2) Parameter with serialized name {@link ApiRequestParams#EXTRA_PARAMS_KEY} will be
   * flattened. This is to support passing beta or new params that the current library has not
   * yet supported.
   */
  Map<String, Object> convert(ApiRequestParams apiRequestParams) {
    JsonObject jsonParams = GSON.toJsonTree(apiRequestParams).getAsJsonObject();
    return FLATTENING_EXTRA_PARAMS_DESERIALIZER.deserialize(jsonParams);
  }
}