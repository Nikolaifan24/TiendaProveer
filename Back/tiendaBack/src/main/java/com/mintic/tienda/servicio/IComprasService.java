package com.mintic.tienda.servicio;

// import java.util.String;
import java.util.List;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Detallecompra;

public interface IComprasService {

    void crearCompras(ComprasDto ComprasDto) ;

    ComprasDto buscarComprasPorFechaCompra(String FechaCompra) ;

    void eliminarCompras(String FechaCompra);

    void actualizarCompras(String FechaCompra, ComprasDto ComprasDto) ;

    List<Compras> listaCompras();
    
    List<Compras> listaComprasProveedor(String nombreProveedor); 

    List<Compras> listarComprasPorFechaComprayProveedor(String FechaVenta, Long IDProveedor) ;

    List<Compras> listaComprasPorProductos(String nombreProducto);

    List<Detallecompra> listaComprasPordetalles(String FechaCompra);
}
