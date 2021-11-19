package com.java.learning.concurrency.race.condition.stratagies;

import java.util.ArrayList;
import java.util.List;

public class _03_Syncronized {

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
        private int totalBytes;
        private int totalFiles;

        private Object totalBytesLock = new Object();
        private Object totalFilesLock = new Object();

        public void incrementTotalFiles() {
            synchronized (totalFilesLock) {
                totalFiles++;
            }
        }
        public void incrementBytes() {
            synchronized (totalBytesLock) {
                totalBytes++;
            }
        }

        public int getTotalBytes() {
            return totalBytes;
        }


        public int getTotalFiles() {
            return totalFiles;
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
