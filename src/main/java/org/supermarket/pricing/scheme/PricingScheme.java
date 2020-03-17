package org.supermarket.pricing.scheme;

import org.supermarket.pricing.model.Item;

import java.math.BigDecimal;
import java.util.List;

public interface PricingScheme {

    BigDecimal computePrice(List<Item> items);
}
