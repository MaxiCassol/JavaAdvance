package com.gastos2023.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;
import com.gastos2023.service.GastoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class GastoControllerTest {
    @Mock
    private GastoService gastoService;

    @InjectMocks
    private GastoController gastoController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }
    @Test
    void testCrearGasto() {
        // Arrange
        GastoRequestDTO gastoRequestDTO = new GastoRequestDTO(/* Provide necessary values */);
        String expectedResponse = "Expected response from service";

        when(gastoService.insertarGasto(any(GastoRequestDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> responseEntity = gastoController.crearGasto(gastoRequestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    void testObtenerTodosLosGastos() throws Exception {
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        gastoResponseDTO.setDescripcion("Compra de alimentos");
        gastoResponseDTO.setMonto(50.0);
        gastoResponseDTO.setFecha("2023-12-20");
        gastoResponseDTO.setCategoria("Alimentos");

        List<GastoResponseDTO> gastos = Arrays.asList(gastoResponseDTO);

        when(gastoService.obtenerTodosLosGastos()).thenReturn(gastos);

        ResponseEntity<List<GastoResponseDTO>> response = gastoController.obtenerTodosLosGastos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gastos, response.getBody());
    }

    @Test
    void testObtenerGastoPorId() {
        Long id = 1L;
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        gastoResponseDTO.setDescripcion("Compra de alimentos");
        gastoResponseDTO.setMonto(50.0);
        gastoResponseDTO.setFecha("2023-12-20");
        gastoResponseDTO.setCategoria("Alimentos");

        when(gastoService.obtenerGastoPorId(eq(id))).thenReturn(gastoResponseDTO);

        ResponseEntity<GastoResponseDTO> response = gastoController.obtenerGastoPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gastoResponseDTO, response.getBody());
    }

    @Test
    void testActualizarGasto() {
        // Arrange
        Long gastoId = 1L; // Provide the gastoId you want to update
        GastoRequestDTO gastoRequestDTO = new GastoRequestDTO(); // Provide the updated data
        String expectedResponse = "Gasto actualizado"; // Provide the expected response
        when(gastoService.actualizarGasto(gastoId, gastoRequestDTO)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> responseEntity = gastoController.actualizarGasto(gastoId, gastoRequestDTO);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
    @Test
    void testBorrarGasto() throws DAOException {
        Long id = 1L;

        ResponseEntity<String> response = gastoController.borrarGasto(id);

        verify(gastoService, times(1)).borrarGasto(eq(id));
        assertEquals(HttpStatus.GONE, response.getStatusCode());
        assertEquals("Se eliminó el gasto con id: " + id, response.getBody());
    }
}
