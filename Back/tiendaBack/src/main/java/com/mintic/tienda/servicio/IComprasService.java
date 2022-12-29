package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.entities.Compras;

public interface IComprasService {

    void crearCompras(ComprasDto ComprasDto) ;

    ComprasDto buscarComprasPorFechaCompra(Date FechaCompra) ;

    void eliminarCompras(Date FechaCompra);

    void actualizarCompras(Date FechaCompra, ComprasDto ComprasDto) ;

    List<Compras> listaCompras();
    
    List<Compras> listaComprasProveedor(Long IDProveedor);

    List<Compras> listarComprasPorFechaComprayProveedor(Date FechaVenta, Long IDProveedor) ;
}
