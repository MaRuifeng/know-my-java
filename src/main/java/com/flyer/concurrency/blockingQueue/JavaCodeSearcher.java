package com.flyer.concurrency.blockingQueue;

import java.io.File;
import java.util.concurrent.*;

/**
 * Use concurrent directory producers and consumers to list out Java code files
 *
 * @author Ruifeng Ma
 * @since 2019-May-04
 */

public class JavaCodeSearcher {

    public static void main(String[] args) {
        System.out.println("Welcome to the rabbit hole of ArrayBlockingQueues.\n");

        BlockingQueue<File> fileQueue = new ArrayBlockingQueue<>(200, true);
        String fileType = "java";
        String projectDir = System.getProperty("user.dir");

        CountDownLatch latch = new CountDownLatch(1);

        DirectoryProducer producer = new DirectoryProducer(1, fileQueue, new File(projectDir), fileType, latch);
        producer.start();

        try {
            latch.await(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 10; i++) {
            DirectoryConsumer consumer = new DirectoryConsumer(i, fileQueue);
            consumer.start();
        }

    }
}
