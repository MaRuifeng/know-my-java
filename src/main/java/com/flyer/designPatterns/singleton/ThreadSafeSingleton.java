package com.flyer.designPatterns.singleton;

/**
 * A lazily initialized singleton can be made thread safe by making the global access method synchronized.
 * The double checked locking principle can be used to avoid the extra overhead associated with synchronization.
 *
 * @author Ruifeng
 * @since 2019-Mar-26
 */

public class ThreadSafeSingleton extends Singleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
