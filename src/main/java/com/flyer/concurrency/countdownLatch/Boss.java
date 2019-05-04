package com.flyer.concurrency.countdownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Main boss thread that waits for the worker threads
 *
 * @author Ruifeng Ma
 * @since 2019-May-03
 */
public class Boss {

    private static final int NUMBER_OF_WORKERS = 5;
    private ExecutorService executorService;

    public static void main(String[] args) {

        System.out.println("Welcome to the rabbit hole of CountDownLatches.\n");
        Boss boss = new Boss();
        boss.start();
        boss.shutdown();
        System.out.println("\nAll rabbits gone.");
    }

    private void start() {
        CountDownLatch latch = new CountDownLatch(NUMBER_OF_WORKERS);

        executorService = Executors.newFixedThreadPool(NUMBER_OF_WORKERS); // create threads in pool


        for (int i = 0; i < NUMBER_OF_WORKERS - 1; i++) {
            executorService.submit(new Worker(i, latch)); // submit latched task for execution
        }

        executorService.submit(new BrokenWorker(NUMBER_OF_WORKERS - 1, latch));

        try {
            // latch.await(); // wait for all latched worker threads to complete
            latch.await(6L, TimeUnit.SECONDS); // timeout for workers that terminate before invoking countdown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void shutdown() {
        if (!executorService.isShutdown()) {
            LogUtil.log("Shutting down ...");
            executorService.shutdownNow();
            try {
                if (!executorService.awaitTermination(3000, TimeUnit.MILLISECONDS)) {
                    LogUtil.log("Executor didn't terminate in the specified time.");
                    List<Runnable> droppedTasks = executorService.shutdownNow();
                    LogUtil.log("Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
