package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;

public interface IProductoService {

	// ProductosDto buscarProductoPorCodigo(Long codigoProducto);

	List<Productos> ListaProductos();

	void crearProducto(ProductosDto productosDto);

    ProductosDto buscarProductoPorNombre(String nombreProducto);

	void actualizarProducto(String nombreProducto, ProductosDto productosDto);

	void eliminarProductos(String nombreProductos);

	List<Productos> listarProductoTipo(String tipoProducto);

	List<Productos> encontrarProductoPorNombre(String nombreProducto);
}
