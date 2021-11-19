package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class _12_HandlingTimeOuts {


    static class LongTask {
        public static void simulate() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 12;
        });


        //var result = future.orTimeOut(1, TimeUnit.SECONDS).get();
        //System.out.println("Timed out :- " + result);

        //var result = future.completeOnTimeout(1,1, TimeUnit.SECONDS).get()
        //System.out.println("Timed out :- " + result);

    }
}
