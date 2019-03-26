package com.flyer.designPatterns.strateggy;

import java.math.BigDecimal;

/**
 * Strategy interface
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-24
 */

public interface PaymentStrategy {
    public void pay(BigDecimal amount);
}
