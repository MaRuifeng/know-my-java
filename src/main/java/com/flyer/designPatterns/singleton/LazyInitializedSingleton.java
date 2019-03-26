package com.flyer.designPatterns.singleton;

/**
 * Instance is only created when it is firstly accessed.
 * This singleton instance is not thread safe.
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-26
 */

public class LazyInitializedSingleton extends Singleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) instance = new LazyInitializedSingleton();
        return instance;
    }
}
