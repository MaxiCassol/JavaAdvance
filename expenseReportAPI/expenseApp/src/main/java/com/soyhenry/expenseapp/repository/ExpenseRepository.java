package com.soyhenry.expenseapp.repository;

import com.soyhenry.expenseapp.domain.Expense;
import com.soyhenry.expenseapp.exception.DAOException;

import java.util.List;

public interface ExpenseRepository {
    Integer insertExpense(Expense expense);
    Integer updateExpense(Long id, Expense expense);
    void deleteExpense(Long id) throws DAOException;
    List<Expense> selectExpenses();
    Expense selectExpenseById(Long id);
}
