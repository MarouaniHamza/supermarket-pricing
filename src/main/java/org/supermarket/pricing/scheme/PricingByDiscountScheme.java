package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;

public class PricingByDiscountScheme implements PricingScheme {

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        int numberOfFreeItems = items.size() / 3;
        BigDecimal priceOfFreeItems = BigDecimal.valueOf(numberOfFreeItems * items.get(0).getPrice().doubleValue());
        BigDecimal priceOfAllItems = BigDecimal.valueOf(items.size() * items.get(0).getPrice().doubleValue());
        BigDecimal notScaledPrice = priceOfAllItems.subtract(priceOfFreeItems);
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
    }
}
