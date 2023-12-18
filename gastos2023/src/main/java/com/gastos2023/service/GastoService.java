package com.gastos2023.service;


import com.gastos2023.dto.GastoDTO;
import com.gastos2023.model.Gasto;

import java.util.List;

public interface GastoService {
    Gasto insertarGasto(GastoDTO gastoDTO);

    List<Gasto> obtenerTodosLosGastos();

    Gasto actualizarGasto(Long id, GastoDTO gastoDTO);

    void borrarGasto(Long id);
}