package com.gastos2023.controller;


import com.gastos2023.dto.request.GastoRequestDTO;
import com.gastos2023.dto.response.GastoResponseDTO;
import com.gastos2023.exception.DAOException;
import com.gastos2023.model.Gasto;
import com.gastos2023.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {
    @Autowired
    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public ResponseEntity<Gasto> crearGasto(@RequestBody GastoRequestDTO gastoRequestDTO) {
        Gasto response = gastoService.insertarGasto(gastoRequestDTO);
        System.out.println("GastoController: creando un gasto");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<GastoResponseDTO>> obtenerTodosLosGastos() {
        List<GastoResponseDTO> responses = gastoService.obtenerTodosLosGastos();
        System.out.println("GastoController: obteniendo todos los gastos");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GastoResponseDTO> getExpenseById(@PathVariable Long id) {
        GastoResponseDTO gastoResponseDTO = gastoService.obtenerGastoPorId(id);
        System.out.println("GastoController: obteniendo el gasto con id: " + id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gastoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizarGasto(@RequestParam Long id, @RequestBody GastoRequestDTO gastoRequestDTO) {
        Gasto response = gastoService.actualizarGasto(id, gastoRequestDTO);
        System.out.println("GastoController: actualizando el gasto");
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarGasto(@PathVariable Long id) throws DAOException {
        gastoService.borrarGasto(id);
        System.out.println("ExpenseController: eliminando el gasto");
        return ResponseEntity
                .status(HttpStatus.GONE)
                .body("Se eliminó el gasto con id: " + id);
    }
}