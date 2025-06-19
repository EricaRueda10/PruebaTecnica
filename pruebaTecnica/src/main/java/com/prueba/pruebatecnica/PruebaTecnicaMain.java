package com.prueba.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/* Clase principal que inicia la aplicación Spring Boot. Se usa la anotación
	@EnableFeignClients para habilitar el uso de clientes Feign. */

@SpringBootApplication
@EnableFeignClients
public class PruebaTecnicaMain {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaMain.class, args);
    }

}