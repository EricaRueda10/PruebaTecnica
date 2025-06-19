package com.prueba.pruebatecnica.feign;

import com.prueba.pruebatecnica.dto.RespuestaLogin;
import com.prueba.pruebatecnica.dto.RespuestaUsuario;
import com.prueba.pruebatecnica.dto.SolicitudLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/* Cliente Feign para comunicarse con la API externa DummyJSON. */

@FeignClient(name = "dummyJson", url = "${dummyjson.base-url}")
public interface DummyJson {

    @PostMapping("/auth/login")
    RespuestaLogin login(@RequestBody SolicitudLogin solicitudLogin);

    @GetMapping("/auth/me")
    RespuestaUsuario getMe(@RequestHeader("Authorization") String accessToken);
}