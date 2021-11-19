package com.java.learning.concurrency.basics;

public class _01_Process_Threads {

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
