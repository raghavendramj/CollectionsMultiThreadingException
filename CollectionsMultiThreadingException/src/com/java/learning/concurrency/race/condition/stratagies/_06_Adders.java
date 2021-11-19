package com.java.learning.concurrency.race.condition.stratagies;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

public class _06_Adders {

    public static void main(String[] args) {

        DownloadStatus downloadStatus = new DownloadStatus();
        ArrayList<Thread> allThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadTask(downloadStatus));
            allThreads.add(thread);
            thread.start();
        }

        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n******* No of Bytes Downloaded is :- " + downloadStatus.getTotalBytes());

    }

    static class DownloadStatus {
        private LongAdder totalBytes = new LongAdder();

        public int getTotalBytes() {
            return totalBytes.intValue();
        }

        public void incrementTotalBytes() {
            totalBytes.increment();
        }
    }


    static class DownloadTask implements Runnable {

        DownloadStatus status;

        public DownloadTask(DownloadStatus status) {
            this.status = status;
        }

        @Override
        public void run() {
            System.out.println("Downloading a file :- " + Thread.currentThread().getName());
            for (int i = 0; i < 10_000; i++) {
                status.incrementTotalBytes();
            }
            System.out.println("Downloading completed :- " + Thread.currentThread().getName());
        }
    }
}
