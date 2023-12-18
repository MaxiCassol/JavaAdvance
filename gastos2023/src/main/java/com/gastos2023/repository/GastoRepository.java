package com.gastos2023.repository;

import com.gastos2023.model.Gasto;

import java.util.List;

public interface GastoRepository{
    Gasto obtenerGastoPorId(Long id);

    List<Gasto> obtenerTodosLosGastos();

    int insertarGasto(Gasto gasto);

    int actualizarGasto(Long id, Gasto gasto);

    void borrarGasto(Long id);
}