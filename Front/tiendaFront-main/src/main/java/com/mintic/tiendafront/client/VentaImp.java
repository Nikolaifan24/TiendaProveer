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
	public void guardarVenta(VentaDto totalVenta, Long idUsuario, ClienteResponse cliente) {
		DetalleVentaDto resultadoVenta = new DetalleVentaDto();

		try {
			webClient.build().post().uri(URL + "/guardarVenta")
					.body(Mono.just(resultadoVenta), Void.class)
					.retrieve().bodyToMono(Void.class).block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());

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

	
}
