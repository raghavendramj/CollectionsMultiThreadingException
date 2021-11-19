package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _05_RunningCodeOnCompletion {

    public static void main(String[] args) {

        System.out.println("\nthenRun Example..");
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 1);
        integerCompletableFuture.thenRun(() -> {
            System.out.println("thenRun ->"+ Thread.currentThread().getName());
            System.out.println("thenRun -> Done");
        });
        System.out.println("\nthenRunAsync Example..");
        integerCompletableFuture.thenRunAsync(() -> {
            System.out.println("thenRunAsync ->"+Thread.currentThread().getName());
            System.out.println("thenRunAsync -> Done ");
        });

        System.out.println("\nthenAccept Example..");
        integerCompletableFuture.thenAccept((result) -> {
            System.out.println("thenAccept ->"+Thread.currentThread().getName());
            System.out.println("thenAccept -> result :- " + result);
        });

        System.out.println("\nthenAcceptAsync Example..");
        integerCompletableFuture.thenAcceptAsync((result) -> {
            System.out.println("thenAcceptAsync ->"+Thread.currentThread().getName());
            System.out.println("thenAcceptAsync -> result :- " + result);
        });
    }
}
