package persona2;

import java.util.Arrays;
import java.util.List;

class Persona {
    String nombre;
    String edad;
    String hobby;

    public Persona(String nombre, String edad, String hobby) {
        this.nombre = nombre;
        this.edad = edad;
        this.hobby = hobby;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getHobby() {
        return hobby;
    }
}

