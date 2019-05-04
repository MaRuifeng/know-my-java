package com.flyer.concurrency.blockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

/**
 * Reads files from the queue and print their names.
 *
 * @author Ruifeng Ma
 * @since 2019-May-04
 */

public class DirectoryConsumer extends Thread {
    private BlockingQueue<File> fileQueue;
    private int id;

    public DirectoryConsumer(int id, BlockingQueue<File> fileQueue) {
        this.id = id;
        this.fileQueue = fileQueue;
    }

    public void run() {
        while (true) {
            try {
                File file = this.fileQueue.peek();

                if (file != null && !file.getName().equals("END")) {
                    file = this.fileQueue.take();
                    System.out.println("Consumer " + this.id + " presents: " + file.getName());
                } else break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
