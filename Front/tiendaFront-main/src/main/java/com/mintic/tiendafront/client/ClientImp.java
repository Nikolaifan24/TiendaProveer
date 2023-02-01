package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.LoginDto;
// import com.mintic.tiendafront.dto.TipoDocumento;
import com.mintic.tiendafront.dto.UsuarioDto;
import com.mintic.tiendafront.dto.UsuarioResponse;

import reactor.core.publisher.Mono;

@Service
public class ClientImp implements IClientTienda {

	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public Long login(LoginDto loginDto) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Long> response = webClient.build().post().uri(URL + "/loginclient")
					.accept(MediaType.APPLICATION_JSON).body(Mono.just(loginDto), LoginDto.class).retrieve()
					.bodyToMono(Long.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0l;
		}

	}

	@Override
	public List<UsuarioResponse> getUsuarios() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/usuarioslistar").retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public UsuarioResponse nuevoUsuario(UsuarioDto usuarioDto) {

		try {
			UsuarioResponse u = null;
			Mono<UsuarioResponse> response = webClient.build().post().uri(URL + "/crearUsuario")
					.body(Mono.just(usuarioDto), UsuarioResponse.class).retrieve().bodyToMono(UsuarioResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public UsuarioResponse buscarUsuario(String nombreUsuario) {
		try {

			Mono<UsuarioResponse> response = webClient.build().get().uri(URL + "/usuario/" + nombreUsuario)
					.retrieve().bodyToMono(UsuarioResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public void borrarUsuario(String nombreUsuario) {
		try {

			webClient.build().delete().uri(URL + "/eliminarUsuario/" + nombreUsuario)
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}

	@Override
	public UsuarioResponse ActualizarUsuario(UsuarioDto UsuarioDto, String nombreUsuario) {

		try {

			UsuarioResponse u = null;
			Mono<UsuarioResponse> response = webClient.build().patch().uri(URL + "/actualizarUsuario/" + nombreUsuario)
					.body(Mono.just(UsuarioDto), UsuarioResponse.class).retrieve().bodyToMono(UsuarioResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

}
