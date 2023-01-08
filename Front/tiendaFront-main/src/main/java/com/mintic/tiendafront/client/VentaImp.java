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
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;

import reactor.core.publisher.Mono;

@Service
public class VentaImp implements IVenta {
	
	private static final String URL = "http://localhost:8091/tienda";
	
	@Autowired
	private WebClient.Builder webClient;
	
	@Autowired
	IVenta iVenta;

	@Override
	public ProductoDto BuscarProductopornombre (String nombreProducto) {
		
		try {
			Mono<ProductoDto> response = webClient.build().get().uri(URL + "/producto/" + nombreProducto)
			.retrieve().bodyToMono(ProductoDto.class);
			return response.block();
		
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
		
	}


	
	private Double getTotalSinIva(Map<ProductoDto, Integer> productosMap) {
		Double totalSinIva = 0.0;
		for (Entry<ProductoDto, Integer> producto : productosMap.entrySet()) {
			totalSinIva += producto.getKey().getPrecioCompra();
		}
		return totalSinIva;
	}

	@Override
	public List<VentaResponse> ListarVentas() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/ventas").retrieve()
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
		
		// resultadoVenta.setCodigoVenta((long) Math.random());

		// resultadoVenta.setIvaVenta(totalVenta.getTotalVenta());
		// resultadoVenta.getTotalDetalle(totalVenta.getTotalVenta());
		// resultadoVenta.setTotalVenta(totalVenta.getPrecioTotal());
		
		
		try {
			webClient.build().post().uri(URL + "/guardarVenta")
			.body(Mono.just(resultadoVenta), Void.class)
			.retrieve().bodyToMono(Void.class).block();
			
		
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
		
		}
	}
	

}
