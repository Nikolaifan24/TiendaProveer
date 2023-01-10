package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Detallecompra;

public interface IDetalleComprasService {

    List<Detallecompra> ListarDetalleCompras() ;

    DetallecompraDto buscarDetallecompraCodigoyNombre(Long codigoCompra, String nombreProducto) ;

    void crearDetallecompras(DetallecompraDto DetallecomprasDto); 
    
    void actualizarDetalleCompra(Long codigoCompra, String nombreProducto, DetallecompraDto detalleDto);
}
