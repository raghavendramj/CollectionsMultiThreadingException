package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _07_TransformCompleteableFuture {

    public static int toFahrenheit(int celsiuis) {
        return (int) (celsiuis * 1.8) + 32;
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 20);
        integerCompletableFuture
                .thenApply(_07_TransformCompleteableFuture::toFahrenheit)
                .thenAccept((fahrenheit) -> System.out.println(fahrenheit));
    }
}
