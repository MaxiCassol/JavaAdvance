package com.gastos2023.service.impl;


import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;
import com.gastos2023.repository.GastoRepository;
import com.gastos2023.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastoServiceImpl implements GastoService {
    @Autowired
    private final GastoRepository gastoRepository;

    public GastoServiceImpl(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    @Override
    public String insertarGasto(GastoRequestDTO gastoRequestDTO) {
        String response = "Se registro el gasto con exito";

        Gasto gasto = mapDtoToGasto(gastoRequestDTO);
        Integer responsesInserted = gastoRepository.insertarGasto(gasto);
        if (responsesInserted.equals(0)) {
            System.out.println("No se insertó ningún registro");
        }
        return response;
    }

    @Override
    public List<GastoResponseDTO> obtenerTodosLosGastos() {
        List<Gasto> gastos = gastoRepository.obtenerTodosLosGastos();

        // En este caso, estoy ahorrando el uso de una variable temporal para la lista
        // y devolviendo directamente el resultado de la llamada funcional
        // que colecciona todos los objetos de tipo respuesta, resultado del método mapper
        return gastos.stream()
                .map(this::mapGastoToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public String actualizarGasto(Long id, GastoRequestDTO gastoRequestDTO) {
        // Defino un mensaje de éxito por default
        String response = "Se actualizó el gasto con éxito";
        Gasto gasto = mapDtoToGasto(gastoRequestDTO);
        Integer responsesUpdated = gastoRepository.actualizarGasto(id, gasto);
        // Si el update de BD no devolvió ningún registro actualizado, entonces devuelvo un mensaje de error
        if (responsesUpdated.equals(0)) {
            System.out.println("No se actualizó ningún registro con el id " + id);
        }
        System.out.println("Se actualiza la presentacion id: " + id);
        return response;
    }

    @Override
    public void borrarGasto(Long id) throws DAOException {
        gastoRepository.borrarGasto(id);
    }

    @Override
    public GastoResponseDTO obtenerGastoPorId(Long id) {
        Gasto gasto = gastoRepository.obtenerGastoPorId(id);
        // En este caso, estoy ahorrando el uso de una variable temporal
        // y devolviendo directamente el resultado del método privado
        return mapGastoToResponseDto(gasto);
    }

    private Gasto mapDtoToGasto(GastoRequestDTO gastoRequestDTO){
        Gasto gasto = new Gasto();
        gasto.setMonto(gastoRequestDTO.getMonto());
        gasto.setDescripcion(gastoRequestDTO.getDescripcion());
        gasto.setFecha(gastoRequestDTO.getFecha());
        gasto.setCategoria(gastoRequestDTO.getCategoria());
        return gasto;
    }

    private GastoResponseDTO mapGastoToResponseDto(Gasto gasto) {
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        gastoResponseDTO.setMonto(gasto.getMonto());
        gastoResponseDTO.setDescripcion(gasto.getDescripcion());
        gastoResponseDTO.setFecha(gasto.getFecha());
        gastoResponseDTO.setCategoria(gasto.getCategoria());
        return gastoResponseDTO;
    }


}