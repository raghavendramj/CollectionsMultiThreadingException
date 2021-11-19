package com.java.learning.functional.programming.basics;

import java.util.function.Function;

public class _09_FunctionInterface {

    public static void main(String[] args) {

        Function<String, Integer> map = str -> str.length();
        Integer length = map.apply("Sky");
        System.out.println("length is :- " + length);
    }
}
