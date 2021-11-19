package com.java.learning.concurrency.executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _13_Project {


    public static void main(String[] args) {

        LocalTime start = LocalTime.now();
        FlightService flightService = new FlightService();
        List<CompletableFuture<Void>> futures = flightService.getQuotes().map(future -> future.thenAccept(System.out::println)).collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            System.out.println("Retrieved all quotes in :- " + duration.toMillis() + " msec.");
        });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
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

        public static void simulate(int delay) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class FlightService {
        public Stream<CompletableFuture<Quote>> getQuotes() {
            List<String> stringList = Arrays.asList("site1", "site2", "site3");
            Stream<CompletableFuture<Quote>> completableFutureStream = stringList.stream()
                    .map(this::getQuoteAsync);

            return completableFutureStream;
        }


        public CompletableFuture<Quote> getQuoteAsync(String site) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Getting a quote from this website :- " + site);

                Random random = new Random();
                LongTask.simulate(1_000 + random.nextInt(2_000));

                int price = 100 + random.nextInt();
                return new Quote(site, price);
            });
        }
    }

    static class Quote {
        private final String site;
        private final int price;

        public Quote(String site, int price) {
            this.site = site;
            this.price = price;
        }

        public String getSite() {
            return site;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "site='" + site + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
