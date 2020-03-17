package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByWeightScheme;

import java.util.Collections;

public class PricingByWeightSchemeTest {

    private final PricingByWeightScheme pricingByWeightScheme = new PricingByWeightScheme();

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null(){
        pricingByWeightScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list(){
        pricingByWeightScheme.computePrice(Collections.emptyList());
    }
}
