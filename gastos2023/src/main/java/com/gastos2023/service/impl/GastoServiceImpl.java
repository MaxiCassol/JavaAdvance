package com.gastos2023.service.impl;


import com.gastos2023.dto.GastoDTO;
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
    public Gasto insertarGasto(GastoDTO gastoDTO) {
        String response = "Se registro el gasto con exito";

        Gasto gasto = mapDtoToGasto(gastoDTO);
        gastoRepository.insertarGasto(gasto);
        return null;
    }

    @Override
    public List<Gasto> obtenerTodosLosGastos() {
        // Lógica de negocio para obtener todos los gastos
        return null;
    }

    @Override
    public Gasto actualizarGasto(Long id, GastoDTO gastoDTO) {
        // Lógica de negocio para actualizar un gasto
        return null;
    }

    @Override
    public void borrarGasto(Long id) {
        // Lógica de negocio para borrar un gasto
    }

    private Gasto mapDtoToGasto(GastoDTO gastoDTO){
        Gasto gasto = new Gasto();
        gasto.setMonto(gastoDTO.getMonto());
        gasto.setDescripcion(gastoDTO.getDescripcion());
        gasto.setFecha(gastoDTO.getFecha());
        gasto.setCategoria(gastoDTO.getCategoria());
        return gasto;
    }
}