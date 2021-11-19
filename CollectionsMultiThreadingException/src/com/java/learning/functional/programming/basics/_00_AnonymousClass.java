package com.java.learning.functional.programming.basics;

@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

public class _00_AnonymousClass {
    public static void main(String[] args) {
        Adder adder = new Adder() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Using anonymous class : " + adder.add(10, 20));

        //Lamba Expression
        Adder adderUsingLamba = (a, b) -> {
            return a + b;
        };
        System.out.println("Using Lamba class : " + adderUsingLamba.add(10, 20));

        Adder adderUsingLamba2 = (a, b) -> a + b;
        System.out.println("Using Simpler Lamba Expression : " + adderUsingLamba2.add(10, 20));
    }
}
