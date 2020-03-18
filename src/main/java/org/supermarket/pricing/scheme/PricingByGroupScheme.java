package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;

import java.math.BigDecimal;
import java.util.List;

public class PricingByGroupScheme implements PricingScheme {

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
