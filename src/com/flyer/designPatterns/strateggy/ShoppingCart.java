package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Context to execute different strategy as a passed in parameter
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-24
 */

public class ShoppingCart {

    private List<ShoppingItem> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList<ShoppingItem>();
    }

    public void addItem(ShoppingItem item) {
        this.itemList.add(item);
    }

    public void removeItem(ShoppingItem item) {
        this.itemList.remove(item);
    }

    public String showShoppingCart() {
        StringBuilder builder = new StringBuilder();
        for (ShoppingItem item: this.itemList) {
            builder.append(item.getCode() + " | " + item.getName() + " | $" + item.getPrice().toEngineeringString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = new BigDecimal(0);
        for (ShoppingItem item: this.itemList) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    public void checkout(PaymentStrategy paymentMethod) {
        paymentMethod.pay(this.getTotalPrice());
    }
}
