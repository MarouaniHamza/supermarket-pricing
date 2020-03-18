package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByGroupScheme;

public class PricingByGroupSchemeTest {

    private PricingByGroupScheme pricingByGroupScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByGroupScheme = new PricingByGroupScheme();
        pricingByGroupScheme.computePrice(null);
    }
}
