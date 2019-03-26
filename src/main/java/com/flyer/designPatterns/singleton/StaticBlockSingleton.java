package com.flyer.designPatterns.singleton;

/**
 * Instance created in static block
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-26
 */

public class StaticBlockSingleton extends Singleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred when creating singleton instance.");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
