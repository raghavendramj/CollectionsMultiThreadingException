package com.java.learning.concurrency.race.condition.stratagies;

public class _04_Volatile {


    public static void main(String[] args) {
        DownloadStatus status = new DownloadStatus();

        Thread thread1 = new Thread(new DownloadFileTask(status));
        Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {
            }
            System.out.println("\n *** Downloaded Bytes :- " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();


    }

    static class DownloadStatus {
        private int totalBytes;
        private int totalFiles;
        private volatile boolean isDone;

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

        public boolean isDone() {
            return isDone;
        }

        public void done() {
            isDone = true;
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
                status.incrementBytes();
            }
            status.done();
            System.out.println("Downloaded the file " + Thread.currentThread().getName());
        }

        public DownloadStatus getStatus() {
            return status;
        }
    }
}
