package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class _03_AsyncCompleteableFuture {

    public static void main(String[] args) {
        try {
            Supplier<Integer> task = () -> 1;
            CompletableFuture<Integer> voidCompletableFuture = CompletableFuture.supplyAsync(task);
            Integer result = voidCompletableFuture.get();
            System.out.println("Result :- " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
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
}
