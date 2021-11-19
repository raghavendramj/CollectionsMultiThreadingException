package com.java.learning.functional.programming.basics;

import java.util.Arrays;
import java.util.List;

public class _06_ConsumerInterface {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3);

        //Imperative programming (for, if/else, switch case)
        for (Integer number : integerList) {
            System.out.println(number);
        }

        //Declarative Programming
        integerList.forEach(item -> System.out.println(item));

    }
}
