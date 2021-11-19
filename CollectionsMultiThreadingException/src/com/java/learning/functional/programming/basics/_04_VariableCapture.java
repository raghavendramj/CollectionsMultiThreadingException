package com.java.learning.functional.programming.basics;

public class _04_VariableCapture {

    public String prefix = " - ";

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public static void main(String[] args) {
        new _04_VariableCapture().show();
    }

    public void show() {
        Printer printer = message -> System.out.println(this + message);
        greet(printer);
    }

    //Functional Interface -> Singe Abstract Method
    static interface Printer {
        void print(String message);
    }
}
