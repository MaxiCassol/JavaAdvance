package com.soyhenry.expenseapp.repository.impl;

import com.soyhenry.expenseapp.domain.Expense;
import com.soyhenry.expenseapp.domain.ExpenseCategory;
import com.soyhenry.expenseapp.exception.DAOException;
import com.soyhenry.expenseapp.repository.ExpenseRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    // Aglomero todas las sentencias SQL en constantes
    private static final String UPDATE_EXPENSE_BY_ID = "UPDATE Expense SET amount = ?, category_name = ?, date = ? WHERE id = ?";
    private static final String INSERT_INTO_EXPENSE = "INSERT INTO Expense (amount, category_id, category_name, date) VALUES (?, ?, ?, ?)";
    private static final String DELETE_FROM_EXPENSE_BY_ID = "DELETE FROM Expense WHERE id = ?";
    private static final String SELECT_ALL_EXPENSES = "SELECT * FROM Expense";
    private static final String SELECT_EXPENSE_BY_ID = "SELECT * FROM Expense WHERE id = ?";
    private static final String INSERT_INTO_CATEGORY_EXPENSE = "INSERT INTO ExpenseCategory (name) VALUES (?)";
    private static final String SELECT_FROM_EXPENSE_CATEGORY_BY_NAME = "SELECT * FROM ExpenseCategory WHERE name = ?";

    // Objeto de JDBC de Spring que realiza todas las operaciones necesarias para
    // realizar la conexión, generar los prepared statements, ejecutar las operaciones y cerrar las conexiones
    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insertExpense(Expense expense) {
        //Primero, insertamos la categoría correspondiente
        jdbcTemplate.update(INSERT_INTO_CATEGORY_EXPENSE, expense.getCategoryName().toLowerCase());
        // Declaramos el parámetro a ser insertado en la query y cuantos placeholders o argumentos pasamos
        Object[] params = {expense.getCategoryName()};
        int[] types = {1};
        //Luego, recuperamos la categoría
        ExpenseCategory expenseCategory = jdbcTemplate.queryForObject(
            SELECT_FROM_EXPENSE_CATEGORY_BY_NAME,
            params, types,
            // Le definimos como debe mapear cada campo recuperado de BD en las propiedades correspondientes de la entidad
            new ExpenseCategoryRowMapper());

        //Verificamos que no sea nula
        assert expenseCategory != null;
        //Finalmente, usamos los datos de esa categoría para completar el gasto y guardarlo
        return jdbcTemplate.update(INSERT_INTO_EXPENSE,
            expense.getAmount(),
            expenseCategory.getId(),
            expenseCategory.getName(),
            expense.getDate());
    }

    @Override
    public Integer updateExpense(Long id, Expense expense) {
        System.out.println("Actualizando la presentación");
        return jdbcTemplate.update(UPDATE_EXPENSE_BY_ID,
            expense.getAmount(),
            expense.getCategoryName(),
            expense.getDate(),
            id);
    }

    @Override
    public void deleteExpense(Long id) throws DAOException {
        System.out.println("Se elimina el gasto con ID: " + id);
        // Manejamos un try/catch para que, en caso de error al ejecutar la sentencia SQL de delete, arrojemos una excepción customizada
        try {
            jdbcTemplate.update(DELETE_FROM_EXPENSE_BY_ID, id);
        } catch (DataAccessException exception) {
            throw new DAOException("Hubo un error al eliminar el gasto con id " + id, exception);
        }
        System.out.println("Gasto eliminado con éxito");
    }

    @Override
    public Expense selectExpenseById(Long id) {
        // Declaramos el parámetro a ser insertado en la query y cuantos placeholders o argumentos pasamos
        Object[] params = {id};
        int[] types = {1};
        return jdbcTemplate.queryForObject(
            SELECT_EXPENSE_BY_ID,
            params, types,
            // Le definimos como debe mapear cada campo recuperado de BD en las propiedades correspondientes de la entidad
            new ExpenseRowMapper());
    }

    @Override
    public List<Expense> selectExpenses() {
        // En el caso de recuperar todos los registros, no necesitamos especificar parametros de búsqueda
        return jdbcTemplate.query(SELECT_ALL_EXPENSES, new ExpenseRowMapper());
    }




    // Clase interna que permite mapear cada resultado del ResultSet a las propiedades de la entidad
    static class ExpenseRowMapper implements RowMapper<Expense> {
        @Override
        public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
            Expense expense = new Expense();
            expense.setId(rs.getLong("id"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setCategoryId(rs.getLong("category_id"));
            expense.setCategoryName(rs.getString("category_name"));
            expense.setDate(rs.getString("date"));
            return expense;
        }
    }

    // Clase interna que permite mapear cada resultado del ResultSet a las propiedades de la entidad
    static class ExpenseCategoryRowMapper implements RowMapper<ExpenseCategory> {
        @Override
        public ExpenseCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExpenseCategory expenseCategory = new ExpenseCategory();
            expenseCategory.setId(rs.getLong("id"));
            expenseCategory.setName(rs.getString("name"));
            return expenseCategory;
        }
    }

}
