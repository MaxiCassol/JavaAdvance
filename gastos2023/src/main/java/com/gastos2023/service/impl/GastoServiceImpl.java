package com.gastos2023.service.impl;


import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.model.Gasto;
import com.gastos2023.repository.GastoRepository;
import com.gastos2023.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {
    @Autowired
    private final GastoRepository gastoRepository;

    public GastoServiceImpl(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    @Override
    public Gasto insertarGasto(GastoRequestDTO gastoRequestDTO) {
        String response = "Se registro el gasto con exito";

        Gasto gasto = mapDtoToGasto(gastoRequestDTO);
        gastoRepository.insertarGasto(gasto);
        return null;
    }

    @Override
    public List<GastoResponseDTO> obtenerTodosLosGastos() {
        // Lógica de negocio para obtener todos los gastos
        return null;
    }

    @Override
    public Gasto actualizarGasto(Long id, GastoRequestDTO gastoRequestDTO) {
        // Lógica de negocio para actualizar un gasto
        return null;
    }

    @Override
    public void borrarGasto(Long id) {
        // Lógica de negocio para borrar un gasto
    }

    @Override
    public GastoResponseDTO obtenerGastoPorId(Long id) {
        return null;
    }

    private Gasto mapDtoToGasto(GastoRequestDTO gastoRequestDTO){
        Gasto gasto = new Gasto();
        gasto.setMonto(gastoRequestDTO.getMonto());
        gasto.setDescripcion(gastoRequestDTO.getDescripcion());
        gasto.setFecha(gastoRequestDTO.getFecha());
        gasto.setCategoria(gastoRequestDTO.getCategoria());
        return gasto;
    }
}