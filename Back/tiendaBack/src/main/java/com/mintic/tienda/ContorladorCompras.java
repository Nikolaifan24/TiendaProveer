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
// import com.mintic.tienda.dto.DetallecompraDto;
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
import com.mintic.tienda.servicio.IDetalleComprasService;

@RestController
public class ContorladorCompras {

	@Autowired
	IComprasService iCompras;

	@Autowired
	IDetalleComprasService idetallecompra;

	ComprasDto ComprasDto;

	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/BuscarComprasPorCodigo/{CodigoCompra}")
	public ComprasDto MostarComprasPorNombre(@PathVariable Long CodigoCompra) {
		return iCompras.buscarComprasPorCodigoCompra(CodigoCompra);
	}

	@PostMapping("/crearCompras")
	public void crearCompras(@RequestBody ComprasDto ComprasDto) {
		System.out.println("esta es mi compra");
		iCompras.crearCompras(ComprasDto);
	}

	@DeleteMapping("/eliminarCompras/{CodigoCompra}")
	public void eliminarCompras(@PathVariable Long CodigoCompra) {
		iCompras.eliminarCompras(CodigoCompra);
	}

	@PatchMapping("/actualizarCompras/{CodigoCompra}")
	public void actualizaralCompras(@PathVariable Long CodigoCompra, @RequestBody ComprasDto ComprasDto) {
		iCompras.actualizarCompras(CodigoCompra, ComprasDto);
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

	@GetMapping("/compras/detalle/{CodigoCompra}")
	public List<Detallecompra> MostarDetallesCompras(@PathVariable Long CodigoCompra) {
		return idetallecompra.encontrarDetallecompraPorNombre(CodigoCompra);
	}

	@GetMapping("/compras/detalle/codigo/{CodigoCompra}/{nombreProducto}")
	public DetallecompraDto MostarunDetalleCompras(@PathVariable Long CodigoCompra,
			@PathVariable String nombreProducto) {
		return idetallecompra.buscarDetallecompraCodigoyNombre(CodigoCompra, nombreProducto);
	}

	// @PatchMapping("/Compras/cargar-productos/{CodigoCompra}")
	// public void CargardatosCompras(@PathVariable Long CodigoCompra, @RequestBody
	// ComprasDto ComprasDto) {
	// iCompras.cargarCalculosdeCompras(CodigoCompra, ComprasDto);
	// }

	@GetMapping("/compras/detalle-total/codigo/{CodigoCompra}")
	public Double TotaldemiCompra(@PathVariable Long CodigoCompra) {
		return iCompras.cargarCalculosdeCompras(CodigoCompra);
	}

	@PostMapping("/crearCompras/detalles/{CodigoCompra}")
	public void crearCompras(@PathVariable Long CodigoCompra, @RequestBody DetallecompraDto detallecompraDto) {
		System.out.println("esta es el detalle de mi compra " + detallecompraDto);
		idetallecompra.crearDetallecompras(CodigoCompra, detallecompraDto);
	}

	@PatchMapping("/Compras/actualizar/detalles/{CodigoCompra}/{nombreProducto}")
	public void ActualizarDetalledeCompra(@PathVariable Long CodigoCompra, @PathVariable String nombreProducto,
			@RequestBody DetallecompraDto detallecompraDto) {
		System.out.println("esta es la actualizacion de mi detalle " + detallecompraDto);
		idetallecompra.actualizarDetalleCompra(CodigoCompra, nombreProducto, detallecompraDto);
	}

	@DeleteMapping("/eliminarDetalleCompra/{codigoCompra}/{nombreProducto}")
	public void eliminarDetalleCompra(@PathVariable Long codigoCompra, @PathVariable String nombreProducto) {
		idetallecompra.eliminarDetalleCompra(codigoCompra, nombreProducto);
	}

	@GetMapping("/compras/conteo/codigo/{CodigoCompra}")
	public Integer ContarunaCompra(@PathVariable Long CodigoCompra) {
		return iCompras.contadordeCompras(CodigoCompra);
	}
}
