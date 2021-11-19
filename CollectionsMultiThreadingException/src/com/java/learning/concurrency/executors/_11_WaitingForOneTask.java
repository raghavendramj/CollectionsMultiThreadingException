package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _11_WaitingForOneTask {

    public static void main(String[] args) {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        CompletableFuture<Integer> second = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(first, second);

        anyOf.thenAccept((temp) -> {
            System.out.println("Fastest of the task completed :- " + temp);
        });
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
}
