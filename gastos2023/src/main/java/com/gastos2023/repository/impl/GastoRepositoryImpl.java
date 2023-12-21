package com.gastos2023.repository.impl;

import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;
import com.gastos2023.repository.GastoRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GastoRepositoryImpl implements GastoRepository {

    // Sentencias SQL en constantes
    private static final String ACTUALIZAR_GASTO_POR_ID = "UPDATE Gasto SET descripcion = ?, monto = ?, fecha = ?, categoria = ? WHERE id = ?";
    private static final String INSERTAR_GASTO = "INSERT INTO Gasto (descripcion, monto, fecha, categoria) VALUES (?, ?, ?, ?)";
    private static final String BORRAR_GASTO_POR_ID = "DELETE FROM Gasto WHERE id = ?";
    private static final String OBTENER_TODOS_LOS_GASTOS = "SELECT * FROM Gasto";
    private static final String OBTENER_GASTO_POR_ID = "SELECT * FROM Gasto WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public GastoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertarGasto(Gasto gasto) {
        System.out.println("Insertando el nuevo gasto");

        return jdbcTemplate.update(INSERTAR_GASTO,
                gasto.getDescripcion(),
                gasto.getMonto(),
                gasto.getFecha(),
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
        System.out.println("Actualizando el gasto");
        int gastoActualizado = jdbcTemplate.update(ACTUALIZAR_GASTO_POR_ID,
                gasto.getDescripcion(),
                gasto.getMonto(),
                gasto.getFecha(),
                gasto.getCategoria(),
                id);
        System.out.println("Gasto Actualizado");
        return gastoActualizado;

    }

    @Override
    public void borrarGasto(Long id) throws DAOException {
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
            Gasto gasto =new Gasto();
            gasto.setId(resultSet.getLong("id"));
            gasto.setDescripcion(resultSet.getString("descripcion"));
            gasto.setMonto(resultSet.getDouble("monto"));
            gasto.setFecha(resultSet.getString("fecha"));
            gasto.setCategoria(resultSet.getString("categoria"));

            return gasto;
        }
    }
}
