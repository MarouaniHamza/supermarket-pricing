package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByDiscountScheme;

import java.util.Collections;

public class PricingByDiscountSchemeTest {

    private PricingByDiscountScheme pricingByDiscountScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByDiscountScheme = new PricingByDiscountScheme();
        pricingByDiscountScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list() {
        pricingByDiscountScheme = new PricingByDiscountScheme();
        pricingByDiscountScheme.computePrice(Collections.emptyList());
    }

}
