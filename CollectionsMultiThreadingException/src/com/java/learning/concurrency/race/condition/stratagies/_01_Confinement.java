package com.java.learning.concurrency.race.condition.stratagies;

import java.util.ArrayList;
import java.util.List;

public class _01_Confinement {

    public static void main(String[] args) {

        System.out.println("Download starting!");

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> fileTasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DownloadFileTask fileTask = new DownloadFileTask();
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


        System.out.println("Download Complete, bytes downloaded are : " + fileTasks.stream().map(t -> t.getStatus().getTotalBytes()).reduce(Integer::sum));
    }


    static class DownloadStatus {

        private int totalBytes;

        public void incrementBytes() {
            totalBytes++;
        }

        public int getTotalBytes() {
            return totalBytes;
        }
    }


    static class DownloadFileTask implements Runnable {

        DownloadStatus status;

        public DownloadFileTask() {
            this.status = new DownloadStatus();
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
