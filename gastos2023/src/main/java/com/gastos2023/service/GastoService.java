package com.gastos2023.service;


import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;

import java.util.List;

public interface GastoService {
    String insertarGasto(GastoRequestDTO gastoRequestDTO);

    List<GastoResponseDTO> obtenerTodosLosGastos();

    String actualizarGasto(Long id, GastoRequestDTO gastoRequestDTO);

    void borrarGasto(Long id) throws DAOException;

    GastoResponseDTO obtenerGastoPorId(Long id);
}