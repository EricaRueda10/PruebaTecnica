package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.dto.RespuestaUsuario;
import com.prueba.pruebatecnica.dto.SolicitudLogin;

public interface LoginService {
    RespuestaUsuario loginObtenerUsuario(SolicitudLogin request);
}
