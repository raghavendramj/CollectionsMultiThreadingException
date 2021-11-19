package com.java.learning.concurrency.executors;

import java.util.concurrent.CompletableFuture;

public class _08_ComposingCF {

    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getUserPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void main(String[] args) {
        // id -> email
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "email");        // email -> playlist
        CompletableFuture<String> completableFuture = future.thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist"));
        completableFuture.thenAccept(pl -> System.out.println(pl));


        //Simplified Way
        getUserEmailAsync()
                .thenCompose(_08_ComposingCF::getUserPlaylistAsync)
                .thenAccept(pl -> System.out.println(pl));

    }
}
