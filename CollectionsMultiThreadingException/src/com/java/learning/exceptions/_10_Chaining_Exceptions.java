package com.java.learning.exceptions;

import java.io.IOException;

public class _10_Chaining_Exceptions {

    public static void main(String[] args) {
        Account account = new Account();
        try {
            account.withdraw(100);
        } catch (AccountException e) {
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage());
            e.printStackTrace();
        }
    }

    static class AccountException extends Exception {
        public AccountException(Exception cause) {
            super(cause);
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

        public void withdraw(float value) throws AccountException {
            if (value > balance) {
                AccountException accountException = new AccountException(new InsufficientFundsException());
                throw accountException;
            }
        }
    }


}
