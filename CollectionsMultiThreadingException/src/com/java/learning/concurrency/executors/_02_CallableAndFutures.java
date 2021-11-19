package com.java.learning.concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _02_CallableAndFutures {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            Future<Integer> integerFuture = executorService.submit(() -> {
                LongTask.simulate();
                return 1;
            });

            System.out.println("Do more work!");
            Integer integer = integerFuture.get();
            System.out.println("Return type is :- " + integer);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
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
