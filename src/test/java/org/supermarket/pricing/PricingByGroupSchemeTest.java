package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByDiscountScheme;
import org.supermarket.pricing.scheme.PricingByGroupScheme;

import java.util.Collections;

public class PricingByGroupSchemeTest {

    private PricingByGroupScheme pricingByGroupScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByGroupScheme = new PricingByGroupScheme();
        pricingByGroupScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list() {
        pricingByGroupScheme = new PricingByGroupScheme();
        pricingByGroupScheme.computePrice(Collections.emptyList());
    }
}
