package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;
import com.mintic.tiendafront.dto.DetalleCompraResponse;

public interface ICompra {

    List<ComprasResponse> ListarCompras();

    ComprasResponse nuevoCompra(ComprasDto CompraDto);

    ComprasResponse buscarCompra(Long CodigoCompra);

    ComprasResponse ActualizarCompra(ComprasDto CompraDto, Long CodigoCompra) ;

    List<DetalleCompraResponse> ListarDetalleCompras(Long CodigoCompra) ;
}
