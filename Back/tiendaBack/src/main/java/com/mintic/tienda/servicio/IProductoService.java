package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;

public interface IProductoService {

	ProductosDto buscarProductoPorCodigo(Long codigoProducto);

	List<Productos> getProductos();

	void crearProducto(ProductosDto productosDto);
}
