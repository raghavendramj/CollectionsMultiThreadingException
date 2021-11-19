package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _02_CreateStreams {

    public static void main(String[] args) {
        int numbers[] = {1, 2, 3};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(n -> System.out.println(n));

        Stream<Double> doubleStream = Stream.generate(() -> Math.random());
        doubleStream.limit(10).forEach(n -> System.out.println(n));

        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 1).limit(10);
        integerStream.forEach(num -> System.out.println(num));
    }
}
