package com.gastos2023.service;


import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;

import java.util.List;

public interface GastoService {
    Gasto insertarGasto(GastoRequestDTO gastoRequestDTO);

    List<GastoResponseDTO> obtenerTodosLosGastos();

    Gasto actualizarGasto(Long id, GastoRequestDTO gastoRequestDTO);

    void borrarGasto(Long id) throws DAOException;

    GastoResponseDTO obtenerGastoPorId(Long id);
}