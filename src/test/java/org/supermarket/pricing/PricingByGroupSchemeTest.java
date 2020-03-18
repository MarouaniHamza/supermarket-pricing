package org.supermarket.pricing;

import org.junit.Test;
import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.scheme.PricingByGroupScheme;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PricingByGroupSchemeTest {

    private PricingByGroupScheme pricingByGroupScheme;

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_null() {
        pricingByGroupScheme = new PricingByGroupScheme(BigDecimal.valueOf(1));
        pricingByGroupScheme.computePrice(null);
    }

    @Test(expected = NoItemProvidedException.class)
    public void should_throw_NoItemProvidedException_if_empty_list() {
        pricingByGroupScheme = new PricingByGroupScheme(BigDecimal.valueOf(1));
        pricingByGroupScheme.computePrice(Collections.emptyList());
    }

    @Test
    public void should_return_the_price_when_buy_three_items_and_offer_is_three_for_one_price() {

        // Given
        pricingByGroupScheme = new PricingByGroupScheme(BigDecimal.valueOf(1));
        List<Item> items = Arrays.asList(new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)));
        // When
        BigDecimal price = pricingByGroupScheme.computePrice(items);
        // Then
        assertEquals(BigDecimal.valueOf(1),price);
    }

    @Test
    public void should_return_the_price_plus_difference_when_buy_more_items_and_offer_is_three_for_one_price() {

        // Given
        pricingByGroupScheme = new PricingByGroupScheme(BigDecimal.valueOf(1));
        List<Item> items = Arrays.asList(new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)),
                new Item("soda_bottle", BigDecimal.valueOf(0.75), BigDecimal.valueOf(0.45)));
        // When
        BigDecimal price = pricingByGroupScheme.computePrice(items);
        // Then
        assertEquals(BigDecimal.valueOf(1).add(BigDecimal.valueOf(0.75)),price);
    }
}
