package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;

/**
 * Strategy interface implementation
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-24
 */

public class CashStrategy implements PaymentStrategy {
    private String currencyType;

    public CashStrategy(String currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public void pay(BigDecimal amount) {
        // A signal on successful cash payment
        System.out.println("Paid with cash (" + this.currencyType + "): $" + amount);
    }
}
