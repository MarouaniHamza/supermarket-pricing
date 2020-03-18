package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByDiscountScheme;

public class PricingByDiscountSchemeTest {

    private PricingByDiscountScheme pricingByDiscountScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByDiscountScheme = new PricingByDiscountScheme();
        pricingByDiscountScheme.computePrice(null);
    }

}
