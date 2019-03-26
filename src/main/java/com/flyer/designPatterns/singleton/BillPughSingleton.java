package com.flyer.designPatterns.singleton;

/**
 * Bill Pugh introduced a non-synchronization based singleton implementation that achieves thread safety
 * through an inner static helper class.
 *
 * The semantic for loading and initializing classes in JVM is defined in a way that it occurs only once.
 * When the singleton class is loaded, the inner helper class is not loaded into memory and only when someone
 * calls the getInstance() method will the helper class get loaded and create the singleton class instance.
 */

public class BillPughSingleton extends Singleton {

    private BillPughSingleton() {}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
