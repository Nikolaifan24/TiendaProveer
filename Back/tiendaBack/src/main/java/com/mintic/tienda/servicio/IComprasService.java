package com.mintic.tienda.servicio;

// import java.util.String;
import java.util.List;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Detallecompra;

public interface IComprasService {

    void crearCompras(ComprasDto ComprasDto) ;

    ComprasDto buscarComprasPorCodigoCompra(Long CodigoCompra) ;

    void eliminarCompras(Long CodigoCompra);

    void actualizarCompras(Long CodigoCompra, ComprasDto ComprasDto) ;

    List<Compras> listaCompras();
    
    List<Compras> listaComprasProveedor(String nombreProveedor);

    List<Compras> listarComprasPorProveedor(String nombreProveedor);

    List<Compras> listaComprasPorProductos(String nombreProducto);

    List<Detallecompra> listaComprasPordetalles(Long CodigoCompra);

    DetallecompraDto realizarCalculoCompra(DetallecompraDto detallecompraDto);

}
