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
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.ResultadoVentaDto;
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
	public ProductoDto getProduct (Long codigoProducto) {
		
		try {
			Mono<ProductoDto> response = webClient.build().get().uri(URL + "/producto/" + codigoProducto)
			.retrieve().bodyToMono(ProductoDto.class);
			return response.block();
		
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
		
	}

	@Override
	public VentaDto calcularTotalVenta(Map<ProductoDto, Integer> productosMap) {
		List<Entry<ProductoDto, Integer>> productos = new ArrayList<>(productosMap.entrySet());
		Entry<ProductoDto, Integer> entryProducto1 = productos.get(0);
		Entry<ProductoDto, Integer> entryProducto2 = productos.get(1);
		Entry<ProductoDto, Integer> entryProducto3 = productos.get(2);
		
		VentaDto venta = new VentaDto();
		
		venta.setCodigoProducto1(entryProducto1.getKey().getCodigoProducto());
		venta.setNombreProducto1(entryProducto1.getKey().getNombreProducto());
		Double precioUnitario1 = entryProducto1.getKey().getPrecioCompra();
		int cantidad1 = entryProducto1.getValue();
		venta.setCantidadProducto1(cantidad1);
		Double precioTotal1 = precioUnitario1 * cantidad1;
		Double iva1 = precioTotal1 * entryProducto1.getKey().getIvaCompra();
		venta.setPrecioProducto1(precioTotal1);
		venta.setIvaProducto1(iva1);
		
		venta.setCodigoProducto2(entryProducto2.getKey().getCodigoProducto());
		venta.setNombreProducto2(entryProducto2.getKey().getNombreProducto());
		Double precioUnitario2 = entryProducto2.getKey().getPrecioCompra();
		int cantidad2 = entryProducto2.getValue();
		venta.setCantidadProducto2(cantidad2);
		Double precioTotal2 = precioUnitario2 * cantidad2;
		Double iva2 = precioTotal2 * entryProducto2.getKey().getIvaCompra();
		venta.setPrecioProducto2(precioUnitario2 * cantidad2);
		venta.setIvaProducto2(iva2);
		
		venta.setCodigoProducto3(entryProducto3.getKey().getCodigoProducto());
		venta.setNombreProducto3(entryProducto3.getKey().getNombreProducto());
		Double precioUnitario3 = entryProducto3.getKey().getPrecioCompra();
		int cantidad3 = entryProducto3.getValue();
		venta.setCantidadProducto3(cantidad3);
		Double precioTotal3 = precioUnitario3 * cantidad3;
		Double iva3 = precioTotal3 * entryProducto3.getKey().getIvaCompra();
		venta.setPrecioProducto3(precioUnitario3 * cantidad3);
		venta.setIvaProducto3(iva3);
		
		Double totalSinIva = precioTotal1 + precioTotal2 + precioTotal3;
		Double ivaTotal = iva1 + iva2 + iva3;
		venta.setPrecioTotalSinIva(totalSinIva);
		venta.setIvaTotal(ivaTotal);
		venta.setPrecioTotal(totalSinIva + ivaTotal);
		
		return venta;
	}
	
	private Double getTotalSinIva(Map<ProductoDto, Integer> productosMap) {
		Double totalSinIva = 0.0;
		for (Entry<ProductoDto, Integer> producto : productosMap.entrySet()) {
			totalSinIva += producto.getKey().getPrecioCompra();
		}
		return totalSinIva;
	}

	@Override
	public List<VentaResponse> getVentas() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/ventas").retrieve()
					.bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public void guardarVenta(VentaDto totalVenta, Long idUsuario, ClienteResponse cliente) {
		ResultadoVentaDto resultadoVenta = new ResultadoVentaDto();
		
		resultadoVenta.setCodigoVenta((long) Math.random());
		resultadoVenta.setIdCliente(cliente.getid());
		resultadoVenta.setIdUsuario(idUsuario);
		resultadoVenta.setIvaVenta(totalVenta.getIvaTotal());
		resultadoVenta.setValorVenta(totalVenta.getPrecioTotalSinIva());
		resultadoVenta.setTotalVenta(totalVenta.getPrecioTotal());
		
		
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
