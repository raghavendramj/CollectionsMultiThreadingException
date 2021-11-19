package com.java.learning.exceptions;

import java.io.IOException;

public class _09_CustomExceptions {

    public static void main(String[] args) {
        Account account = new Account();
        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //Checked or UnChecked Exceptions
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }

        public InsufficientFundsException() {
            super("Insufficient funds in your account!");
        }
    }

    static class Account {
        private float balance;

        public void deposit(float value) throws IOException {
            if (value <= 0)
                throw new IOException(); // Step -01
        }

        public void withdraw(float value) throws InsufficientFundsException {
            if (value > balance)
                throw new InsufficientFundsException();
        }
    }
}
