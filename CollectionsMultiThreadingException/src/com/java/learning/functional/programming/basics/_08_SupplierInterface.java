package com.java.learning.functional.programming.basics;

import java.util.function.Supplier;

public class _08_SupplierInterface {

    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> Math.random(); //IntSupplier, DoubleSupplier, etc..
        Double random = getRandom.get(); // Lazy Evaluation.
        System.out.println(random);
    }
}
