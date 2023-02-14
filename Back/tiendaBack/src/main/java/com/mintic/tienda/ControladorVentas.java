package com.mintic.tienda;


// import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.DetalleventaDto;
// import com.mintic.tienda.dto.CalculoDto;
// import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Detalleventa;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
// import com.mintic.tienda.repositories.IVenta;
import com.mintic.tienda.repositories.IDetalleVenta;
import com.mintic.tienda.servicio.IDetalleVentasService;
// import com.mintic.tienda.servicio.IDetalleVentasService;
// import com.mintic.tienda.servicio.IProductoService;
import com.mintic.tienda.servicio.IVentasService;


@RestController
public class ControladorVentas {
	
	@Autowired
	IVentasService iVentas;
	
	@Autowired
	IDetalleVentasService idetalleventa;
	
	VentasDto ventasDto;
		
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Ventas/{CodigoVenta}")
	public VentasDto MostarVentasPorCodigo(@PathVariable Long CodigoVenta) {
		return iVentas.buscarVentasPorCodigoventa(CodigoVenta);
	}
	
	@PostMapping("/crearVentas")
	public void crearVentas(@RequestBody VentasDto VentasDto) {
		System.out.println("esta es mi venta");
		iVentas.crearVentas(VentasDto);
	}
	
	@DeleteMapping("/eliminarVentas/{CodigoVenta}")
	public void eliminarVentas(@PathVariable Long CodigoVenta) {
		iVentas.eliminarVentas(CodigoVenta);
	}
	
	@PatchMapping("/actualizarVentas/{CodigoVenta}")
	public void actualizaralVentas(@PathVariable Long CodigoVenta, @RequestBody VentasDto VentasDto) {
		iVentas.actualizarVentas(CodigoVenta, VentasDto);
	}
	
	@GetMapping("/Ventaslistar")
	public List<Ventas> listaVentas() {
		return iVentas.listaVentas();
	}
	
	@GetMapping("/Ventaslistar/producto/{nombreProducto}")
	public List<Ventas> MostarProductoPornombreProducto(@PathVariable String nombreProducto) {
		return iVentas.listaVentasPorProductos(nombreProducto);
	}

	@GetMapping("/Ventaslistar/proveedor/{nombreProveedor}")
	public List<Ventas> MostarProductoPornombreProveedor(@PathVariable String nombreProveedor) {
		return iVentas.listarVentasPorProveedor(nombreProveedor);
	}

	@GetMapping("/Ventas/detalle/{CodigoVenta}")
	public List<Detalleventa> MostarDetallesVentas(@PathVariable Long CodigoVenta) {
		return idetalleventa.ListarDetalleventasPorCodigo(CodigoVenta);
	}

	@GetMapping("/Ventas/detalle/codigo/{CodigoVenta}/{nombreProducto}")
	public DetalleventaDto MostarunDetalleVentas(@PathVariable Long CodigoVenta,@PathVariable String nombreProducto ) {
		return idetalleventa.buscarDetalleventaCodigoyNombre(CodigoVenta, nombreProducto);
	}

	@PostMapping("/crearVentas/detalles/{Codigoventa}")
	public void crearVentas(@PathVariable Long Codigoventa, @RequestBody DetalleventaDto detalleventaDto) {
		System.out.println("esta es el detalle de mi venta "+ detalleventaDto);
		idetalleventa.crearDetalleventas(Codigoventa, detalleventaDto);
	}

	@PatchMapping("/Ventas/actualizar/detalles/{Codigoventa}/{nombreProducto}")
	public void ActualizarDetalledeventa(@PathVariable Long Codigoventa, @PathVariable String nombreProducto, @RequestBody DetalleventaDto detalleventaDto) {
		System.out.println("esta es la actualizacion de mi detalle "+ detalleventaDto);
		idetalleventa.actualizarDetalleventa(Codigoventa, nombreProducto, detalleventaDto);
	}

	@GetMapping("/Ventas/conteo/codigo/{CodigoVenta}")
	public Integer ContarunaVenta(@PathVariable Long CodigoVenta) {
		return iVentas.contadordeVentas(CodigoVenta);
	}

	@GetMapping("/Ventas/detalle-total/codigo/{CodigoVenta}")
	public Double TotaldemiVenta(@PathVariable Long CodigoVenta) {
		return iVentas.cargarCalculosdeVenta(CodigoVenta);
	}

	@DeleteMapping("/eliminarDetalleVentas/{CodigoVenta}/{nombreProducto}")
	public void eliminarDetalleVentas(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		idetalleventa.eliminarDetalleVenta(CodigoVenta, nombreProducto);
	}

	@GetMapping("/Ventas/conteo/detalle/{CodigoVenta}/{nombreProducto}")
	public Integer ContarDetalleVenta(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		return idetalleventa.contadorDetalleVenta(CodigoVenta, nombreProducto);

	}
}
