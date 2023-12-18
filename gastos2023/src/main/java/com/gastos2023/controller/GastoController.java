package com.gastos2023.controller;


import com.gastos2023.dto.GastoDTO;
import com.gastos2023.model.Gasto;
import com.gastos2023.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {
    @Autowired
    private GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public ResponseEntity<Gasto> crearGasto(@RequestBody GastoDTO gastoDTO) {
        Gasto response = gastoService.insertarGasto(gastoDTO);
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Gasto>> obtenerTodosLosGastos() {
        // Endpoint para obtener todos los gastos (GET)
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizarGasto(@PathVariable Long id, @RequestBody GastoDTO gastoDTO) {
        // Endpoint para actualizar un gasto (PUT)
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarGasto(@PathVariable Long id) {
        // Endpoint para borrar un gasto (DELETE)
        return null;
    }
}