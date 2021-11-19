package com.java.learning.concurrency.basics;

public class _04_JoiningAThread {

    public static void main(String[] args) {
        System.out.println("Main Class : " + Thread.currentThread().getName());
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned!");

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
