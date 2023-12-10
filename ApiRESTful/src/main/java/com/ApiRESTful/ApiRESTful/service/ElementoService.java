package com.ApiRESTful.ApiRESTful.service;

import com.ApiRESTful.ApiRESTful.entity.Elemento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/elemento")
public interface ElementoService {

    @PostMapping("/crear")
    Elemento crearElemento(@RequestBody Elemento elemento);

    @GetMapping("/obtenerTodos")
    List<Elemento> obtenerElementos();
}
