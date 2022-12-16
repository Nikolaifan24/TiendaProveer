package com.mintic.tienda.servicio;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ProductoDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Proveedores;
// import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.entities.Usuarios;
import com.mintic.tienda.repositories.IProducto;
// import com.mintic.tienda.repositories.IProducto;

@Service
public class ProductoImp implements IProductoService {

	@Autowired
	IProducto iProducto;
	
	@Override
	public ProductosDto buscarProductoPorNombre(String nombreProducto) {
	
		Productos producto = null;
		try {
			producto = iProducto.buscarProductoPorNombre(nombreProducto);
			ProductosDto productosDto = mapProductosDto(producto);
			return productosDto;
		} catch (Exception e) {
			throw e;
			
		}
		
	}

	private ProductosDto mapProductosDto(Productos producto) {
		return new ProductosDto(
				producto.getIDProductos(),
				producto.getProveedores(),
				producto.getCompras(),
				producto.getCodigoProducto(),
				producto.getNombreProducto(),
				producto.getTipoProducto(),
				producto.getPrecioCompra(),
				producto.getPrecioVenta(), 
				producto.getCantidadProducto(),
				producto.getUnidadesCompradas(),
				producto.getUnidadesVendidas(), 
				producto.getDevoluciones() 
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
		
		Long id =  productosDto.getIdProducto();
		Proveedores proveedores = productosDto.getProveedores();
		Compras compras = productosDto.getCompras();
		Long codigoProducto = productosDto.getCodigoProducto();
		String nombreProducto = productosDto.getNombreProducto();
		String tipoProducto = productosDto.getTipoProducto();
		Double precioCompra = productosDto.getPrecioCompra();
		Double precioVenta = productosDto.getPrecioVenta();
		Long cantidadProducto = productosDto.getCantidadProducto();
		Long unidadesVendidas = productosDto.getUnidadesVendidas();
		Long unidadesCompradas = productosDto.getUnidadesCompradas();
		Long devoluciones = productosDto.getDevoluciones();
		
		if(id != null) {
			productos.setIDProductos(cantidadProducto);;
		}
		if(proveedores != null) {
			productos.setProveedores(proveedores);
		}
		if(compras != null) {
			productos.setCompras(compras);
		}
		if(codigoProducto != null) {
			productos.setCodigoProducto(codigoProducto);
		}
		if(nombreProducto != null) {
			productos.setNombreProducto(nombreProducto);
		}
		if(tipoProducto != null) {
			productos.setTipoProducto(tipoProducto);
		}
		if(precioCompra != null) {
			productos.setPrecioCompra(precioCompra);
		}
		if(precioVenta != null) {
			productos.setPrecioVenta(precioVenta);
		}
		if(cantidadProducto != null) {
			productos.setCantidadProducto(cantidadProducto);
		}
		if(unidadesVendidas != null) {
			productos.setUnidadesVendidas(unidadesVendidas);
		}
		if(unidadesCompradas != null) {
			productos.setUnidadesCompradas(unidadesCompradas);
		}
		if(devoluciones != null) {
			productos.setDevoluciones(devoluciones);
		}
		
		return productos;
	}


	private void updateProducto(ProductosDto productosDto, Productos productos) {
		// Productos productos = new Productos();
		
		Long id =  productosDto.getIdProducto();
		Proveedores proveedores = productosDto.getProveedores();
		Compras compras = productosDto.getCompras();
		Long codigoProducto = productosDto.getCodigoProducto();
		String nombreProducto = productosDto.getNombreProducto();
		String tipoProducto = productosDto.getTipoProducto();
		Double precioCompra = productosDto.getPrecioCompra();
		Double precioVenta = productosDto.getPrecioVenta();
		Long cantidadProducto = productosDto.getCantidadProducto();
		Long unidadesVendidas = productosDto.getUnidadesVendidas();
		Long unidadesCompradas = productosDto.getUnidadesCompradas();
		Long devoluciones = productosDto.getDevoluciones();

		
		if(id != null) {
			productos.setIDProductos(cantidadProducto);
		}
		if(proveedores != null) {
			productos.setProveedores(proveedores);
		}
		if(compras != null) {
			productos.setCompras(compras);
		}
		if(codigoProducto != null) {
			productos.setCodigoProducto(codigoProducto);
		}
		if(nombreProducto != null) {
			productos.setNombreProducto(nombreProducto);
		}
		if(tipoProducto != null) {
			productos.setTipoProducto(tipoProducto);
		}
		if(precioCompra != null) {
			productos.setPrecioCompra(precioCompra);
		}
		if(precioVenta != null) {
			productos.setPrecioVenta(precioVenta);
		}
		if(cantidadProducto != null) {
			productos.setCantidadProducto(cantidadProducto);
		}
		if(unidadesVendidas != null) {
			productos.setUnidadesVendidas(unidadesVendidas);
		}
		if(unidadesCompradas != null) {
			productos.setUnidadesCompradas(unidadesCompradas);
		}
		if(devoluciones != null) {
			productos.setDevoluciones(devoluciones);
		}
		iProducto.save(productos);
	}
	
	@Override
	public void actualizarProducto(String nombreProductoString, ProductosDto productosDto) {
		Productos Producto = iProducto.buscarProductoPorNombre(nombreProductoString);
		updateProducto(productosDto, Producto);

	}

	

}
