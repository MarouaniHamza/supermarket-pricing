package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.scheme.PricingByNumberScheme;
import org.supermarket.pricing.scheme.PricingScheme;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void should_return_one_price_when_one_item_provided(){
        //given
        List<Item> items = Collections.singletonList(new Item("soda_bottle", BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.7)));
        //when
        BigDecimal price = pricingByNumberScheme.computePrice(items);
        //then
        assertEquals(price, BigDecimal.valueOf(1.5));
    }
}
