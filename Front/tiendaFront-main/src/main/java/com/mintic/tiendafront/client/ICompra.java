package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;

public interface ICompra {

    List<ComprasResponse> ListarCompras();

    ComprasResponse nuevoCompra(ComprasDto CompraDto);

    ComprasResponse buscarCompra(String fechaCompra);

    ComprasResponse ActualizarCompra(ComprasDto CompraDto, String fechaCompra) ;
}
