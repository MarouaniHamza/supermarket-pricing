package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.scheme.PricingByDiscountScheme;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PricingByDiscountSchemeTest {

    private PricingByDiscountScheme pricingByDiscountScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByDiscountScheme = new PricingByDiscountScheme(3,1);
        pricingByDiscountScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list() {
        pricingByDiscountScheme = new PricingByDiscountScheme(3,1);
        pricingByDiscountScheme.computePrice(Collections.emptyList());
    }

    @Test
    public void should_return_price_of_two_if_buy_three(){
        //given
        pricingByDiscountScheme = new PricingByDiscountScheme(3,1);
        List<Item> items = Arrays.asList(new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)));
        //when
        BigDecimal price = pricingByDiscountScheme.computePrice(items);
        //then
        assertEquals(BigDecimal.valueOf(0.75 * 2).setScale(2, RoundingMode.UP),price);
    }

}
