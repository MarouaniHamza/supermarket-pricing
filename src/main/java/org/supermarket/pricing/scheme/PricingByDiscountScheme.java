package org.supermarket.pricing.scheme;

import org.supermarket.pricing.exception.NoItemProvidedException;
import org.supermarket.pricing.model.Item;
import org.supermarket.pricing.util.PricingUtil;

import java.math.BigDecimal;
import java.util.List;

public class PricingByDiscountScheme implements PricingScheme {

    private int numberOfItemsToBuy;

    private int numberOfItemsForFree;

    public PricingByDiscountScheme(int numberOfItemsToBuy, int numberOfItemsForFree) {
        this.numberOfItemsToBuy = numberOfItemsToBuy;
        this.numberOfItemsForFree = numberOfItemsForFree;
    }

    public BigDecimal computePrice(List<Item> items) {

        if(items == null || items.isEmpty()){
            throw new NoItemProvidedException(this);
        }
        int numberOfAllFreeItems = (items.size() * numberOfItemsForFree)/ numberOfItemsToBuy;
        BigDecimal priceOfAllFreeItems = BigDecimal.valueOf(numberOfAllFreeItems * items.get(0).getPrice().doubleValue());
        BigDecimal priceOfAllItems = BigDecimal.valueOf(items.size() * items.get(0).getPrice().doubleValue());
        BigDecimal notScaledPrice = priceOfAllItems.subtract(priceOfAllFreeItems);
        return PricingUtil.scalePriceToTwoDecimalIfNecessary(notScaledPrice);
    }

    public int getNumberOfItemsToBuy() {
        return numberOfItemsToBuy;
    }

    public void setNumberOfItemsToBuy(int numberOfItemsToBuy) {
        this.numberOfItemsToBuy = numberOfItemsToBuy;
    }

    public int getNumberOfItemsForFree() {
        return numberOfItemsForFree;
    }

    public void setNumberOfItemsForFree(int numberOfItemsForFree) {
        this.numberOfItemsForFree = numberOfItemsForFree;
    }
}
