package com.java.learning.exceptions;

public class _01_ExceptionsDemo {

    public static void show(){
        sayHello(null);
    }

    private static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    public static void main(String[] args) {
        show();
    }
}
