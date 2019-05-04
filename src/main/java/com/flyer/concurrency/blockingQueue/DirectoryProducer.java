package com.flyer.concurrency.blockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Inspects a directory recursively and puts a files of a specific type onto queue.
 *
 * @author Ruifeng Ma
 * @since 2019-May-04
 */

public class DirectoryProducer extends Thread {
    private BlockingQueue<File> fileQueue;
    private File dir;
    private String fileType;
    private int id;
    private CountDownLatch latch;

    public DirectoryProducer(int id, BlockingQueue<File> fileQueue, File dir, String fileType, CountDownLatch latch) {
        this.id = id;
        this.fileQueue = fileQueue;
        this.dir = dir;
        this.fileType = fileType;
        this.latch = latch;
    }

    public void run() {
        try {
            getFiles(this.dir);
            this.fileQueue.put(new File("END")); // end of file queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("File queue size: " + this.fileQueue.size());

        latch.countDown();
    }

    private void getFiles(File dir) throws InterruptedException {
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith("." + fileType.toLowerCase());
//            }
//        });

        File[] javaFiles = dir.listFiles((file) -> file
                .getName()
                .endsWith("." + this.fileType.toLowerCase())
        );


        File[] dirs = dir.listFiles((file) -> file.isDirectory());

        if (javaFiles != null && javaFiles.length > 0) {
            for (File file : javaFiles) {
                this.fileQueue.put(file);
            }
        }

        if (dirs != null && dirs.length > 0) {
            for (File subDir: dirs) {
                getFiles(subDir);
            }
        }
    }
}
