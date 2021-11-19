package com.java.learning.functional.programming.basics;

public class _05_MethodReference {

    public _05_MethodReference(String message) {
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public static void main(String[] args) {
        show();
    }

    public static void show() {
        greet(message -> System.out.println(message));
        //Class/Object::method
        greet(System.out::println); //1. Existing Method

        greet(_05_MethodReference::print); //2. Static Method
        greet(new _05_MethodReference("Testing Times")::display); //3. Instance Method
        greet(_05_MethodReference::new); //4. Constructor Method
    }

    public static void print(String message) {
        System.out.println("From Static Method :- " + message);
    }

    public void display(String message) {
        System.out.println("From Static Method :- " + message);
    }

    //Functional Interface -> Singe Abstract Method
    static interface Printer {
        void print(String message);
    }
}
