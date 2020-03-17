package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;

public class PricingByWeightScheme implements PricingScheme {

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        BigDecimal notScaledPrice = items.get(0).getPrice().multiply(items.get(0).getWeight());
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
    }

}
