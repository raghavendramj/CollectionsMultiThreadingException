package com.java.learning.functional.programming.basics;

import java.util.function.Predicate;

public class _12_ComposingPredicates {

    public static void main(String[] args) {
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasLeftBrace);
        Predicate<String> hasLeftOrRightBraces = hasLeftBrace.or(hasLeftBrace);

        System.out.println("hasLeftAndRightBraces ? " + hasLeftAndRightBraces.test("{key}"));
        System.out.println("hasLeftOrRightBraces ? " + hasLeftAndRightBraces.test("key}"));
        System.out.println("hasLeftOrRightBraces ? " + hasLeftAndRightBraces.test("{key"));
    }
}
