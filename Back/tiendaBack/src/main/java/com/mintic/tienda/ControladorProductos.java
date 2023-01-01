package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.dto.LoginDto;
// import com.mintic.tienda.dto.ProveedoresDto;
// import com.mintic.tienda.dto.ProductoDto;
// import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.servicio.IProductoService;
// import com.mintic.tienda.servicio.IProductoService;

@RestController
public class ControladorProductos {

	@Autowired
	IProductoService iProducto;
	
	ProductosDto ProductoDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Productos/{nombreProducto}")
	public List<Productos> MostarProductoPorNombre(@PathVariable String nombreProducto) {
		return iProducto.encontrarProductoPorNombre(nombreProducto);
	}
	

	@GetMapping("/productos/proveedor/{nombreProveedor}")
	public List<Productos> MostarProductoPorNombreProveedor(@PathVariable String nombreProveedor) {
		return iProducto.encontrarProductoPorNombreProveeodr(nombreProveedor);
	}
	
	
	@PostMapping("/crearProducto")
	public void crearProducto(@RequestBody ProductosDto ProductoDto) {
		iProducto.crearProducto(ProductoDto);
	}
	
	@DeleteMapping("/eliminarProducto/{nombreProducto}")
	public void eliminarProducto(@PathVariable String nombreProducto) {
		iProducto.eliminarProductos(nombreProducto);
	}
	
	@PatchMapping("/actualizarProducto/{nombreProducto}")
	public void actualizaralProducto(@PathVariable String nombreProducto, @RequestBody ProductosDto ProductoDto) {
		iProducto.actualizarProducto(nombreProducto, ProductoDto);;
	}
	
	@GetMapping("/Productoslistar")
	public List<Productos> listaProducto() {
		return iProducto.ListaProductos();
	}
	
	@GetMapping("/Producto/tipo/{tipoProducto}")
	public List<Productos> listatipoProductoProducto(@PathVariable String tipoProducto){
		return iProducto.listarProductoTipo(tipoProducto);
	}

	
}
