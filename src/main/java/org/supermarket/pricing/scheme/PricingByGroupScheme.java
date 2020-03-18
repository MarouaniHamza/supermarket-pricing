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
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(groupPrice);
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }
}
