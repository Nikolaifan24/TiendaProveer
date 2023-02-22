package com.mintic.tiendafront.client;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.DetalleDevolucionesDto;
import com.mintic.tiendafront.dto.DetalleDevolucionesResponse;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.DetalleDevolucionesDto;
import com.mintic.tiendafront.dto.DevolucionesDto;
import com.mintic.tiendafront.dto.DevolucionesResponse;

import reactor.core.publisher.Mono;

@Service
public class DevolucionesImp implements IDevoluciones{
    private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Autowired
	IDevoluciones iDevoluciones;

	@Override
	public DevolucionesResponse buscarDevolucionesCodigo(Long CodigoDevoluciones) {
		try {

			Mono<DevolucionesResponse> response = webClient.build().get()
					.uri(URL + "/BuscarDevolucionesPorCodigo/" + CodigoDevoluciones)
					.retrieve().bodyToMono(DevolucionesResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public DevolucionesResponse guardarDevoluciones(DevolucionesDto DevolucionesDto) {

		try {
			DevolucionesResponse u = null;
			Mono<DevolucionesResponse> response = webClient.build().post().uri(URL + "/crearDevoluciones")
					.body(Mono.just(DevolucionesDto),DevolucionesResponse.class).retrieve().bodyToMono(DevolucionesResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public void eliminarDevoluciones(Long CodigoDevoluciones) {
		try {

			webClient.build().delete().uri(URL + "/eliminarDevoluciones/" + CodigoDevoluciones )
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}

	@Override
	public void eliminarDetalleDevoluciones(Long CodigoDevoluciones, String nombreProducto) {
		try {

			webClient.build().delete().uri(URL + "/eliminarDetalleDevoluciones/" + CodigoDevoluciones +"/"+ nombreProducto )
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}


	@Override
	public DevolucionesResponse ActualizarDevoluciones(DevolucionesDto DevolucionesDto, Long CodigoDevoluciones) {

		try {

			DevolucionesResponse u = null;
			Mono<DevolucionesResponse> response = webClient.build().patch().uri(URL + "/actualizarDevoluciones/" + CodigoDevoluciones)
					.body(Mono.just(DevolucionesDto), DevolucionesResponse.class).retrieve().bodyToMono(DevolucionesResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<DevolucionesResponse> ListarDevoluciones() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Devolucioneslistar").retrieve()
					.bodyToMono(List.class);
			System.out.println("esto es una Devoluciones" + response.block());
			return response.block();
		} catch (Exception e) {

			return null;
		}
	}


	@Override
	public List<DevolucionesResponse> ListarDevolucionesporProducto(String nombreProducto) {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Devolucioneslistar/producto/"+ nombreProducto).retrieve()
					.bodyToMono(List.class);
			System.out.println("esto es una Devoluciones" + response.block());
			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<DetalleDevolucionesResponse> ListarDetalleDevoluciones(Long CodigoDevoluciones) {
		System.out.println("estoy entrando al metodo");
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Devoluciones/detalle/" + CodigoDevoluciones).retrieve()
					.bodyToMono(List.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<DetalleDevolucionesResponse> ListarunDetalledeDevoluciones(Long CodigoDevoluciones, String nombreProducto) {
		System.out.println("estoy entrando al metodo");
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Devoluciones/detalle/codigo/" + CodigoDevoluciones +"/"+ nombreProducto).retrieve()
					.bodyToMono(List.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}
	
	@Override
	public DetalleDevolucionesResponse nuevoDevolucionesDetalle(Long CodigoCompra, DetalleDevolucionesDto detalle) {

		try {
			DetalleDevolucionesResponse u = null;
			Mono<DetalleDevolucionesResponse> response = webClient.build().post()
					.uri(URL + "/crearDevoluciones/detalles/" + CodigoCompra)
					.body(Mono.just(detalle), DetalleDevolucionesResponse.class).retrieve()
					.bodyToMono(DetalleDevolucionesResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
	@Override
	public DetalleDevolucionesResponse ActualizarDetalleDevoluciones(Long CodigoDevoluciones, String nombreProducto, DetalleDevolucionesDto detalleDevolucionesDto) {

		try {

			DetalleDevolucionesResponse u = null;
			Mono<DetalleDevolucionesResponse> response = webClient.build().patch().uri(URL + "/Devoluciones/actualizar/detalles/" + CodigoDevoluciones + "/" + nombreProducto)
					.body(Mono.just(detalleDevolucionesDto), DetalleDevolucionesResponse.class).retrieve().bodyToMono(DetalleDevolucionesResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public Integer ContadordeDevoluciones(Long CodigoDevoluciones) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Integer> response = webClient.build().get().uri(URL + "/Devoluciones/conteo/codigo/" + CodigoDevoluciones)
					.retrieve()
					.bodyToMono(Integer.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0;
		}

	}

	@Override
	public Integer ContadordeDetalleDevoluciones(Long CodigoDevoluciones, String nombreProducto) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Integer> response = webClient.build().get().uri(URL + "/Devoluciones/conteo/detalle/" + CodigoDevoluciones + "/" + nombreProducto)
					.retrieve()
					.bodyToMono(Integer.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0;
		}

	}

	@Override
	public Double totalDevoluciones(Long CodigoDevoluciones) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Double> response = webClient.build().get().uri(URL + "/Devoluciones/detalle-total/codigo/" + CodigoDevoluciones)
					.retrieve()
					.bodyToMono(Double.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return 0.0;
		}

	}

	@Override
	public DetalleDevolucionesResponse DetalladeunaDevoluciones(Long CodigoDevoluciones, String nombreProducto) {
		try {

			Mono<DetalleDevolucionesResponse> response = webClient.build().get()
					.uri(URL + "/Devoluciones/detalle/codigo/" + CodigoDevoluciones + "/" + nombreProducto)
					.retrieve().bodyToMono(DetalleDevolucionesResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

}
