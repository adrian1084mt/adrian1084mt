package com.tienda.skate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTiendaApplication.class, args);
        System.err.println("Ya esta en ejecucion");
    }
}
