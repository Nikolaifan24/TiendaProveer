package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;
import com.mintic.tiendafront.dto.DetalleCompraDto;
import com.mintic.tiendafront.dto.DetalleCompraResponse;

public interface ICompra {

    List<ComprasResponse> ListarCompras();

    ComprasResponse nuevaCompras(ComprasDto ComprasDto); 

    ComprasResponse buscarCompraCodigo(Long CodigoCompra);

    ComprasResponse ActualizarCompra(ComprasDto CompraDto, Long CodigoCompra) ;

    List<DetalleCompraResponse> ListarDetalleCompras(Long CodigoCompra) ;

    List<ComprasResponse> ListarComprasPorProducto(String nombreProducto); 

    List<ComprasResponse> ListarComprasPorProveedor(String nombreProveedor) ;

    DetalleCompraResponse DetalladeunaCompra(Long CodigoCompra, String nombreProducto) ; 

    ComprasResponse CargarDatosdeunaCompra(ComprasDto ComprasDto, Long CodigoCompra); 

    DetalleCompraResponse nuevoCompraDetalle(Long CodigoCompra, DetalleCompraDto detalleCompraDto) ;

    DetalleCompraResponse ActualizarDetalledeCompra(Long CodigoCompra, String nombreProducto, DetalleCompraDto detalleCompraDto); 

    Double totalCompra(Long CodigoCompra); 
}
