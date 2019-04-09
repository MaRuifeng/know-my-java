package com.flyer.compositionVsInheritance.polymorphicComposition;

/**
 * Test composition with interfaces to achieve polymorphism
 */
public class FoodProcessor {
    public static void peelAnItem(Peelable item) {
        item.peel();
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        FoodProcessor.peelAnItem(apple);

        Peelable fuji = new Apple();
        FoodProcessor.peelAnItem(fuji);

        /* Added a new front-end composition class that does not break
           the implementation of FoodProcessor since it implements the Peelable interface.
         */
        Banana banana = new Banana();
        FoodProcessor.peelAnItem(banana);
    }
}
