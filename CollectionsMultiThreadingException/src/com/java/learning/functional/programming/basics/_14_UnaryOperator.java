package com.java.learning.functional.programming.basics;

import java.util.function.UnaryOperator;

public class _14_UnaryOperator {

    public static void main(String[] args) {
        UnaryOperator<Integer> sqaure = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + n;

        Integer result = increment.andThen(sqaure).apply(2);
        System.out.println("Result :- "+ result);
    }
}
