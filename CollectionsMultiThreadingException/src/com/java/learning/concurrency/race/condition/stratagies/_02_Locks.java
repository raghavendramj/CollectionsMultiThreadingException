package com.java.learning.concurrency.race.condition.stratagies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _02_Locks {

    public static void main(String[] args) {

        DownloadStatus status = new DownloadStatus();
        System.out.println("Download starting!");

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
        private Lock lock = new ReentrantLock();
        private int totalBytes;

        public void incrementBytes() {
            try {
                lock.lock();
                totalBytes++;
            } finally {
                lock.unlock();
            }
        }

        public int getTotalBytes() {
            return totalBytes;
        }
    }


    static class DownloadFileTask implements Runnable {
        DownloadStatus status;

        public DownloadFileTask(DownloadStatus status) {
            this.status = status;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                status.incrementBytes();
            }
        }

        public DownloadStatus getStatus() {
            return status;
        }
    }
}
