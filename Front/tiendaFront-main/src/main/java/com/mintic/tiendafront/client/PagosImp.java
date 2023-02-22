package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.PagosDto;
import com.mintic.tiendafront.dto.PagosResponse;

import reactor.core.publisher.Mono;

public class PagosImp implements IPagos{
    private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<PagosResponse> getPagos() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Pagos").retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public PagosResponse nuevoPagos(PagosDto PagosDto) {

		try {

			PagosResponse u = null;
			Mono<PagosResponse> response = webClient.build().post().uri(URL + "/CrearPagos")
					.body(Mono.just(PagosDto), PagosResponse.class).retrieve()
					.bodyToMono(PagosResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public PagosResponse ActualizarPagos(PagosDto PagosDto, Long CodigoVenta, String FechaPago) {

		try {

			PagosResponse u = null;
			Mono<PagosResponse> response = webClient.build().patch().uri(URL + "/actualizarPagos/" + CodigoVenta + "/" + FechaPago)
					.body(Mono.just(PagosDto), PagosResponse.class).retrieve()
					.bodyToMono(PagosResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public PagosResponse buscarPagos(Long CodigoVenta, String FechaPago) {
		// TODO Auto-generated method stub
		try {

			Mono<PagosResponse> response = webClient.build().get().uri(URL + "/Pagos/fecha/pago/" + CodigoVenta + "/" + FechaPago)
					.retrieve().bodyToMono(PagosResponse.class);
			
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public int borrarPagos(Long CodigoVenta, String FechaPago) {
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/eliminarPagos/" + CodigoVenta + "/" + FechaPago)
					.retrieve().bodyToMono(Integer.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0;
		}
	}

    @Override
	public List<PagosResponse> PagosByCliente(Long documentoCliente) {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Pagos/cliente/" + documentoCliente).retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

    @Override
	public List<PagosResponse> PagosByFechaVenta(String FechaVenta) {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Pagos/venta/fechaventa/"+ FechaVenta).retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

    
}
