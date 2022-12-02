package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorResponse;

import reactor.core.publisher.Mono;

@Service
public class ProveedorServicio implements IProveedor {

	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<ProveedorResponse> getProveedores() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/proveedores").retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public ProveedorResponse nuevoProveedor(Proveedor proveedorDto) {
			
		
		try {
			
			ProveedorResponse u = null;
			Mono<ProveedorResponse> response = webClient.build().post().uri(URL + "/proveedor")
					.body(Mono.just(proveedorDto), ProveedorResponse.class).retrieve().bodyToMono(ProveedorResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
	@Override
	public ProveedorResponse ActualizarProveedor(Proveedor proveedorDto, Long nit) {
			
		
		try {
			
			ProveedorResponse u = null;
			Mono<ProveedorResponse> response = webClient.build().post().uri(URL + "/proveedor/" + nit)
					.body(Mono.just(proveedorDto), ProveedorResponse.class).retrieve().bodyToMono(ProveedorResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public ProveedorResponse buscarProveedor(Long nit) {
		// TODO Auto-generated method stub
		try {

			Mono<ProveedorResponse> response = webClient.build().get().uri(URL + "/proveedor/" + nit)
					.retrieve().bodyToMono(ProveedorResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public int borrarProveedor(Long nit) {
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/proveedor/" + nit)
					.retrieve().bodyToMono(Integer.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0;
		}
	}


}
