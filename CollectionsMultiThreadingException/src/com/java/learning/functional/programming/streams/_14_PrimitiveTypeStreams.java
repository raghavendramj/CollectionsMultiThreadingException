package com.java.learning.functional.programming.streams;

import java.util.stream.IntStream;

public class _14_PrimitiveTypeStreams {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).forEach(System.out::println);
    }
}
