package com.java.learning.functional.programming.basics;

public class _02_AnonymousInnerClasses {

    public static void show() {
        Printer printer = new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        };
        greet(printer);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    //Functional Interface -> Singe Abstract Method
    static interface Printer {
        void print(String message);
    }

    public static void main(String[] args) {
        show();
    }
}
