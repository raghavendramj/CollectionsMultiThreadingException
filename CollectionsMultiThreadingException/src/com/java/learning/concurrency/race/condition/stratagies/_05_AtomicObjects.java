package com.java.learning.concurrency.race.condition.stratagies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class _05_AtomicObjects {
    public static void main(String[] args) {
        DownloadStatus status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> fileTasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DownloadFileTask fileTask = new DownloadFileTask(status);
            fileTasks.add(fileTask);
            Thread thread = new Thread(fileTask);
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
        System.out.println("Download Complete, bytes downloaded are : " + status.getTotalBytes());

    }

    static class DownloadStatus {
        private AtomicInteger totalBytes = new AtomicInteger();

        public int getTotalBytes() {
            return totalBytes.get();
        }

        public void incrementTotalBytes() {
            totalBytes.incrementAndGet();
        }
    }

    static class DownloadFileTask implements Runnable {
        DownloadStatus status;

        public DownloadFileTask(DownloadStatus status) {
            this.status = status;
        }

        @Override
        public void run() {
            System.out.println("Downloading Started " + Thread.currentThread().getName());
            for (int i = 0; i < 1_000_000; i++) {
                status.incrementTotalBytes();
            }
            System.out.println("Downloaded the file " + Thread.currentThread().getName());
        }

        public DownloadStatus getStatus() {
            return status;
        }
    }

}
