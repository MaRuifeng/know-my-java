package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Strategy interface implementation
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-24
 */

public class CreditCardStrategy implements PaymentStrategy {
    private String holderName;
    private String number;
    private String cvv;
    private Date expiry;

    public CreditCardStrategy(String holderName, String number, String cvv, Date expiry) {
        this.holderName = holderName;
        this.number = number;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    @Override
    public void pay(BigDecimal amount) {
        // A big chunk of code and code references that completes credit card transaction
        System.out.println("Paid with credit card: $" + amount);
    }
}
