package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DetalledevolucionesDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.entities.Detalledevoluciones;

public interface IDetalleDevolucionesService {
    
    List<Detalledevoluciones> ListarDetalledevoluciones() ; 

    DetalledevolucionesDto buscarDetalledevolucionesCodigoyNombre(Long codigoventa, String nombreProducto)  ;

    void crearDetalledevolucioness(Long CodigoVenta, DetalledevolucionesDto DetalledevolucionessDto);
    
    void actualizarDetalledevoluciones(Long codigoventa, String nombreProducto, DetalledevolucionesDto detalleDto) ;

    List<Detalledevoluciones> ListarDetalledevolucionessPorCodigo(Long Codigoventa) ;

    void eliminarDetalledevoluciones(Long codigoVenta, String nombreProdcuto); 

    int contadorDetalledevoluciones(Long CodigoVenta, String nombreProducto); 
}
