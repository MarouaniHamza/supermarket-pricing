package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.scheme.PricingByWeightScheme;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void should_return_price_multiplied_by_weight_when_one_item_provided(){
        //given
        List<Item> items = Collections.singletonList(new Item("apples_bag", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.8537)));
        //when
        BigDecimal price = pricingByWeightScheme.computePrice(items);
        //then
        assertEquals(BigDecimal.valueOf(0.75 * 0.8537), price);
    }
}
