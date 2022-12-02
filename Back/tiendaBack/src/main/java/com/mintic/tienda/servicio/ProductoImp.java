package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Usuarios;
import com.mintic.tienda.repositories.ICliente;
import com.mintic.tienda.repositories.IProducto;

@Service
public class ProductoImp implements IProductoService {

	@Autowired
	IProducto iProducto;
	
	@Override
	public ProductosDto buscarProductoPorCodigo(Long codigoProducto) {
	
		Productos producto = null;
		try {
			producto = iProducto.buscarProductoPorCodigo(codigoProducto);
			ProductosDto productosDto = mapProductosDto(producto);
			return productosDto;
		} catch (Exception e) {
			throw e;
			
		}
		
	}

	private ProductosDto mapProductosDto(Productos producto) {
		return new ProductosDto(
				producto.getId(),
				producto.getCodigoProducto(),
				producto.getIvaCompra(),
				producto.getIdProveedor(),
				producto.getNombreProducto(),
				producto.getPrecioCompra(),
				producto.getPrecioVenta()
		);		
	}

	@Override
	public List<Productos> getProductos() {
		return (List<Productos>) iProducto.findAll();
	}

	
	
	
	@Override
	public void crearProducto(ProductosDto productosDto) {
		iProducto.save(buildProducto(productosDto));
		
	}

	private Productos buildProducto(ProductosDto productosDto) {
		
		Productos productos = new Productos();
		
		Long id =  productosDto.getId();
		Long codigoProducto = productosDto.getCodigoProducto();
		Double ivaCompra = productosDto.getIvaCompra();
		Long idProveedor = productosDto.getIdProveedor();
		String nombreProducto = productosDto.getNombreProducto();
		Double precioCompra = productosDto.getPrecioCompra();
		Double precioVenta = productosDto.getPrecioVenta();
		
		if(id != null) {
			productos.setId(id);
		}
		if(codigoProducto != null) {
			productos.setCodigoProducto(codigoProducto);
		}
		if(ivaCompra != null) {
			productos.setIvaCompra(ivaCompra);
		}
		if(idProveedor != null) {
			productos.setIdProveedor(idProveedor);
		}
		if(nombreProducto != null) {
			productos.setNombreProducto(nombreProducto);
		}
		if(precioCompra != null) {
			productos.setPrecioCompra(precioCompra);
		}
		if(precioVenta != null) {
			productos.setPrecioVenta(precioVenta);
		}
			
		return productos;
	}

}
