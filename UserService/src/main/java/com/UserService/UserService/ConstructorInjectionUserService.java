package com.UserService.UserService;
import com.UserService.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructorInjectionUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public ConstructorInjectionUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllUsers() {
        // Implementa la lógica para obtener usuarios desde userRepository
        return userRepository.getAllUsers();
    }
}
