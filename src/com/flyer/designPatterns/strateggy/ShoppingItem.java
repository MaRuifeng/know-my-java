package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;

public class ShoppingItem {
    private String code;
    private String name;
    private BigDecimal price;

    public ShoppingItem(String code, String name, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
