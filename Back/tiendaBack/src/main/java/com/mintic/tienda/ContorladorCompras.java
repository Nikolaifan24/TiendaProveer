package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Detallecompra;
import com.mintic.tienda.repositories.IDetalleCompra;
// import com.mintic.tienda.servicio.IUsuarioService;
// import com.mintic.tienda.dto.LoginDto;
// import com.mintic.tienda.dto.ProveedoresDto;
// import com.mintic.tienda.dto.ComprasDto;
// import com.mintic.tienda.entities.Comprass;
// import com.mintic.tienda.entities.Comprass;
import com.mintic.tienda.servicio.IComprasService;
// import com.mintic.tienda.servicio.IComprasService;


@RestController
public class ContorladorCompras {

    @Autowired
	IComprasService iCompras;

	@Autowired
	IDetalleCompra idetallecompra;
	
	ComprasDto ComprasDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Compras/{FechaCompra}")
	public ComprasDto MostarComprasPorNombre(@PathVariable String FechaCompra) {
		return iCompras.buscarComprasPorFechaCompra(FechaCompra);
	}
	
	@PostMapping("/crearCompras")
	public void crearCompras(@RequestBody ComprasDto ComprasDto) {
		iCompras.crearCompras(ComprasDto);
	}
	
	@DeleteMapping("/eliminarCompras/{FechaCompra}")
	public void eliminarCompras(@PathVariable String FechaCompra) {
		iCompras.eliminarCompras(FechaCompra);
	}
	
	@PatchMapping("/actualizarCompras/{FechaCompra}")
	public void actualizaralCompras(@PathVariable String FechaCompra, @RequestBody ComprasDto ComprasDto) {
		iCompras.actualizarCompras(FechaCompra, ComprasDto);;
	}
	
	@GetMapping("/Compraslistar")
	public List<Compras> listaCompras() {
		return iCompras.listaCompras();
	}
	
	@GetMapping("/compraslistar/producto/{nombreProducto}")
	public List<Compras> MostarProductoPornombreProducto(@PathVariable String nombreProducto) {
		return iCompras.listaComprasPorProductos(nombreProducto);
	}

	@GetMapping("/compraslistar/proveedor/{nombreProveedor}")
	public List<Compras> MostarProductoPornombreProveedor(@PathVariable String nombreProveedor) {
		return iCompras.listarComprasPorProveedor(nombreProveedor);
	}

	@GetMapping("/compras/productos/comprados/{FechaCompra}")
	public List<Detallecompra> MostarDetallesCompras(@PathVariable String FechaCompra) {
		return idetallecompra.buscarDetalleCompraPorFecha(FechaCompra) ;
	}
    
}
