package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.scheme.PricingByNumberScheme;
import org.supermarket.pricing.scheme.PricingScheme;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
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
        assertEquals(BigDecimal.valueOf(1.5), price);
    }

    @Test
    public void should_return_price_multiplied_by_number_when_many_items_provided(){
        //given
        List<Item> items = Arrays.asList(new Item("soda_bottle", BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.7)),
                new Item("soda_bottle", BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.7)),
                new Item("soda_bottle", BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.7)),
                new Item("soda_bottle", BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.7)));
        //when
        BigDecimal price = pricingByNumberScheme.computePrice(items);
        //then
        assertEquals(BigDecimal.valueOf(1.5 * 4), price);
    }

    @Test
    public void should_return_price_multiplied_by_number_rounded_to_two_digit_when_too_many_items_provided(){
        //given
        List<Item> items = new ArrayList<>();
        for(int i = 0 ; i < 16419; i++){
            items.add(new Item("soda_bottle", BigDecimal.valueOf(1.231), BigDecimal.valueOf(0.7)));
        }
        //when
        BigDecimal price = pricingByNumberScheme.computePrice(items);
        //then
        assertEquals(BigDecimal.valueOf(1.231 * 16419).setScale(2, RoundingMode.CEILING), price);
    }
}
