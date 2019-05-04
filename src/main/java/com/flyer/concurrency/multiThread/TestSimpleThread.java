package com.flyer.concurrency.multiThread;

public class TestSimpleThread {

    public static void main(String[] args) {
        SimpleThread threadOne = new SimpleThread("thread-1");
        threadOne.start();

        SimpleThread threadTwo = new SimpleThread("thread-2");
        threadTwo.start();

        for (int i = 0; i < 3; i++) {
            SimpleThread thread = new SimpleThread(String.valueOf(i));
            thread.start();
        }
    }
}
