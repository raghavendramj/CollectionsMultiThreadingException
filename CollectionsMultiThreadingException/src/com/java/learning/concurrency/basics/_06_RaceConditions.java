package com.java.learning.concurrency.basics;

import java.util.ArrayList;
import java.util.List;

public class _06_RaceConditions {

    public static void main(String[] args) {
        System.out.println("Main Class : " + Thread.currentThread().getName());

        DownloadStatus downloadStatus = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask(downloadStatus));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n *** Downloaded Bytes :- " + downloadStatus.getTotalBytes());
    }

    static class DownloadStatus {
        private int totalBytes;

        public int getTotalBytes() {
            return totalBytes;
        }

        public void incrementTotalBytes() {
            totalBytes++;
        }
    }

    static class DownloadFileTask implements Runnable {

        private DownloadStatus downloadStatus;

        public DownloadFileTask(DownloadStatus downloadStatus) {
            this.downloadStatus = downloadStatus;
        }

        @Override
        public void run() {
            System.out.println("Downloading a file! " + Thread.currentThread().getName());
            for (int i = 0; i < 10_000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                downloadStatus.incrementTotalBytes();
            }
            System.out.println("Download Complete! " + Thread.currentThread().getName());
        }
    }
}
