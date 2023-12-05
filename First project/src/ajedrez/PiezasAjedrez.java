package ajedrez;

public class PiezasAjedrez {
    private String cantidadDeCasillasAvanza;
    private String direccionDeMovimiento;

    public PiezasAjedrez(String cantidadDeCasillasAvanza, String direccionDeMovimiento){
        this.cantidadDeCasillasAvanza = cantidadDeCasillasAvanza;
        this.direccionDeMovimiento = direccionDeMovimiento;
    }

    public String getCantidadDeCasillasAvanza() {
        return cantidadDeCasillasAvanza;
    }

    public String getDireccionDeMovimiento() {
        return direccionDeMovimiento;
    }

}
