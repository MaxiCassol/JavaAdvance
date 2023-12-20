package com.gastos2023.dto.request;

public class GastoRequestDTO {
    private String descripcion;
    private double monto;

    private String fecha;

    private String categoria;

    public GastoRequestDTO() {
    }

    public GastoRequestDTO(String descripcion, double monto, String fecha, String categoria) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                ", descripcion=" + descripcion + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha + '\'' +
                ", categoria='" + categoria +
                '}';
    }
}
