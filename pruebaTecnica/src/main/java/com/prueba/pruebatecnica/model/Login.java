package com.prueba.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/* Entidad JPA que representa un inicio de sesión registrado en la base de datos. */

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private LocalDateTime loginTime;
    @Column(length = 1000)
    private String accessToken;
    @Column(length = 1000)
    private String refreshToken;
}
