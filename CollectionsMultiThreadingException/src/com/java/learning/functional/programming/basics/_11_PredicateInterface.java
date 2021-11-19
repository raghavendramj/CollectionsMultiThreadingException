package com.java.learning.functional.programming.basics;

import java.util.function.Predicate;

public class _11_PredicateInterface {

    public static void main(String[] args) {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("Sky"));
    }
}
