package com.mintic.tiendafront.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProveedorResponse;

import reactor.core.publisher.Mono;

@Service
public class ClienteServicio implements ICliente {
	
	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	

	@Override
	public List<ClienteResponse> getClientes() {
		
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/cliente").retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public ClienteResponse nuevocliente(ClienteDto clienteDto) {
		
		try {
				
			ClienteResponse u = null;
			Mono<ClienteResponse> response = webClient.build().post().uri(URL + "/cliente")
					.body(Mono.just(clienteDto), ClienteResponse.class).retrieve().bodyToMono(ClienteResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteResponse ActualizarCliente(ClienteDto clienteDto, Long id) {
		
		try {
			
			ClienteResponse u = null;
			Mono<ClienteResponse> response = webClient.build().post().uri(URL + "/cliente" + id )
					.body(Mono.just(clienteDto), ClienteResponse.class).retrieve().bodyToMono(ClienteResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
	
	@Override
	public ClienteResponse buscarCliente(Long cedulaCliente) {
				
		try {

			Mono<ClienteResponse> response = webClient.build().get().uri(URL + "/cliente/" + cedulaCliente)
					.retrieve().bodyToMono(ClienteResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
		
		
	}

	@Override
	public int borrarCliente(Long cedulaCliente) {
		
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/cliente/" + cedulaCliente)
					.retrieve().bodyToMono(Integer.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0;
		}
	}

	
}
