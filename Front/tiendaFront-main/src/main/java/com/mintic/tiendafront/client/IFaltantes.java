package com.mintic.tiendafront.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.DevolucionesDto;
import com.mintic.tiendafront.dto.DevolucionesResponse;
import com.mintic.tiendafront.dto.DetalleDevolucionesDto;
import com.mintic.tiendafront.dto.DetalleDevolucionesResponse;

public interface IFaltantes {
    
    List<DevolucionesResponse> ListarFaltantes(); 

	DevolucionesResponse guardarDevoluciones(DevolucionesDto DevolucionesDto);

	List<DetalleDevolucionesResponse> ListarDetalleFaltantes(Long CodigoDevoluciones) ;

	DevolucionesResponse buscarDevolucionesCodigo(Long CodigoCompra) ;

	void eliminarDevoluciones(Long CodigoDevoluciones) ;

	DevolucionesResponse ActualizarDevoluciones(DevolucionesDto DevolucionesDto, Long CodigoDevoluciones) ;

	List<DevolucionesResponse> ListarFaltantesporProducto(String nombreProducto) ;

	List<DetalleDevolucionesResponse> ListarunDetalledeFaltantes(Long CodigoDevoluciones, String nombreProducto) ;

	DetalleDevolucionesResponse nuevoDevolucionesDetalle(Long CodigoCompra, DetalleDevolucionesDto detalle) ;

	DetalleDevolucionesResponse ActualizarDetalleDevoluciones(Long CodigoDevoluciones, String nombreProducto, DetalleDevolucionesDto detalleDevolucionesDto) ;

	Integer ContadordeFaltantes(Long CodigoDevoluciones) ;

	Integer ContadordeDetalleFaltantes(Long CodigoDevoluciones, String nombreProducto) ;

	Double totalDevoluciones(Long CodigoDevoluciones) ;

	DetalleDevolucionesResponse DetalladeunaDevoluciones(Long CodigoDevoluciones, String nombreProducto) ;

	void eliminarDetalleDevoluciones(Long CodigoDevoluciones, String nombreProducto) ;


}
