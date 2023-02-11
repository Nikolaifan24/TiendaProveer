package com.mintic.tiendafront.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.DetalleVentaResponse;

public interface IVenta {
	
	List<VentaResponse> ListarVentas(); 

	VentaResponse guardarVenta(VentaDto VentaDto);

	List<DetalleVentaResponse> ListarDetalleVentas(Long CodigoVenta) ;

	VentaResponse buscarVentaCodigo(Long CodigoCompra) ;

	void eliminarVenta(Long CodigoVenta) ;

	VentaResponse ActualizarVenta(VentaDto ventaDto, Long CodigoVenta) ;

	List<VentaResponse> ListarVentasporProducto(String nombreProducto) ;

	List<DetalleVentaResponse> ListarunDetalledeVentas(Long CodigoVenta, String nombreProducto) ;

	DetalleVentaResponse nuevoVentaDetalle(Long CodigoCompra, DetalleVentaDto detalle) ;

	DetalleVentaResponse ActualizarDetalleVenta(Long CodigoVenta, String nombreProducto, DetalleVentaDto detalleventaDto) ;

	Integer ContadordeVentas(Long CodigoVenta) ;

	Double totalVenta(Long CodigoVenta) ;

	DetalleVentaResponse DetalladeunaVenta(Long CodigoVenta, String nombreProducto) ;

	void eliminarDetalleVenta(Long CodigoVenta, String nombreProducto) ;
}
