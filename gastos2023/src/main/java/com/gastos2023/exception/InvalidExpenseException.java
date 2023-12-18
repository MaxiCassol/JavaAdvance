package com.gastos2023.exception;

public class InvalidExpenseException extends Exception {
    public InvalidExpenseException(String message) {
        super(message);
    }
}
