package persona;

public class Programador extends Persona {
    private int edad;

    public int isEdad() {
        return edad;
    }

    public Programador(int edad) {
        this.edad = edad;
    }

    public Programador(int dni, String nombre, String apellido, int edad) {
        super(dni, nombre, apellido);
        this.edad = edad;
    }
}
