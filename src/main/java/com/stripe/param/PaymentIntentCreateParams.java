// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class PaymentIntentCreateParams extends ApiRequestParams {
  /**
   * A positive integer representing how much to charge in the [smallest currency
   * unit](https://stripe.com/docs/currencies#zero-decimal) (e.g., 100 cents to charge $1.00 or 100
   * to charge ¥100, a zero-decimal currency). The minimum amount is $0.50 US or [equivalent in
   * charge
   * currency](https://support.stripe.com/questions/what-is-the-minimum-amount-i-can-charge-with-stripe).
   */
  @SerializedName("amount")
  Long amount;

  /**
   * The amount of the application fee (if any) that will be applied to the payment and transferred
   * to the application owner's Stripe account. For more information, see the PaymentIntents
   * [Connect usage guide](/docs/payments/payment-intents/usage#connect).
   */
  @SerializedName("application_fee_amount")
  Long applicationFeeAmount;

  /** Capture method of this PaymentIntent, one of `automatic` or `manual`. */
  @SerializedName("capture_method")
  CaptureMethod captureMethod;

  /**
   * Set to `true` to attempt to confirm this PaymentIntent immediately. This parameter defaults to
   * `false`. If the payment method attached is a card, a return_url may be provided in case
   * additional authentication is required.
   */
  @SerializedName("confirm")
  Boolean confirm;

  /**
   * One of `automatic` (default) or `manual`.
   *
   * <p>When the confirmation method is `automatic`, a PaymentIntent can be confirmed using a
   * publishable key. After `next_action`s are handled, no additional confirmation is required to
   * complete the payment.
   *
   * <p>When the confirmation method is `manual`, all payment attempts must be made using a secret
   * key. The PaymentIntent will return to the `requires_confirmation` state after handling
   * `next_action`s, and requires your server to initiate each payment attempt with an explicit
   * confirmation. Read the [expanded
   * documentation](https://stripe.com/docs/payments/payment-intents/quickstart#manual-confirmation-flow)
   * to learn more about manual confirmation.
   */
  @SerializedName("confirmation_method")
  ConfirmationMethod confirmationMethod;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  @SerializedName("currency")
  String currency;

  /** ID of the customer this PaymentIntent is for if one exists. */
  @SerializedName("customer")
  String customer;

  /** An arbitrary string attached to the object. Often useful for displaying to users. */
  @SerializedName("description")
  String description;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /** Extra parameters for custom features not yet available in the client library. */
  @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
  Map<String, Object> extraParams;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * The Stripe account ID for which these funds are intended. For details, see the PaymentIntents
   * [Connect usage guide](https://stripe.com/docs/payments/payment-intents/usage#connect).
   */
  @SerializedName("on_behalf_of")
  String onBehalfOf;

  /** ID of the payment method to attach to this PaymentIntent. */
  @SerializedName("payment_method")
  String paymentMethod;

  /**
   * The list of payment method types (e.g. card) that this PaymentIntent is allowed to use. If this
   * is not provided, defaults to ["card"].
   */
  @SerializedName("payment_method_types")
  List<String> paymentMethodTypes;

  /** Email address that the receipt for the resulting payment will be sent to. */
  @SerializedName("receipt_email")
  String receiptEmail;

  /**
   * The URL to redirect your customer back to after they authenticate or cancel their payment on
   * the payment method's app or site. If you'd prefer to redirect to a mobile application, you can
   * alternatively supply an application URI scheme. This param can only be used if `confirm=true`.
   */
  @SerializedName("return_url")
  String returnUrl;

  /**
   * Set to `true` to save the PaymentIntent's payment method (either `source` or `payment_method`)
   * to the associated customer. If the payment method is already attached, this parameter does
   * nothing. This parameter defaults to `false` and applies to the payment method passed in the
   * same request or the current payment method attached to the PaymentIntent and must be specified
   * again if a new payment method is added.
   */
  @SerializedName("save_payment_method")
  Boolean savePaymentMethod;

  /** Shipping information for this PaymentIntent. */
  @SerializedName("shipping")
  Shipping shipping;

  /** ID of the Source object to attach to this PaymentIntent. */
  @SerializedName("source")
  String source;

  /**
   * Extra information about a PaymentIntent. This will appear on your customer's statement when
   * this PaymentIntent succeeds in creating a charge.
   */
  @SerializedName("statement_descriptor")
  String statementDescriptor;

  /**
   * The parameters used to automatically create a Transfer when the payment succeeds. For more
   * information, see the PaymentIntents [Connect usage
   * guide](https://stripe.com/docs/payments/payment-intents/usage#connect).
   */
  @SerializedName("transfer_data")
  TransferData transferData;

  /**
   * A string that identifies the resulting payment as part of a group. See the PaymentIntents
   * [Connect usage guide](https://stripe.com/docs/payments/payment-intents/usage#connect) for
   * details.
   */
  @SerializedName("transfer_group")
  String transferGroup;

  private PaymentIntentCreateParams(
      Long amount,
      Long applicationFeeAmount,
      CaptureMethod captureMethod,
      Boolean confirm,
      ConfirmationMethod confirmationMethod,
      String currency,
      String customer,
      String description,
      List<String> expand,
      Map<String, Object> extraParams,
      Map<String, String> metadata,
      String onBehalfOf,
      String paymentMethod,
      List<String> paymentMethodTypes,
      String receiptEmail,
      String returnUrl,
      Boolean savePaymentMethod,
      Shipping shipping,
      String source,
      String statementDescriptor,
      TransferData transferData,
      String transferGroup) {
    this.amount = amount;
    this.applicationFeeAmount = applicationFeeAmount;
    this.captureMethod = captureMethod;
    this.confirm = confirm;
    this.confirmationMethod = confirmationMethod;
    this.currency = currency;
    this.customer = customer;
    this.description = description;
    this.expand = expand;
    this.extraParams = extraParams;
    this.metadata = metadata;
    this.onBehalfOf = onBehalfOf;
    this.paymentMethod = paymentMethod;
    this.paymentMethodTypes = paymentMethodTypes;
    this.receiptEmail = receiptEmail;
    this.returnUrl = returnUrl;
    this.savePaymentMethod = savePaymentMethod;
    this.shipping = shipping;
    this.source = source;
    this.statementDescriptor = statementDescriptor;
    this.transferData = transferData;
    this.transferGroup = transferGroup;
  }

  public static Builder builder() {
    return new com.stripe.param.PaymentIntentCreateParams.Builder();
  }

  public static class Builder {
    private Long amount;

    private Long applicationFeeAmount;

    private CaptureMethod captureMethod;

    private Boolean confirm;

    private ConfirmationMethod confirmationMethod;

    private String currency;

    private String customer;

    private String description;

    private List<String> expand;

    private Map<String, Object> extraParams;

    private Map<String, String> metadata;

    private String onBehalfOf;

    private String paymentMethod;

    private List<String> paymentMethodTypes;

    private String receiptEmail;

    private String returnUrl;

    private Boolean savePaymentMethod;

    private Shipping shipping;

    private String source;

    private String statementDescriptor;

    private TransferData transferData;

    private String transferGroup;

    /** Finalize and obtain parameter instance from this builder. */
    public PaymentIntentCreateParams build() {
      return new PaymentIntentCreateParams(
          this.amount,
          this.applicationFeeAmount,
          this.captureMethod,
          this.confirm,
          this.confirmationMethod,
          this.currency,
          this.customer,
          this.description,
          this.expand,
          this.extraParams,
          this.metadata,
          this.onBehalfOf,
          this.paymentMethod,
          this.paymentMethodTypes,
          this.receiptEmail,
          this.returnUrl,
          this.savePaymentMethod,
          this.shipping,
          this.source,
          this.statementDescriptor,
          this.transferData,
          this.transferGroup);
    }

    /**
     * A positive integer representing how much to charge in the [smallest currency
     * unit](https://stripe.com/docs/currencies#zero-decimal) (e.g., 100 cents to charge $1.00 or
     * 100 to charge ¥100, a zero-decimal currency). The minimum amount is $0.50 US or [equivalent
     * in charge
     * currency](https://support.stripe.com/questions/what-is-the-minimum-amount-i-can-charge-with-stripe).
     */
    public Builder setAmount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * The amount of the application fee (if any) that will be applied to the payment and
     * transferred to the application owner's Stripe account. For more information, see the
     * PaymentIntents [Connect usage guide](/docs/payments/payment-intents/usage#connect).
     */
    public Builder setApplicationFeeAmount(Long applicationFeeAmount) {
      this.applicationFeeAmount = applicationFeeAmount;
      return this;
    }

    /** Capture method of this PaymentIntent, one of `automatic` or `manual`. */
    public Builder setCaptureMethod(CaptureMethod captureMethod) {
      this.captureMethod = captureMethod;
      return this;
    }

    /**
     * Set to `true` to attempt to confirm this PaymentIntent immediately. This parameter defaults
     * to `false`. If the payment method attached is a card, a return_url may be provided in case
     * additional authentication is required.
     */
    public Builder setConfirm(Boolean confirm) {
      this.confirm = confirm;
      return this;
    }

    /**
     * One of `automatic` (default) or `manual`.
     *
     * <p>When the confirmation method is `automatic`, a PaymentIntent can be confirmed using a
     * publishable key. After `next_action`s are handled, no additional confirmation is required to
     * complete the payment.
     *
     * <p>When the confirmation method is `manual`, all payment attempts must be made using a secret
     * key. The PaymentIntent will return to the `requires_confirmation` state after handling
     * `next_action`s, and requires your server to initiate each payment attempt with an explicit
     * confirmation. Read the [expanded
     * documentation](https://stripe.com/docs/payments/payment-intents/quickstart#manual-confirmation-flow)
     * to learn more about manual confirmation.
     */
    public Builder setConfirmationMethod(ConfirmationMethod confirmationMethod) {
      this.confirmationMethod = confirmationMethod;
      return this;
    }

    /**
     * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
     * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
     */
    public Builder setCurrency(String currency) {
      this.currency = currency;
      return this;
    }

    /** ID of the customer this PaymentIntent is for if one exists. */
    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    /** An arbitrary string attached to the object. Often useful for displaying to users. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * PaymentIntentCreateParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add all elements to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * PaymentIntentCreateParams#expand} for the field documentation.
     */
    public Builder addAllExpand(List<String> elements) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.addAll(elements);
      return this;
    }

    /**
     * Add a key/value pair to `extraParams` map. A map is initialized for the first `put/putAll`
     * call, and subsequent calls add additional key/value pairs to the original map. See {@link
     * PaymentIntentCreateParams#extraParams} for the field documentation.
     */
    public Builder putExtraParam(String key, Object value) {
      if (this.extraParams == null) {
        this.extraParams = new HashMap<>();
      }
      this.extraParams.put(key, value);
      return this;
    }

    /**
     * Add all map key/value pairs to `extraParams` map. A map is initialized for the first
     * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
     * See {@link PaymentIntentCreateParams#extraParams} for the field documentation.
     */
    public Builder putAllExtraParam(Map<String, Object> map) {
      if (this.extraParams == null) {
        this.extraParams = new HashMap<>();
      }
      this.extraParams.putAll(map);
      return this;
    }

    /**
     * Add a key/value pair to `metadata` map. A map is initialized for the first `put/putAll` call,
     * and subsequent calls add additional key/value pairs to the original map. See {@link
     * PaymentIntentCreateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /**
     * Add all map key/value pairs to `metadata` map. A map is initialized for the first
     * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
     * See {@link PaymentIntentCreateParams#metadata} for the field documentation.
     */
    public Builder putAllMetadata(Map<String, String> map) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.putAll(map);
      return this;
    }

    /**
     * The Stripe account ID for which these funds are intended. For details, see the PaymentIntents
     * [Connect usage guide](https://stripe.com/docs/payments/payment-intents/usage#connect).
     */
    public Builder setOnBehalfOf(String onBehalfOf) {
      this.onBehalfOf = onBehalfOf;
      return this;
    }

    /** ID of the payment method to attach to this PaymentIntent. */
    public Builder setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
    }

    /**
     * Add an element to `paymentMethodTypes` list. A list is initialized for the first `add/addAll`
     * call, and subsequent calls adds additional elements to the original list. See {@link
     * PaymentIntentCreateParams#paymentMethodTypes} for the field documentation.
     */
    public Builder addPaymentMethodType(String element) {
      if (this.paymentMethodTypes == null) {
        this.paymentMethodTypes = new ArrayList<>();
      }
      this.paymentMethodTypes.add(element);
      return this;
    }

    /**
     * Add all elements to `paymentMethodTypes` list. A list is initialized for the first
     * `add/addAll` call, and subsequent calls adds additional elements to the original list. See
     * {@link PaymentIntentCreateParams#paymentMethodTypes} for the field documentation.
     */
    public Builder addAllPaymentMethodType(List<String> elements) {
      if (this.paymentMethodTypes == null) {
        this.paymentMethodTypes = new ArrayList<>();
      }
      this.paymentMethodTypes.addAll(elements);
      return this;
    }

    /** Email address that the receipt for the resulting payment will be sent to. */
    public Builder setReceiptEmail(String receiptEmail) {
      this.receiptEmail = receiptEmail;
      return this;
    }

    /**
     * The URL to redirect your customer back to after they authenticate or cancel their payment on
     * the payment method's app or site. If you'd prefer to redirect to a mobile application, you
     * can alternatively supply an application URI scheme. This param can only be used if
     * `confirm=true`.
     */
    public Builder setReturnUrl(String returnUrl) {
      this.returnUrl = returnUrl;
      return this;
    }

    /**
     * Set to `true` to save the PaymentIntent's payment method (either `source` or
     * `payment_method`) to the associated customer. If the payment method is already attached, this
     * parameter does nothing. This parameter defaults to `false` and applies to the payment method
     * passed in the same request or the current payment method attached to the PaymentIntent and
     * must be specified again if a new payment method is added.
     */
    public Builder setSavePaymentMethod(Boolean savePaymentMethod) {
      this.savePaymentMethod = savePaymentMethod;
      return this;
    }

    /** Shipping information for this PaymentIntent. */
    public Builder setShipping(Shipping shipping) {
      this.shipping = shipping;
      return this;
    }

    /** ID of the Source object to attach to this PaymentIntent. */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    /**
     * Extra information about a PaymentIntent. This will appear on your customer's statement when
     * this PaymentIntent succeeds in creating a charge.
     */
    public Builder setStatementDescriptor(String statementDescriptor) {
      this.statementDescriptor = statementDescriptor;
      return this;
    }

    /**
     * The parameters used to automatically create a Transfer when the payment succeeds. For more
     * information, see the PaymentIntents [Connect usage
     * guide](https://stripe.com/docs/payments/payment-intents/usage#connect).
     */
    public Builder setTransferData(TransferData transferData) {
      this.transferData = transferData;
      return this;
    }

    /**
     * A string that identifies the resulting payment as part of a group. See the PaymentIntents
     * [Connect usage guide](https://stripe.com/docs/payments/payment-intents/usage#connect) for
     * details.
     */
    public Builder setTransferGroup(String transferGroup) {
      this.transferGroup = transferGroup;
      return this;
    }
  }

  public static class Shipping {
    /** Shipping address. */
    @SerializedName("address")
    Address address;

    /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
    @SerializedName("carrier")
    String carrier;

    /** Extra parameters for custom features not yet available in the client library. */
    @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
    Map<String, Object> extraParams;

    /** Recipient name. */
    @SerializedName("name")
    String name;

    /** Recipient phone (including extension). */
    @SerializedName("phone")
    String phone;

    /**
     * The tracking number for a physical product, obtained from the delivery service. If multiple
     * tracking numbers were generated for this purchase, please separate them with commas.
     */
    @SerializedName("tracking_number")
    String trackingNumber;

    private Shipping(
        Address address,
        String carrier,
        Map<String, Object> extraParams,
        String name,
        String phone,
        String trackingNumber) {
      this.address = address;
      this.carrier = carrier;
      this.extraParams = extraParams;
      this.name = name;
      this.phone = phone;
      this.trackingNumber = trackingNumber;
    }

    public static Builder builder() {
      return new com.stripe.param.PaymentIntentCreateParams.Shipping.Builder();
    }

    public static class Builder {
      private Address address;

      private String carrier;

      private Map<String, Object> extraParams;

      private String name;

      private String phone;

      private String trackingNumber;

      /** Finalize and obtain parameter instance from this builder. */
      public Shipping build() {
        return new Shipping(
            this.address,
            this.carrier,
            this.extraParams,
            this.name,
            this.phone,
            this.trackingNumber);
      }

      /** Shipping address. */
      public Builder setAddress(Address address) {
        this.address = address;
        return this;
      }

      /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
      public Builder setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
      }

      /**
       * Add a key/value pair to `extraParams` map. A map is initialized for the first `put/putAll`
       * call, and subsequent calls add additional key/value pairs to the original map. See {@link
       * Shipping#extraParams} for the field documentation.
       */
      public Builder putExtraParam(String key, Object value) {
        if (this.extraParams == null) {
          this.extraParams = new HashMap<>();
        }
        this.extraParams.put(key, value);
        return this;
      }

      /**
       * Add all map key/value pairs to `extraParams` map. A map is initialized for the first
       * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
       * See {@link Shipping#extraParams} for the field documentation.
       */
      public Builder putAllExtraParam(Map<String, Object> map) {
        if (this.extraParams == null) {
          this.extraParams = new HashMap<>();
        }
        this.extraParams.putAll(map);
        return this;
      }

      /** Recipient name. */
      public Builder setName(String name) {
        this.name = name;
        return this;
      }

      /** Recipient phone (including extension). */
      public Builder setPhone(String phone) {
        this.phone = phone;
        return this;
      }

      /**
       * The tracking number for a physical product, obtained from the delivery service. If multiple
       * tracking numbers were generated for this purchase, please separate them with commas.
       */
      public Builder setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
      }
    }

    public static class Address {
      @SerializedName("city")
      String city;

      @SerializedName("country")
      String country;

      /** Extra parameters for custom features not yet available in the client library. */
      @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
      Map<String, Object> extraParams;

      @SerializedName("line1")
      String line1;

      @SerializedName("line2")
      String line2;

      @SerializedName("postal_code")
      String postalCode;

      @SerializedName("state")
      String state;

      private Address(
          String city,
          String country,
          Map<String, Object> extraParams,
          String line1,
          String line2,
          String postalCode,
          String state) {
        this.city = city;
        this.country = country;
        this.extraParams = extraParams;
        this.line1 = line1;
        this.line2 = line2;
        this.postalCode = postalCode;
        this.state = state;
      }

      public static Builder builder() {
        return new com.stripe.param.PaymentIntentCreateParams.Shipping.Address.Builder();
      }

      public static class Builder {
        private String city;

        private String country;

        private Map<String, Object> extraParams;

        private String line1;

        private String line2;

        private String postalCode;

        private String state;

        /** Finalize and obtain parameter instance from this builder. */
        public Address build() {
          return new Address(
              this.city,
              this.country,
              this.extraParams,
              this.line1,
              this.line2,
              this.postalCode,
              this.state);
        }

        public Builder setCity(String city) {
          this.city = city;
          return this;
        }

        public Builder setCountry(String country) {
          this.country = country;
          return this;
        }

        /**
         * Add a key/value pair to `extraParams` map. A map is initialized for the first
         * `put/putAll` call, and subsequent calls add additional key/value pairs to the original
         * map. See {@link Address#extraParams} for the field documentation.
         */
        public Builder putExtraParam(String key, Object value) {
          if (this.extraParams == null) {
            this.extraParams = new HashMap<>();
          }
          this.extraParams.put(key, value);
          return this;
        }

        /**
         * Add all map key/value pairs to `extraParams` map. A map is initialized for the first
         * `put/putAll` call, and subsequent calls add additional key/value pairs to the original
         * map. See {@link Address#extraParams} for the field documentation.
         */
        public Builder putAllExtraParam(Map<String, Object> map) {
          if (this.extraParams == null) {
            this.extraParams = new HashMap<>();
          }
          this.extraParams.putAll(map);
          return this;
        }

        public Builder setLine1(String line1) {
          this.line1 = line1;
          return this;
        }

        public Builder setLine2(String line2) {
          this.line2 = line2;
          return this;
        }

        public Builder setPostalCode(String postalCode) {
          this.postalCode = postalCode;
          return this;
        }

        public Builder setState(String state) {
          this.state = state;
          return this;
        }
      }
    }
  }

  public static class TransferData {
    /**
     * If specified, successful charges will be attributed to the destination account for tax
     * reporting, and the funds from charges will be transferred to the destination account. The ID
     * of the resulting transfer will be returned on the successful charge's `transfer` field.
     */
    @SerializedName("destination")
    String destination;

    /** Extra parameters for custom features not yet available in the client library. */
    @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
    Map<String, Object> extraParams;

    private TransferData(String destination, Map<String, Object> extraParams) {
      this.destination = destination;
      this.extraParams = extraParams;
    }

    public static Builder builder() {
      return new com.stripe.param.PaymentIntentCreateParams.TransferData.Builder();
    }

    public static class Builder {
      private String destination;

      private Map<String, Object> extraParams;

      /** Finalize and obtain parameter instance from this builder. */
      public TransferData build() {
        return new TransferData(this.destination, this.extraParams);
      }

      /**
       * If specified, successful charges will be attributed to the destination account for tax
       * reporting, and the funds from charges will be transferred to the destination account. The
       * ID of the resulting transfer will be returned on the successful charge's `transfer` field.
       */
      public Builder setDestination(String destination) {
        this.destination = destination;
        return this;
      }

      /**
       * Add a key/value pair to `extraParams` map. A map is initialized for the first `put/putAll`
       * call, and subsequent calls add additional key/value pairs to the original map. See {@link
       * TransferData#extraParams} for the field documentation.
       */
      public Builder putExtraParam(String key, Object value) {
        if (this.extraParams == null) {
          this.extraParams = new HashMap<>();
        }
        this.extraParams.put(key, value);
        return this;
      }

      /**
       * Add all map key/value pairs to `extraParams` map. A map is initialized for the first
       * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
       * See {@link TransferData#extraParams} for the field documentation.
       */
      public Builder putAllExtraParam(Map<String, Object> map) {
        if (this.extraParams == null) {
          this.extraParams = new HashMap<>();
        }
        this.extraParams.putAll(map);
        return this;
      }
    }
  }

  public enum CaptureMethod implements ApiRequestParams.EnumParam {
    @SerializedName("automatic")
    AUTOMATIC("automatic"),

    @SerializedName("manual")
    MANUAL("manual");

    @Getter(onMethod = @__({@Override}))
    private final String value;

    CaptureMethod(String value) {
      this.value = value;
    }
  }

  public enum ConfirmationMethod implements ApiRequestParams.EnumParam {
    @SerializedName("automatic")
    AUTOMATIC("automatic"),

    @SerializedName("manual")
    MANUAL("manual");

    @Getter(onMethod = @__({@Override}))
    private final String value;

    ConfirmationMethod(String value) {
      this.value = value;
    }
  }
}
