package com.java.learning.concurrency.basics;

public class _02_StartingAThread {


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
            System.out.println("Downloading a file! " + Thread.currentThread().getName());
        }
    }
}
