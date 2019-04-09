package com.flyer.compositionVsInheritance.polymorphicComposition;

/**
 * Composition back-end class
 */

public class Fruit {

    public int peel() {
        System.out.println("Now I am " + this.getClass().getCanonicalName());
        System.out.println("Peeling is appealing.\n");
        return 1;
    }
}
