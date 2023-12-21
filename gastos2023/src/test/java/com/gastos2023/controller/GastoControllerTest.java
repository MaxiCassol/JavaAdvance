package com.gastos2023.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;
import com.gastos2023.service.GastoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    void testCrearGasto() throws Exception {
        GastoRequestDTO gastoRequestDTO = new GastoRequestDTO();
        gastoRequestDTO.setDescripcion("Compra de alimentos");
        gastoRequestDTO.setMonto(50.0);
        gastoRequestDTO.setFecha("2023-12-20");
        gastoRequestDTO.setCategoria("Alimentos");

        Gasto gasto = new Gasto();
        gasto.setId(1L);
        gasto.setDescripcion("Compra de alimentos");
        gasto.setMonto(50.0);
        gasto.setFecha("2023-12-20");
        gasto.setCategoria("Alimentos");

        when(gastoService.insertarGasto(any(GastoRequestDTO.class))).thenReturn(gasto);

        ResponseEntity<Gasto> response = gastoController.crearGasto(gastoRequestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(gasto, response.getBody());
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
    void testGetExpenseById() {
        Long id = 1L;
        GastoResponseDTO gastoResponseDTO = new GastoResponseDTO();
        gastoResponseDTO.setDescripcion("Compra de alimentos");
        gastoResponseDTO.setMonto(50.0);
        gastoResponseDTO.setFecha("2023-12-20");
        gastoResponseDTO.setCategoria("Alimentos");

        when(gastoService.obtenerGastoPorId(eq(id))).thenReturn(gastoResponseDTO);

        ResponseEntity<GastoResponseDTO> response = gastoController.getExpenseById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gastoResponseDTO, response.getBody());
    }

    @Test
    void testActualizarGasto() {
        Long id = 1L;
        GastoRequestDTO gastoRequestDTO = new GastoRequestDTO();
        gastoRequestDTO.setDescripcion("Compra actualizada");
        gastoRequestDTO.setMonto(60.0);
        gastoRequestDTO.setFecha("2023-12-21");
        gastoRequestDTO.setCategoria("Alimentos actualizados");

        Gasto gastoActualizado = new Gasto();
        gastoActualizado.setId(id);
        gastoActualizado.setDescripcion("Compra actualizada");
        gastoActualizado.setMonto(60.0);
        gastoActualizado.setFecha("2023-12-21");
        gastoActualizado.setCategoria("Alimentos actualizados");

        when(gastoService.actualizarGasto(eq(id), any(GastoRequestDTO.class))).thenReturn(gastoActualizado);

        ResponseEntity<Gasto> response = gastoController.actualizarGasto(id, gastoRequestDTO);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(gastoActualizado, response.getBody());
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
