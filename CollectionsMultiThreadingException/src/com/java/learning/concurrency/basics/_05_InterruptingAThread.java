package com.java.learning.concurrency.basics;

public class _05_InterruptingAThread {

    public static void main(String[] args) {
        System.out.println("Main Class : " + Thread.currentThread().getName());

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("Download Interrupted from " + Thread.currentThread().getName());

    }

    static class DownloadFileTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Downloading a file! " + Thread.currentThread().getName());
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                System.out.println("Downloading byte :- " + i);
            }
            System.out.println("Download Complete! " + Thread.currentThread().getName());
        }
    }
}
