package com.flyer.generics;

/**
 * Demo on how to declare and use Java generic classes.
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-13
 */

public class JavaGenericClassDemo {

    public static class Readable<T> {
        private T readable;

        public void add(T readable) {
            this.readable = readable;
        }

        public T get() {
            return this.readable;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java generic class demo!\n");

        Readable<Integer> integerReadable = new Readable<>();
        Readable<String> stringReadable = new Readable<>();

        integerReadable.add(new Integer(1));
        stringReadable.add(new String("helloworld"));

        System.out.println("Integer readable class: " + integerReadable.getClass().getCanonicalName());
        System.out.println("Integer readable type: " + integerReadable.get().getClass().getCanonicalName());
        System.out.println("Integer readable value: " + integerReadable.get() + "\n");

        System.out.println("String readable class: " + stringReadable.getClass().getCanonicalName());
        System.out.println("String readable type: " + stringReadable.get().getClass().getCanonicalName());
        System.out.println("String readable value: " + stringReadable.get() + "\n");

        System.out.println("\nEnd of demo.");
    }
}
