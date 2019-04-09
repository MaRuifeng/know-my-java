package com.flyer.compositionVsInheritance.polymorphicComposition;

/**
 * Composition front-end class
 */
public class Apple implements Peelable {
    private Fruit fruit = new Fruit();

    public int peel() {
        System.out.println("Now I am " + this.getClass().getCanonicalName());
        return this.fruit.peel();
    }
}
