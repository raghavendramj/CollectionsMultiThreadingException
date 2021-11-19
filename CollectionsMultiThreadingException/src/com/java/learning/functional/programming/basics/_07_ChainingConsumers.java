package com.java.learning.functional.programming.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class _07_ChainingConsumers {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c");

        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        Consumer<String> printWithAppended = item -> System.out.println(item + " -> Appended");

        stringList.forEach(print.andThen(printUpperCase).andThen(printWithAppended));
    }
}
