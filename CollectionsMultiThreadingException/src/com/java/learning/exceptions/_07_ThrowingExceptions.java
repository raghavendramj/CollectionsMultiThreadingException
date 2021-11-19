package com.java.learning.exceptions;

import java.io.IOException;
import java.math.BigInteger;

public class _07_ThrowingExceptions {

    static class Account {
        public void deposit(float value) {
            //This technique is called defensive programming.
            //This is runtime exception.
            if (value <= 0)
                throw new IllegalArgumentException();
        }

        public void depositMoreMoney(BigInteger integer) throws IOException {
            //This is compiletime exception.
            if(integer.intValue() <= 0)
                throw new IOException();
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(-1);
    }
}
