package com.java.learning.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class _02_TypeOfExceptions {

    //Checked Exceptions
    // 1. FileNotFound
    // 2. ClassNotFound
    // 3. IOException
    public static void readFile(){
        try {
            FileReader fileReader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void show(){
        sayHello(null);
    }

    //UnChecked/Runtime Exception
    // 1.NullPointer
    // 2.Arithmetic
    // 3.IllegalArgument
    // 4.IndexOutOfBound
    // 5.IllegalState
    private static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    public static void main(String[] args) {
        show();
    }
}

