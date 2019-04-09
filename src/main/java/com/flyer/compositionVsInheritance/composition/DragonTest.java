package com.flyer.compositionVsInheritance.composition;

/**
 * Showcase loose coupling of composition
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-03
 */

public class DragonTest {

    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        System.out.println(dragon.spit());

        // cannot resolve method as it's not exposed at all
        // System.out.println(dragon.revealMyself());
    }
}
