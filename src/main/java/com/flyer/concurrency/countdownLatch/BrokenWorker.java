package com.flyer.concurrency.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * A worker that breaks before invoking latch countdown
 *
 * @author Ruifeng Ma
 * @since 2019-May-03
 */

public class BrokenWorker extends Worker {
    public BrokenWorker(int workId, CountDownLatch latch) {
        super(workId, latch);
    }

    @Override
    public void run() {
        LogUtil.log("Broken worker " + this.getWorkId() + " started.");

        try {
            Thread.sleep(3000); // instead of doing work, doze off for a while; don't tell the boss
            LogUtil.log("Broken worker " + this.getWorkId() + " worked for 3 seconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (true) {
            LogUtil.log("Broken worker " + this.getWorkId() + " is throwing a Runtime exception.");
            throw new RuntimeException("Oops! I am a broken worker.");
        }

        this.getLatch().countDown(); // tell the boss work is done (really...)
    }
}
