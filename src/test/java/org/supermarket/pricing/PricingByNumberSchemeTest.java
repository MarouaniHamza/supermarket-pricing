package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.scheme.PricingByNumberScheme;
import org.supermarket.pricing.scheme.PricingScheme;

import java.util.Collections;

public class PricingByNumberSchemeTest {

    private final PricingScheme pricingByNumberScheme = new PricingByNumberScheme();

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null(){
        pricingByNumberScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list(){
        pricingByNumberScheme.computePrice(Collections.emptyList());
    }
}
