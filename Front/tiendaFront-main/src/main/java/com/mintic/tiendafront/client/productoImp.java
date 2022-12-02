package com.mintic.tiendafront.client;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.ProductoDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class productoImp implements IProducto {
	
	private static final String URL = "http://localhost:8090/tienda";
	
	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<ProductoDto> getProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearProducto(ProductoDto producto) {
		try {
			webClient.build().post().uri(URL + "/producto")
			.body(Mono.just(producto), Void.class)
			.retrieve().bodyToMono(Void.class).block();
			
		
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		
		}
		
	}


	@Override
	public ProductoDto buscarProductoPorCodigo(Long codigoProducto) {
		try {
			Mono<ProductoDto> response = webClient.build().get().uri(URL + "/producto/" + codigoProducto)
					.retrieve().bodyToMono(ProductoDto.class);
			return response.block();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	

}
