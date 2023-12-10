package com.ApiRESTful.ApiRESTful.controller;

import com.ApiRESTful.ApiRESTful.entity.Elemento;
import com.ApiRESTful.ApiRESTful.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ElementoService elementoService;

    @Autowired
    public ApiController(ElementoService elementoService) {
        this.elementoService = elementoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Elemento> crearElemento(@RequestBody Elemento elemento) {
        return ResponseEntity.ok(elementoService.crearElemento(elemento));
    }

    @GetMapping("/elementos")
    public ResponseEntity<List<Elemento>> obtenerElementos() {
        return ResponseEntity.ok(elementoService.obtenerElementos());
    }
}

