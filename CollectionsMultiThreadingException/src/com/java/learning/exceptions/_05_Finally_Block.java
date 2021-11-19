package com.java.learning.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _05_Finally_Block {

    public static void readFile() {

        FileReader reader = null;
        try {
            reader = new FileReader("employee.ser");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}
