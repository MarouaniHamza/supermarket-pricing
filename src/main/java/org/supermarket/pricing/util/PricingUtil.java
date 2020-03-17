package org.supermarket.pricing.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PricingUtil {

    public static BigDecimal scalePriceToTwoDecimalIfNecessary(BigDecimal price){

        if(price.precision() <= 2){
            return price;
        }
        return price.setScale(2, RoundingMode.UP);
    }
}
