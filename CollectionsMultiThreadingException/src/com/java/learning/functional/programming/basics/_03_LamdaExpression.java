package com.java.learning.functional.programming.basics;

public class _03_LamdaExpression {

    public static void show() {

        //Simplified
        Printer printer = (String message) -> {
            System.out.println(message);
        };
        greet(printer);


        //More Simplified
        Printer printer2 = message -> System.out.println(message);
        greet(printer2);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public static void main(String[] args) {
        show();
    }

    //Functional Interface -> Singe Abstract Method
    static interface Printer {
        void print(String message);
    }
}
