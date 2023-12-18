package com.gastos2023.repository;

import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class GastoRepositoryImpl implements GastoRepository{

    // Sentencias SQL en constantes
    private static final String ACTUALIZAR_GASTO_POR_ID = "UPDATE Expense SET amount = ?, category_name = ?, date = ? WHERE id = ?";
    private static final String INSERTAR_GASTO = "INSERT INTO Expense (amount, category_id, category_name, date) VALUES (?, ?, ?, ?)";
    private static final String BORRAR_GASTO_POR_ID = "DELETE FROM Expense WHERE id = ?";
    private static final String OBTENER_TODOS_LOS_GASTOS = "SELECT * FROM Expense";
    private static final String OBTENER_GASTO_POR_ID = "SELECT * FROM Expense WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public GastoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertarGasto(Gasto gasto) {
        return jdbcTemplate.update(INSERTAR_GASTO,
                gasto.getMonto(),
                gasto.getFecha(),
                gasto.getDescripcion(),
                gasto.getCategoria());
    }

    @Override
    public Gasto obtenerGastoPorId(Long id) {
        //String sql = "SELECT * FROM gastos WHERE id = ?";
        //return jdbcTemplate.queryForObject(sql, new GastoRowMapper(), id);
        // Declaramos el parámetro a ser insertado en la query y cuantos placeholders o argumentos pasamos
        Object[] params = {id};
        int[] types = {1};
        return jdbcTemplate.queryForObject(
                OBTENER_GASTO_POR_ID,
                params, types,
                // Le definimos como debe mapear cada campo recuperado de BD en las propiedades correspondientes de la entidad
                new GastoRowMapper());
    }

    @Override
    public List<Gasto> obtenerTodosLosGastos() {
        return jdbcTemplate.query(OBTENER_TODOS_LOS_GASTOS, new GastoRowMapper());
    }

    @Override
    public int actualizarGasto(Long id, Gasto gasto) {
        System.out.println("Actualizando la presentación");
        return jdbcTemplate.update(ACTUALIZAR_GASTO_POR_ID,
                gasto.getMonto(),
                gasto.getCategoria(),
                gasto.getFecha(),
                id);
    }

    @Override
    public void borrarGasto(Long id) {
        System.out.println("Se elimina el gasto con ID: " + id);
        // Manejamos un try/catch para que, en caso de error al ejecutar la sentencia SQL de delete, arrojemos una excepción customizada
        try {
            jdbcTemplate.update(BORRAR_GASTO_POR_ID, id);
        } catch (DuplicateKeyException exception) {
            System.out.println("Error al eliminar el gasto con id: " + id + "Mensaje: " + exception.getMessage());
            exception.printStackTrace();
        }
        System.out.println("Gasto eliminado con éxito");
    }

    static class GastoRowMapper implements RowMapper<Gasto> {
        @Override
        public Gasto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            long id = resultSet.getLong("id");
            String descripcion = resultSet.getString("descripcion");
            double monto = resultSet.getDouble("monto");
            String fecha = resultSet.getString("fecha");
            String categoria = resultSet.getString("categoria");

            return new Gasto(id, descripcion, monto, fecha, categoria);
        }
    }

}
