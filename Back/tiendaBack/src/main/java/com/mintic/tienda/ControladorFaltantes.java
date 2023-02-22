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

import com.mintic.tienda.dto.DetallefaltantesDto;
import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Detallefaltantes;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleFaltantes;
import com.mintic.tienda.servicio.IDetalleFaltantesService;
import com.mintic.tienda.servicio.IFaltantesServices;

@RestController
public class ControladorFaltantes {
    
    @Autowired
	IFaltantesServices iFaltantes;

	@Autowired
	IDetalleFaltantesService iDetallefaltantes;

	@CrossOrigin(origins = "http://localhost:8090")

	@GetMapping("/Faltantes/{CodigoVenta}")
	public FaltantesDto MostarFaltantesPorCodigo(@PathVariable Long CodigoVenta) {
		return iFaltantes.buscarFaltantesPorCodigoventa(CodigoVenta);
	}
	
	@PostMapping("/crearFaltantes")
	public void crearFaltantes(@RequestBody FaltantesDto FaltantesDto) {
		System.out.println("esta es mi venta");
		iFaltantes.crearFaltantes(FaltantesDto);
	}
	
	@DeleteMapping("/eliminarFaltantes/{CodigoVenta}")
	public void eliminarFaltantes(@PathVariable Long CodigoVenta) {
		iFaltantes.eliminarFaltantes(CodigoVenta);
	}
	
	@PatchMapping("/actualizarFaltantes/{CodigoVenta}")
	public void actualizaralFaltantes(@PathVariable Long CodigoVenta, @RequestBody FaltantesDto FaltantesDto) {
		iFaltantes.actualizarFaltantes(CodigoVenta, FaltantesDto);
	}
	
	@GetMapping("/Faltanteslistar")
	public List<Faltantes> listaFaltantes() {
		return iFaltantes.listaFaltantes();
	}
	
	@GetMapping("/Faltanteslistar/producto/{nombreProducto}")
	public List<Productos> MostarProductoPornombreProducto(@PathVariable String nombreProducto) {
		return iFaltantes.listaFaltantesPorProductos(nombreProducto);
	}

	@GetMapping("/Faltantes/detalle/{CodigoVenta}")
	public List<Detallefaltantes> MostarDetallesFaltantes(@PathVariable Long CodigoVenta) {
		return iDetallefaltantes.ListarDetallefaltantessPorCodigo(CodigoVenta);
	}

	@GetMapping("/Faltantes/detalle/codigo/{CodigoVenta}/{nombreProducto}")
	public DetallefaltantesDto MostarunDetallefaltantes(@PathVariable Long CodigoVenta,@PathVariable String nombreProducto ) {
		return iDetallefaltantes.buscarDetallefaltantesCodigoyNombre(CodigoVenta, nombreProducto);
	}

	@PostMapping("/crearFaltantes/detalles/{Codigoventa}")
	public void crearFaltantes(@PathVariable Long Codigoventa, @RequestBody DetallefaltantesDto DetallefaltantesDto) {
		iDetallefaltantes.crearDetallefaltantess(Codigoventa, DetallefaltantesDto);
	}

	@PatchMapping("/Faltantes/actualizar/detalles/{Codigoventa}/{nombreProducto}")
	public void ActualizarDetalledeventa(@PathVariable Long Codigoventa, @PathVariable String nombreProducto, @RequestBody DetallefaltantesDto DetallefaltantesDto) {
		System.out.println("esta es la actualizacion de mi detalle "+ DetallefaltantesDto);
		iDetallefaltantes.actualizarDetallefaltantes(Codigoventa, nombreProducto, DetallefaltantesDto);
	}

	@GetMapping("/Faltantes/conteo/codigo/{CodigoVenta}")
	public Integer ContarunaVenta(@PathVariable Long CodigoVenta) {
		return iFaltantes.ContarFaltantes(CodigoVenta);
	}

	@GetMapping("/Faltantes/detalle-total/codigo/{CodigoVenta}")
	public Double TotaldemiVenta(@PathVariable Long CodigoVenta) {
		return iFaltantes.cargarCalculosdeunFaltante(CodigoVenta);
	}

	@DeleteMapping("/eliminarDetallefaltantes/{CodigoVenta}/{nombreProducto}")
	public void eliminarDetallefaltantes(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		iDetallefaltantes.eliminarDetallefaltantes(CodigoVenta, nombreProducto);
	}

	@GetMapping("/Faltantes/conteo/detalle/{CodigoVenta}/{nombreProducto}")
	public Integer ContarDetalleVenta(@PathVariable Long CodigoVenta, @PathVariable String nombreProducto) {
		return iDetallefaltantes.contadorDetallefaltantes(CodigoVenta, nombreProducto);

	}

	

}
