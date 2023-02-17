package com.mintic.tienda;

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

import com.mintic.tienda.dto.DetalledevolucionesDto;

// import com.mintic.tienda.dto.CalculoDto;
// import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.DevolucionesDto;
import com.mintic.tienda.entities.Detalledevoluciones;
import com.mintic.tienda.entities.Detalleventa;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.repositories.IVenta;
import com.mintic.tienda.servicio.IDetalleDevolucionesService;
import com.mintic.tienda.servicio.IDevolucionesService;
// import com.mintic.tienda.servicio.IDetalleDevolucionesService;
// import com.mintic.tienda.servicio.IProductoService;


@RestController
public class ControladorDevoluciones {
    @Autowired
	IDevolucionesService iDevoluciones;
	
	@Autowired
	IDetalleDevolucionesService idetalledevoluciones;
	
		
	@CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/Devoluciones/{CodigoVenta}")
	public DevolucionesDto MostarDevolucionesPorCodigo(@PathVariable Long CodigoVenta) {
		return iDevoluciones.buscarDevolucionesPorCodigoventa(CodigoVenta);
	}
	
	@PostMapping("/crearDevoluciones")
	public void crearDevoluciones(@RequestBody DevolucionesDto DevolucionesDto) {
		System.out.println("esta es mi venta");
		iDevoluciones.crearDevoluciones(DevolucionesDto);
	}
	
	@DeleteMapping("/eliminarDevoluciones/{CodigoVenta}")
	public void eliminarDevoluciones(@PathVariable Long CodigoVenta) {
		iDevoluciones.eliminarDevoluciones(CodigoVenta);
	}
	
	@PatchMapping("/actualizarDevoluciones/{CodigoVenta}")
	public void actualizaralDevoluciones(@PathVariable Long CodigoVenta, @RequestBody DevolucionesDto DevolucionesDto) {
		iDevoluciones.actualizarDevoluciones(CodigoVenta, DevolucionesDto);
	}
	
	@GetMapping("/Devolucioneslistar")
	public List<Devoluciones> listaDevoluciones() {
		return iDevoluciones.listaDevoluciones();
	}
	
	@GetMapping("/Devolucioneslistar/producto/{nombreProducto}")
	public List<Productos> MostarProductoPornombreProducto(@PathVariable String nombreProducto) {
		return iDevoluciones.listaDevolucionesPorProductos(nombreProducto);
	}

	@GetMapping("/Devoluciones/detalle/{CodigoVenta}")
	public List<Detalledevoluciones> MostarDetallesDevoluciones(@PathVariable Long CodigoVenta) {
		return idetalledevoluciones.ListarDetalledevolucionessPorCodigo(CodigoVenta);
	}

	@GetMapping("/Devoluciones/detalle/codigo/{CodigoVenta}/{nombreProducto}")
	public DetalledevolucionesDto MostarunDetalleDevoluciones(@PathVariable Long CodigoVenta,@PathVariable String nombreProducto ) {
		return idetalledevoluciones.buscarDetalledevolucionesCodigoyNombre(CodigoVenta, nombreProducto);
	}

	@PostMapping("/crearDevoluciones/detalles/{Codigoventa}")
	public void crearDevoluciones(@PathVariable Long Codigoventa, @RequestBody DetalledevolucionesDto DetalleDevolucionesDto) {
		System.out.println("esta es el detalle de mi venta "+ DetalleDevolucionesDto);
		idetalledevoluciones.crearDetalledevolucioness(Codigoventa, DetalleDevolucionesDto);
	}

	@PatchMapping("/Devoluciones/actualizar/detalles/{Codigoventa}/{nombreProducto}")
	public void ActualizarDetalledeventa(@PathVariable Long Codigoventa, @PathVariable String nombreProducto, @RequestBody DetalledevolucionesDto DetalleDevolucionesDto) {
		System.out.println("esta es la actualizacion de mi detalle "+ DetalleDevolucionesDto);
		idetalledevoluciones.actualizarDetalledevoluciones(Codigoventa, nombreProducto, DetalleDevolucionesDto);
	}

	@GetMapping("/Devoluciones/conteo/codigo/{CodigoVenta}")
	public Integer ContarunaVenta(@PathVariable Long CodigoVenta) {
		return iDevoluciones.ContarDevoluciones(CodigoVenta);
	}

	@GetMapping("/Devoluciones/detalle-total/codigo/{CodigoVenta}")
	public Double TotaldemiVenta(@PathVariable Long CodigoVenta) {
		return iDevoluciones.cargarCalculosdeunaDevolucion(CodigoVenta);
	}

	@DeleteMapping("/eliminarDetalleDevoluciones/{CodigoVenta}/{nombreProducto}")
	public void eliminarDetalleDevoluciones(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		idetalledevoluciones.eliminarDetalledevoluciones(CodigoVenta, nombreProducto);
	}

	@GetMapping("/Devoluciones/conteo/detalle/{CodigoVenta}/{nombreProducto}")
	public Integer ContarDetalleVenta(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		return idetalledevoluciones.contadorDetalledevoluciones(CodigoVenta, nombreProducto);

	}
}
