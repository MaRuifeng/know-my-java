package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCartTest {

    public static void main(String[] args) {
        System.out.println("Welcome to the Rabbit Hole supermarket!\n");

        ShoppingItem rabbitHat = new ShoppingItem("RAB-101", "Rabbit Hat", new BigDecimal("12.574"));
        ShoppingItem carrot = new ShoppingItem("RAB-102", "Carrot", new BigDecimal("3.4582"));
        ShoppingItem nightHowler = new ShoppingItem("RAB-103", "Night Howler", new BigDecimal("23456872.1234941233"));

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(rabbitHat);
        cart.addItem(carrot);
        cart.addItem(nightHowler);

        System.out.println("Let's see your shopping cart.");
        System.out.println(cart.showShoppingCart());

        cart.checkout(new CreditCardStrategy("Nick Wilde", "1234-2938-3849", "000", new Date()));

        cart.checkout(new CashStrategy("Zootopia Dollar"));

        System.out.println("\nOh! You made double payments and the super market accepted it!");
        System.out.println("All rabbits gone.");
    }
}
