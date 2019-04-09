package com.flyer.compositionVsInheritance.inheritance;

import com.flyer.compositionVsInheritance.Dracarys;
import com.flyer.compositionVsInheritance.Fire;
import com.flyer.compositionVsInheritance.Monster;

/**
 * Showcase dynamic binding and polymorphism of inheritance, and its limitations
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-03
 */

public class DragonTest {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Fire fireMonster = monster.spitV1();
        System.out.println(fireMonster.show());
        // assume spit() function changed to version 2
        // we had to change the returned object type here in the client
        Dracarys dracarysMonster = monster.spitV2();
        System.out.println(dracarysMonster.show());

        Dragon dragonA = new Dragon();
        Fire fireDragonA = dragonA.spitV1();
        System.out.println(fireDragonA.show());
        // assume spit() function changed to version 2
        // we had to change the returned object type here in the client
        Dracarys dracarysDragonA = dragonA.spitV2();
        System.out.println(dracarysDragonA.show());

        Monster dragonB = new Dragon();
        Fire fireDragonB = dragonB.spitV1();
        System.out.println(fireDragonB.show());
        // assume spit() function changed to version 2
        // we had to change the returned object type here in the client
        Dracarys dracarysDragonB = dragonB.spitV2();
        System.out.println(dracarysDragonB.show());

        // Other non-private methods of the superclass are also exposed
        System.out.println(dragonA.revealMyself());
    }
}
