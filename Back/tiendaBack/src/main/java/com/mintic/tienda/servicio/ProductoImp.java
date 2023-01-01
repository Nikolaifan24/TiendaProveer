
package com.mintic.tienda.servicio;

import java.util.ArrayList;
// import java.util.HashMap;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IProducto;

@Service 
public class ProductoImp implements IProductoService {

	
	@Autowired
	IProducto iProductos;
	
		@Override
	public List<Productos> ListaProductos() {
		return (List<Productos>) iProductos.findAll();
	}



	@Override
	public void crearProducto(ProductosDto productosDto) {
		iProductos.save(buildProductos(productosDto));
		
	}

	private Productos buildProductos(ProductosDto ProductosDto) {
		Productos productos = new Productos();
		
		
		
		return productos;
		
	}
	
	private void updateProductos(ProductosDto productosDto, Productos productos) {
		
		
		iProductos.save(productos);
	}
	

	@Override
	public void eliminarProductos(String nombreProducto) {
		Productos Productos = iProductos.buscarProductoPorNombre(nombreProducto);
		iProductos.delete(Productos);
		
	}

	@Override
	public void actualizarProducto(String nombreProducto, ProductosDto productosDto){
		
		Productos Productos = iProductos.buscarProductoPorNombre(nombreProducto);
		updateProductos(productosDto, Productos);
		
	}

	@Override
	public ProductosDto buscarProductoPorNombre(String nombreProducto) {
	
		Productos producto = null;
		try {
			producto = iProductos.buscarProductoPorNombre(nombreProducto);
			ProductosDto productosDto = mapProductosDto(producto);
			return productosDto;
		} catch (Exception e) {
			throw e;
			
		}
		
	}

	private ProductosDto mapProductosDto(Productos producto) {
		return new ProductosDto (
				producto.getIDProductos(),
				producto.getProveedores(),
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
	public List<Productos> listarProductoTipo(String tipoProducto){
		// TODO Auto-generated method stub
		
		List<Productos> lista = new ArrayList<Productos>();
		
		lista = iProductos.buscarProductoPorTipo(tipoProducto);
		System.out.println(lista);
		
		return (lista) ;
	}



	@Override
	public List<Productos> encontrarProductoPorNombre(String nombreProducto) {
		List<Productos> lista = new ArrayList<Productos>();
		
		lista.add(iProductos.buscarProductoPorNombre(nombreProducto));
		System.out.println("el producto es \n" + lista.toString());
		return lista;
	}

	@Override
	public List<Productos> encontrarProductoPorNombreProveeodr(String nombreProveedor) {
		List<Productos> lista = new ArrayList<Productos>();
		
		lista = iProductos.buscarProductoPorNombreProveedor(nombreProveedor);
		System.out.println("el producto con proveedor es \n" + lista.toString());
		return lista;
	}	

		


}

