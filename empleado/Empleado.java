package empleado;

public class Empleado {
    private int id;
    private String nombre;
    private double salario;

    // Constructores, getters y setters

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", salario=" + salario + "]";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
