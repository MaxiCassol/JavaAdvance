package com.soyhenry.expenseapp.exception;

import org.springframework.dao.DataAccessException;

public class DAOException extends Exception {
    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, DataAccessException e) {
        super(message);
    }
}
