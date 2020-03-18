package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;

public class PricingByGroupScheme implements PricingScheme {

    private BigDecimal groupPrice;

    private int groupSize;

    public PricingByGroupScheme(BigDecimal groupPrice, int groupSize) {
        this.groupPrice = groupPrice;
        this.groupSize = groupSize;
    }

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        int numberOfItems = items.size();
        BigDecimal itemPrice = items.get(0).getPrice();
        if(numberOfItems >= groupSize){
            int numberOfTimesToApplyScheme = numberOfItems / groupSize;
            int numberOfItemsOutOffScheme = numberOfItems % groupSize;
            BigDecimal notCountedItemsPrice = BigDecimal.valueOf(itemPrice.doubleValue() * numberOfItemsOutOffScheme);
            BigDecimal groupedItemPrice = groupPrice.multiply(BigDecimal.valueOf(numberOfTimesToApplyScheme));
            BigDecimal notScaledPrice = notCountedItemsPrice.add(groupedItemPrice);
            return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
        }else{
            BigDecimal notScaledPrice = BigDecimal.valueOf(numberOfItems * itemPrice.doubleValue());
            return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
        }

    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }
}
