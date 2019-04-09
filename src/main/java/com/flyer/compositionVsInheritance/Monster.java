package com.flyer.compositionVsInheritance;

/**
 * Superclass for inheritance / backend class for composition
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-03
 */

public class Monster {

    public Monster() {
    }

    public Fire spitV1() {
        return new Fire();
    }

    public Dracarys spitV2() {
        return new Dracarys();
    }

    public String revealMyself() {
        return "I am a monster";
    }

}
