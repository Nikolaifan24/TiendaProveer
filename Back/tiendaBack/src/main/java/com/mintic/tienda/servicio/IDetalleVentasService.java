package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.entities.Detalleventa;

public interface IDetalleVentasService {

	List<Detalleventa> ListarDetalleventas() ;

    // DetalleventaDto buscarDetalleventaCodigoyNombre(Long codigoventa, String nombreProducto) ;
    DetalleventaDto buscarDetalleventaCodigoyNombre(Long codigoventa, String nombreProducto); 

    void crearDetalleventas(Long codigoventa,DetalleventaDto DetalleventasDto); 
    
    void actualizarDetalleventa(Long codigoventa, String nombreProducto, DetalleventaDto detalleDto);

    List<Detalleventa> ListarDetalleventasPorCodigo(Long Codigoventa)  ;

    // Detalleventa buscarDetalleventaPorCodigoyNombreProducto(Long codigoVenta, String nombreProducto);

}
