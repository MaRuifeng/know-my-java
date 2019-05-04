package com.flyer.concurrency.multiThread;

public class TestSimpleThread {

    public static void main(String[] args) {
        SimpleThread threadOne = new SimpleThread("thread-1");
        threadOne.start();

        SimpleThread threadTwo = new SimpleThread("thread-2");
        threadTwo.start();
    }
}
