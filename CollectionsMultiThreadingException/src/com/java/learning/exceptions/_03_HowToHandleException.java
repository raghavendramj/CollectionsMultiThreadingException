package com.java.learning.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class _03_HowToHandleException {

    public static void readFile() {
        try {
            FileReader fileReader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        readFile();
    }
}
