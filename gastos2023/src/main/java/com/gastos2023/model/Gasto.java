package com.gastos2023.model;


public class Gasto {

    private Long id;
    private String descripcion;
    private double monto;
    private String fecha;
    private String categoria;

    public Gasto() {
    }

    public Gasto(String descripcion, double monto, String fecha, String categoria) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public Gasto(long id, String descripcion, double monto, String fecha, String categoria) {
    }

    public Long getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setId(Long id) {
        this.id = id;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setId(long id) {
    }
}
