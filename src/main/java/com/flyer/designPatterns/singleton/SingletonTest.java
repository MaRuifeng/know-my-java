package com.flyer.designPatterns.singleton;

import org.junit.Assert;

/**
 * Test on the Singleton implementations.
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-26
 */

public class SingletonTest {

    public static void testSingleton(Singleton singleton1, Singleton singleton2) throws RuntimeException {
        final Class clazz = singleton1.getClass();
        final String clazzName = clazz.getSimpleName();

        if ( ! clazz.equals(singleton2.getClass()) ) throw new RuntimeException("Two instances are not from the same Singleton!");

        System.out.println("===== Testing " + clazzName + " (Start) =====");

        System.out.println("For a Singleton class In JVM, only a single instance can be created and referenced.");
        System.out.println("Singleton 1 hashcode: " + singleton1.hashCode());
        System.out.println("Singleton 2 hashcode: " + singleton2.hashCode());
        Assert.assertEquals(singleton1.hashCode(), singleton2.hashCode());

        System.out.println("===== Testing " + clazzName + " (End) =====\n");
    }

    public static void main(String[] args) {
        testSingleton(LazyInitializedSingleton.getInstance(), LazyInitializedSingleton.getInstance());
        testSingleton(StaticBlockSingleton.getInstance(), StaticBlockSingleton.getInstance());
        testSingleton(ThreadSafeSingleton.getInstance(), ThreadSafeSingleton.getInstance());
        testSingleton(BillPughSingleton.getInstance(), BillPughSingleton.getInstance());
    }
}
