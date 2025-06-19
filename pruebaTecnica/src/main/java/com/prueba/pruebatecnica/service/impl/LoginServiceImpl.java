package com.prueba.pruebatecnica.service.impl;

import com.prueba.pruebatecnica.dto.RespuestaLogin;
import com.prueba.pruebatecnica.dto.RespuestaUsuario;
import com.prueba.pruebatecnica.dto.SolicitudLogin;
import com.prueba.pruebatecnica.feign.DummyJson;
import com.prueba.pruebatecnica.model.Login;
import com.prueba.pruebatecnica.repository.LoginRepository;
import com.prueba.pruebatecnica.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/* Implementación del servicio de login que se comunica con la API DummyJSON,
   guarda la sesión en la base de datos y retorna los datos del usuario autenticado. */

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final DummyJson usuario;
    private final LoginRepository loginRepository;
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public RespuestaUsuario loginObtenerUsuario(SolicitudLogin request) {

        RespuestaLogin respuestaLogin = usuario.login(request);

        String authorization = "Bearer " + respuestaLogin.getAccessToken();
        RespuestaUsuario user = usuario.getMe(authorization);

        Login inicioSesion = Login.builder()
                .username(user.getUsername())
                .loginTime(LocalDateTime.now())
                .accessToken(respuestaLogin.getAccessToken())
                .refreshToken(respuestaLogin.getRefreshToken())
                .build();
        loginRepository.save(inicioSesion);
        log.info("Login guardado en BD: {}", inicioSesion.getUsername());

        return user;
    }
}