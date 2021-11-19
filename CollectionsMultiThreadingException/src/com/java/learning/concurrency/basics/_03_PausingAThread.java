package com.java.learning.concurrency.basics;

public class _03_PausingAThread {

    public static void main(String[] args) {
        System.out.println("Main Class : " + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }

    }

    static class DownloadFileTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Downloading a file! " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Download Complete! " + Thread.currentThread().getName());
        }
    }
}
