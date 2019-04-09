package com.flyer.compositionVsInheritance.composition;

import com.flyer.compositionVsInheritance.Monster;

/**
 * Frontend class of composition
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-03
 */

public class Dragon {

    private Monster monster = new Monster();

    public Dragon() {
    }

    public String spit() {
        // return this.monster.spitV1().show();
        // assume spit() function changed to version 2
        // we just need to change the implementation here in the subclass without affecting the client
        return this.monster.spitV2().show();
    }

}
