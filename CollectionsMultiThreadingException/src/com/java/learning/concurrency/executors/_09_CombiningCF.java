package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _09_CombiningCF {

    public static void main(String[] args) {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Double> second = CompletableFuture.supplyAsync(() -> 0.9);

        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(result -> System.out.println(" Combining : Price is :- " + result));


        //Combining + Transformation
        CompletableFuture<Integer> fourth = CompletableFuture
                .supplyAsync(() -> "20 USD")
                .thenApply(str -> Integer.parseInt(str.replace("USD", "")));
        CompletableFuture<Double> fifth = CompletableFuture.supplyAsync(() -> 0.9);

        fourth.thenCombine(fifth, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(result -> System.out.println(" Combining + Transformation : Price is :- " + result));




    }
}
