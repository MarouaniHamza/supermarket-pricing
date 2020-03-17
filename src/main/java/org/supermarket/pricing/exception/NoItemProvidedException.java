package org.supermarket.pricing.exception;

import org.supermarket.pricing.scheme.PricingScheme;

public class NoItemProvidedException extends RuntimeException {

    public NoItemProvidedException(PricingScheme pricingScheme) {
        super(" There is no item provided for scheme " + pricingScheme.getClass());
    }
}
