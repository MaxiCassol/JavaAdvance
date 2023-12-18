package com.gastos2023.repository;
import com.gastos2023.model.Gasto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GastoRowMapper implements RowMapper<Gasto> {
    @Override
    public Gasto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion");
        double monto = resultSet.getDouble("monto");
        String fecha = resultSet.getString("fecha");
        String categoria = resultSet.getString("categoria");

        return new Gasto(descripcion, monto, fecha, categoria);
    }
}
