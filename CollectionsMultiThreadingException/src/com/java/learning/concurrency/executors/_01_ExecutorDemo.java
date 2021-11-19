package com.java.learning.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            executorService.submit(() -> {
                System.out.println("\nThread Name is :- " + Thread.currentThread().getName());
            });
        } finally {
            executorService.shutdown();
        }
    }
}
