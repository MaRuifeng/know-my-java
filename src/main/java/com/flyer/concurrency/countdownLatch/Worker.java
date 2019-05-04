package com.flyer.concurrency.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Work threads that will be waited for by the main boss thread
 *
 * @author Ruifeng Ma
 * @since 2019-May-03
 */

public class Worker implements Runnable {
    private CountDownLatch latch;
    private int workId;

    public Worker(int workId, CountDownLatch latch) {
        this.workId = workId;
        this.latch = latch;
    }

    @Override
    public void run() {
        LogUtil.log("Worker " + this.workId + " started.");

        try {
            Thread.sleep(3000); // instead of doing work, doze off for a while; don't tell the boss
            LogUtil.log("Worker " + this.workId + " worked for 3 seconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown(); // tell the boss work is done (really...)
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public int getWorkId() {
        return workId;
    }
}
