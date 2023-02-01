package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.CarteraDto;
import com.mintic.tiendafront.dto.CarteraResponse;

import reactor.core.publisher.Mono;

@Service
public class CarteraImp implements ICartera {

	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<CarteraResponse> ListarCarteras() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/carteras").retrieve()
					.bodyToMono(List.class);
			// System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public CarteraResponse nuevaCartera(CarteraDto CarteraDto) {

		try {
			CarteraResponse u = null;
			Mono<CarteraResponse> response = webClient.build().post().uri(URL + "/Cartera")
					.body(Mono.just(CarteraDto), CarteraResponse.class).retrieve().bodyToMono(CarteraResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public CarteraResponse buscarCartera(String nombreCliente) {
		try {

			Mono<CarteraResponse> response = webClient.build().get().uri(URL + "/Cartera/" + nombreCliente)
					.retrieve().bodyToMono(CarteraResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public CarteraResponse ActualizarCartera(CarteraDto CarteraDto, String nombreCliente) {

		try {

			CarteraResponse u = null;
			Mono<CarteraResponse> response = webClient.build().post().uri(URL + "/Cartera" + nombreCliente)
					.body(Mono.just(CarteraDto), CarteraResponse.class).retrieve().bodyToMono(CarteraResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

}
