package com.UserService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionExampleApplication implements CommandLineRunner {

    @Autowired
    private ConstructorInjectionUserService constructorInjectionUserService;

    @Autowired
    private SetterInjectionUserService setterInjectionUserService;

    @Autowired
    private FieldInjectionUserService fieldInjectionUserService;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        executeExample();
    }

    public void executeExample() {
        System.out.println("Constructor Injection: " + constructorInjectionUserService.getAllUsers());
        System.out.println("Setter Injection: " + setterInjectionUserService.getAllUsers());
        System.out.println("Field Injection: " + fieldInjectionUserService.getAllUsers());
    }
}

