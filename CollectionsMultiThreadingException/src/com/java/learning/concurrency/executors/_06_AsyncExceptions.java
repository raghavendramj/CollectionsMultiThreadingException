package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _06_AsyncExceptions {


    public static void main(String[] args) {
        CompletableFuture<Object> getting_the_current_weather = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            Object temprature = getting_the_current_weather.exceptionally(ex -> 1).get();
            System.out.println("Current temprature : " + temprature);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
