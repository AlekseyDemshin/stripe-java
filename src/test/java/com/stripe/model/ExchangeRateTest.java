package com.stripe.model;

import java.util.HashMap;

import com.stripe.BaseStripeTest;
import com.stripe.exception.StripeException;
import com.stripe.net.APIResource;
import com.stripe.net.LiveStripeResponseGetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ExchangeRateTest extends BaseStripeTest {
	@Before
	public void mockStripeResponseGetter() {
		APIResource.setStripeResponseGetter(networkMock);
	}

	@After
	public void unmockStripeResponseGetter() {
	/* This needs to be done because tests aren't isolated in Java */
		APIResource.setStripeResponseGetter(new LiveStripeResponseGetter());
	}

	@Test
	public void testRetrieve() throws StripeException {
		ExchangeRate rates = ExchangeRate.retrieve("usd");

		verifyGet(ExchangeRate.class, "https://api.stripe.com/v1/exchange_rates/usd");
		verifyNoMoreInteractions(networkMock);
	}

	@Test
	public void testList() throws StripeException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("limit", 3);

		ExchangeRateCollection listRates = ExchangeRate.list(params);

		verifyGet(ExchangeRateCollection.class, "https://api.stripe.com/v1/exchange_rates", params);
		verifyNoMoreInteractions(networkMock);
	}
}
