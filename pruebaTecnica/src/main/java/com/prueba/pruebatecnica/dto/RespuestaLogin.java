package com.prueba.pruebatecnica.dto;

import lombok.Data;

@Data
public class RespuestaLogin {

    private int id;
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;

    public void setToken(String s) {
        this.accessToken = s;
    }
}
