package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _10_WaitingForCompletingTask {

    public static void main(String[] args) {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> second = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> third = CompletableFuture.supplyAsync(() -> 3);

        CompletableFuture<Void> all = CompletableFuture.allOf(first, second, third);
        all.thenRun(() -> {

            try {
                Integer firstResult = first.get();
                System.out.println("firstResult -> "+ firstResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks are completed!");
        });
    }
}
