package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.VendedorDto;
import com.mintic.tiendafront.dto.VendedorResponse;

import reactor.core.publisher.Mono;

@Service
public class VendedorImp implements IVendedor {

	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<VendedorResponse> ListarVendedors() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Vendedoreslistar").retrieve()
					.bodyToMono(List.class);
			// System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public VendedorResponse nuevoVendedor(VendedorDto VendedorDto) {

		try {
			VendedorResponse u = null;
			Mono<VendedorResponse> response = webClient.build().post().uri(URL + "/Vendedor")
					.body(Mono.just(VendedorDto), VendedorResponse.class).retrieve().bodyToMono(VendedorResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public VendedorResponse buscarVendedor(String nombreVendedor) {
		try {

			Mono<VendedorResponse> response = webClient.build().get().uri(URL + "/Vendedor/" + nombreVendedor)
					.retrieve().bodyToMono(VendedorResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public void borrarVendedor(String nombreVendedor) {
		try {

			webClient.build().delete().uri(URL + "/Vendedor/" + nombreVendedor)
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}

	@Override
	public VendedorResponse ActualizarVendedor(VendedorDto VendedorDto, String nombreVendedor) {

		try {

			VendedorResponse u = null;
			Mono<VendedorResponse> response = webClient.build().post().uri(URL + "/Vendedor" + nombreVendedor)
					.body(Mono.just(VendedorDto), VendedorResponse.class).retrieve().bodyToMono(VendedorResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

}
