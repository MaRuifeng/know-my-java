package com.flyer.concurrency.countdownLatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An time helper utility.
 *
 * @author Ruifeng Ma
 * @since 2019-May-03
 */
public class LogUtil {

    public static void log(String message) {
        System.out.println("[" + getCurrentTime() + "] " + message);
    }

    private static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
