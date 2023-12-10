package com.ApiRESTful.ApiRESTful.entity;

public class Elemento {

    private String nombre;

    public Elemento() {
        // Constructor predeterminado requerido por Spring
    }

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
