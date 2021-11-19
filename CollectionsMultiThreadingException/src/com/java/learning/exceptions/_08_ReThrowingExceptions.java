package com.java.learning.exceptions;

import java.io.IOException;

public class _08_ReThrowingExceptions {

    public static void show() throws IOException {
        Account account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            //Rethrowing exceptions
            throw e; // Step -02
        }
    }

    public static void main(String[] args) {
        try {
            show();
        } catch (IOException e) {
            System.out.println("An unexpected Error!"); // Step -03
        }
    }

    static class Account {
        public void deposit(float value) throws IOException {
            if (value <= 0)
                throw new IOException(); // Step -01
        }
    }
}
