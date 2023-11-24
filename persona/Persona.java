package persona;
public class Persona {
    private int dni;
    private String nombre;
    private String apellido;

    public Persona(){
    }

    public Persona(int dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    void Abrazar(){
        System.out.println("abrazando");
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
