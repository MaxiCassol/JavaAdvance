package com.ApiRESTful.ApiRESTful.service.impl;

import com.ApiRESTful.ApiRESTful.entity.Elemento;
import com.ApiRESTful.ApiRESTful.service.ElementoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementoServiceImpl implements ElementoService {

    private List<Elemento> elementos = new ArrayList<>();

    @Override
    public Elemento crearElemento(Elemento elemento) {
        elementos.add(elemento);
        return elemento;
    }

    @Override
    public List<Elemento> obtenerElementos() {
        return new ArrayList<>(elementos);
    }
}


