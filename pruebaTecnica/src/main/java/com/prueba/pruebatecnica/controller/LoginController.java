package com.prueba.pruebatecnica.controller;

import com.prueba.pruebatecnica.dto.RespuestaUsuario;
import com.prueba.pruebatecnica.dto.SolicitudLogin;
import com.prueba.pruebatecnica.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Controlador REST encargado de gestionar las solicitudes de autenticación. */

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public RespuestaUsuario respuestaUsuario(@RequestBody SolicitudLogin solicitudLogin) {

        return loginService.loginObtenerUsuario(solicitudLogin);
    }
}
