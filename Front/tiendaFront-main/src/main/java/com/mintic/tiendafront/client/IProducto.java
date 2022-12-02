package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ProductoDto;

//import java.util.List;



public interface IProducto {
	
	public List<ProductoDto> getProductos();

	public void crearProducto(ProductoDto producto);

	public ProductoDto buscarProductoPorCodigo(Long codigoProducto);

	//public ProductoDto buscarProducto(Long codigoProducto);

	//public int borrarProdcuto(Long codigoProducto);

}
