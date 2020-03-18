package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;

public class PricingByGroupScheme implements PricingScheme {

    private BigDecimal groupPrice;

    public PricingByGroupScheme(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        int numberOfItems = items.size();
        if(numberOfItems > 3){
            int numberOfTimesToApplyScheme = numberOfItems / 3;
            int numberOfItemsOutOffScheme = numberOfItems % 3;
            BigDecimal itemPrice = items.get(0).getPrice();
            BigDecimal notCountedItemsPrice = BigDecimal.valueOf(itemPrice.doubleValue() * numberOfItemsOutOffScheme);
            BigDecimal groupedItemPrice = groupPrice.multiply(BigDecimal.valueOf(numberOfTimesToApplyScheme));
            BigDecimal notScaledPrice = notCountedItemsPrice.add(groupedItemPrice);
            return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
        }
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(groupPrice);
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }
}
