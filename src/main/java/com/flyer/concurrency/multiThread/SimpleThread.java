package com.flyer.concurrency.multiThread;

public class SimpleThread extends Thread {
    private Thread thread;
    private String threadName;

    public SimpleThread(String name) {
        this.threadName = name;
        System.out.println("Creating " + this.threadName);
    }

    public void run() {
        System.out.println("Running " + this.threadName);

        try {
            for (int i=0; i<4; i++) {
                System.out.println("Thread: " + this.threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.threadName + " interrupted.");
        }
        System.out.println("Thread " + this.threadName + " exiting ...");
    }

    public void start() {
        System.out.println("Starting " + this.threadName);
        if (this.thread == null) {
            this.thread = new Thread(this, this.threadName);
            this.thread.start();
        }
    }
}
