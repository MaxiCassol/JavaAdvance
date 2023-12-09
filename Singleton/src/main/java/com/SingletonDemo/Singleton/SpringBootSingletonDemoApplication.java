package com.SingletonDemo.Singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootSingletonDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSingletonDemoApplication.class, args);

        // Crear dos instancias de SingletonDemo
        SingletonDemo instance1 = context.getBean(SingletonDemo.class);
        SingletonDemo instance2 = context.getBean(SingletonDemo.class);

        // Comparar las instancias e imprimir un mensaje
        if (instance1 == instance2) {
            System.out.println("Ambas instancias son iguales (mismo objeto).");
        } else {
            System.out.println("Las instancias son diferentes.");
        }
    }
}
