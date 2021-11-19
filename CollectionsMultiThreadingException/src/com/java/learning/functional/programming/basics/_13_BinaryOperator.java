package com.java.learning.functional.programming.basics;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class _13_BinaryOperator {

    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Integer result = add.apply(2, 4);
        System.out.println("Result is :- " + result);


        Function<Integer, Integer> sqaure = a -> a * a;

        BiFunction<Integer, Integer, Integer> integerIntegerIntegerBiFunction = add.andThen(sqaure);
        System.out.println("Result is :- " + integerIntegerIntegerBiFunction.apply(1, 2));

    }
}
