package org.supermarket.pricing.model;

import java.math.BigDecimal;

public class Item {

    private String id;

    private BigDecimal price;

    private BigDecimal weight;

    public Item(String id, BigDecimal price, BigDecimal weight) {
        this.id = id;
        this.price = price;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
