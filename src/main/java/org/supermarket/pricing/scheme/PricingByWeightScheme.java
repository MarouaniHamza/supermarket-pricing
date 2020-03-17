package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalDouble;

public class PricingByWeightScheme implements PricingScheme {

    public BigDecimal computePrice(List<Item> items) {

        if (items == null || items.isEmpty()) {
            throw new NoItemProvidedException(this);
        }
        OptionalDouble sumOfPrices = items.stream().mapToDouble(a -> a.getPrice().multiply(a.getWeight()).doubleValue()).reduce(Double::sum);
        BigDecimal notScaledPrice = BigDecimal.valueOf(sumOfPrices.getAsDouble());
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
    }

}
