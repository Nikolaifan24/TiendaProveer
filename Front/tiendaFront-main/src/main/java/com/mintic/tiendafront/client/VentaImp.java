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
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.DetalleVentaResponse;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;

import reactor.core.publisher.Mono;

@Service
public class VentaImp implements IVenta {

	private static final String URL = "http://localhost:8090/tienda";

	@Autowired
	private WebClient.Builder webClient;

	@Autowired
	IVenta iVenta;

	@Override
	public VentaResponse buscarVentaCodigo(Long CodigoVenta) {
		try {

			Mono<VentaResponse> response = webClient.build().get()
					.uri(URL + "/BuscarVentaPorCodigo/" + CodigoVenta)
					.retrieve().bodyToMono(VentaResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public VentaResponse guardarVenta(VentaDto VentaDto) {

		try {
			VentaResponse u = null;
			Mono<VentaResponse> response = webClient.build().post().uri(URL + "/crearVentas")
					.body(Mono.just(VentaDto),VentaResponse.class).retrieve().bodyToMono(VentaResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public void eliminarVenta(Long CodigoVenta) {
		try {

			webClient.build().delete().uri(URL + "/eliminarVentas/" + CodigoVenta )
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}

	@Override
	public void eliminarDetalleVenta(Long CodigoVenta, String nombreProducto) {
		try {

			webClient.build().delete().uri(URL + "/eliminarDetalleVentas/" + CodigoVenta +"/"+ nombreProducto )
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		}
	}


	@Override
	public VentaResponse ActualizarVenta(VentaDto ventaDto, Long CodigoVenta) {

		try {

			VentaResponse u = null;
			Mono<VentaResponse> response = webClient.build().patch().uri(URL + "/actualizarVenta/" + CodigoVenta)
					.body(Mono.just(ventaDto), VentaResponse.class).retrieve().bodyToMono(VentaResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<VentaResponse> ListarVentas() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Ventaslistar").retrieve()
					.bodyToMono(List.class);
			System.out.println("esto es una venta" + response.block());
			return response.block();
		} catch (Exception e) {

			return null;
		}
	}


	@Override
	public List<VentaResponse> ListarVentasporProducto(String nombreProducto) {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Ventaslistar/producto/"+ nombreProducto).retrieve()
					.bodyToMono(List.class);
			System.out.println("esto es una venta" + response.block());
			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<DetalleVentaResponse> ListarDetalleVentas(Long CodigoVenta) {
		System.out.println("estoy entrando al metodo");
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Ventas/detalle/" + CodigoVenta).retrieve()
					.bodyToMono(List.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<DetalleVentaResponse> ListarunDetalledeVentas(Long CodigoVenta, String nombreProducto) {
		System.out.println("estoy entrando al metodo");
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Ventas/detalle/codigo/" + CodigoVenta +"/"+ nombreProducto).retrieve()
					.bodyToMono(List.class);
			System.out.println(response.block() + "estoy saliendo del try");
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}
	
	@Override
	public DetalleVentaResponse nuevoVentaDetalle(Long CodigoCompra, DetalleVentaDto detalle) {

		try {
			DetalleVentaResponse u = null;
			Mono<DetalleVentaResponse> response = webClient.build().post()
					.uri(URL + "/crearVentas/detalles/" + CodigoCompra)
					.body(Mono.just(detalle), DetalleVentaResponse.class).retrieve()
					.bodyToMono(DetalleVentaResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
	@Override
	public DetalleVentaResponse ActualizarDetalleVenta(Long CodigoVenta, String nombreProducto, DetalleVentaDto detalleventaDto) {

		try {

			DetalleVentaResponse u = null;
			Mono<DetalleVentaResponse> response = webClient.build().patch().uri(URL + "/Ventas/actualizar/detalles/" + CodigoVenta + "/" + nombreProducto)
					.body(Mono.just(detalleventaDto), DetalleVentaResponse.class).retrieve().bodyToMono(DetalleVentaResponse.class);

			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public Integer ContadordeVentas(Long CodigoVenta) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Integer> response = webClient.build().get().uri(URL + "/Ventas/conteo/codigo/" + CodigoVenta)
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
	public Double totalVenta(Long CodigoVenta) {
		try {
			/*
			 * aqui nos conectamos al back directamente al controlador donde estan las rutas
			 * el back espera recibir un dto por eso enviamos el dto login dto
			 */

			Mono<Double> response = webClient.build().get().uri(URL + "/Ventas/detalle-total/codigo/" + CodigoVenta)
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
	public DetalleVentaResponse DetalladeunaVenta(Long CodigoVenta, String nombreProducto) {
		try {

			Mono<DetalleVentaResponse> response = webClient.build().get()
					.uri(URL + "/Ventas/detalle/codigo/" + CodigoVenta + "/" + nombreProducto)
					.retrieve().bodyToMono(DetalleVentaResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}
}
