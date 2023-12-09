package com.UserService.UserService;

import com.UserService.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldInjectionUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<String> getAllUsers() {
        // Implementa la lógica para obtener usuarios desde userRepository
        return userRepository.getAllUsers();
    }
}

