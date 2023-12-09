package com.UserService.UserService.repository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<String> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
        // Inicialización con algunos usuarios ficticios
        users.add("Usuario1");
        users.add("Usuario2");
        users.add("Usuario3");
    }

    @Override
    public List<String> getAllUsers() {
        return new ArrayList<>(users); // Devuelve una copia de la lista para evitar modificaciones externas
    }

    // Otros métodos relacionados con la manipulación de usuarios pueden implementarse aquí
}
