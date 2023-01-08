package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;
import com.mintic.tiendafront.dto.ComprasResponse;

import reactor.core.publisher.Mono;

@Service
public class CompraImp implements ICompra{

    private static final String URL = "http://localhost:8091/tienda";

    @Autowired
	private WebClient.Builder webClient;

    @Override
	public List<ComprasResponse> ListarCompras() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Compraslistar").retrieve()
					.bodyToMono(List.class);
			// System.out.println(response.block() + "estoy saliendo del try");	
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public ComprasResponse nuevoCompra(ComprasDto CompraDto) {
				
		try {
			ComprasResponse u = null;
			Mono<ComprasResponse> response = webClient.build().post().uri(URL + "/Compra")
					.body(Mono.just(CompraDto), ComprasResponse.class).retrieve().bodyToMono(ComprasResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public ComprasResponse buscarCompra(String fechaCompra) {
		try {

			Mono<ComprasResponse> response = webClient.build().get().uri(URL + "/Compra/" + fechaCompra)
					.retrieve().bodyToMono(ComprasResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

		
	@Override
	public ComprasResponse ActualizarCompra(ComprasDto CompraDto, String fechaCompra) {
		
		try {
			
			ComprasResponse u = null;
			Mono<ComprasResponse> response = webClient.build().post().uri(URL + "/Compra" + fechaCompra )
					.body(Mono.just(CompraDto), ComprasResponse.class).retrieve().bodyToMono(ComprasResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}	


    


}
