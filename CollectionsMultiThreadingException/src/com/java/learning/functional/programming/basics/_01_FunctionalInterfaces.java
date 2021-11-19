package com.java.learning.functional.programming.basics;

public class _01_FunctionalInterfaces {

    public static void show() {
        greet(new ConsolePrinter());
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

    static class ConsolePrinter implements Printer {
        @Override
        public void print(String message) {
            System.out.println(message);
        }
    }
}
