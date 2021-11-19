package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _04_AsycAPI {

    public static void main(String[] args) {
        MailService mailService = new MailService();
        //mailService.send();
        CompletableFuture<Void> voidCompletableFuture = mailService.sendAsync();
        System.out.println("Hello world!");

        try {
            Thread.sleep(5000); // To see async worked
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class LongTask {
        public static void simulate() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MailService {
        public void send() {
            LongTask.simulate();
            System.out.println("Mail was sent");
        }

        public CompletableFuture<Void> sendAsync() {
            return CompletableFuture.runAsync(() -> send());
        }
    }

}


