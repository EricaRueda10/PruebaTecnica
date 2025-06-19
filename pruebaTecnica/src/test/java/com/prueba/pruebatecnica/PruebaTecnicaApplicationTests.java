package com.prueba.pruebatecnica;

import com.prueba.pruebatecnica.dto.RespuestaLogin;
import com.prueba.pruebatecnica.dto.RespuestaUsuario;
import com.prueba.pruebatecnica.dto.SolicitudLogin;
import com.prueba.pruebatecnica.feign.DummyJson;
import com.prueba.pruebatecnica.repository.LoginRepository;
import com.prueba.pruebatecnica.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PruebaTecnicaApplicationTests {

	@Mock
	private DummyJson dummyJson;

	@Mock
	private LoginRepository loginRepository;

	@InjectMocks
	private LoginServiceImpl loginService;

	@Test
	public void loginObtenerUsuarioTest() {

		SolicitudLogin request = new SolicitudLogin();
		request.setUsername("lilyb");
		request.setPassword("lilybpass");

		RespuestaLogin mockRespuestaLogin = new RespuestaLogin();
		mockRespuestaLogin.setToken("dummyAccessToken");
		mockRespuestaLogin.setRefreshToken("dummyRefreshToken");

		RespuestaUsuario mockUsuario = new RespuestaUsuario();
		mockUsuario.setUsername("lilyb");

		Mockito.when(dummyJson.login(request)).thenReturn(mockRespuestaLogin);
		Mockito.when(dummyJson.getMe("Bearer dummyAccessToken")).thenReturn(mockUsuario);

		RespuestaUsuario usuario = loginService.loginObtenerUsuario(request);

		assertEquals("lilyb", usuario.getUsername());
	}
}
