package com.mintic.tiendafront;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.client.ICliente;
import com.mintic.tiendafront.client.IProducto;
import com.mintic.tiendafront.client.IVendedor;
import com.mintic.tiendafront.client.IDevoluciones;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.DetalleDevolucionesDto;
import com.mintic.tiendafront.dto.DetalleDevolucionesResponse;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.DevolucionesDto;
import com.mintic.tiendafront.dto.DevolucionesResponse;
import com.mintic.tiendafront.Controlador;


@Controller
public class ControladorDevoluciones {
    @Autowired
	IDevoluciones iDevoluciones;
	
	@Autowired
	ICliente icliente;
	
	@Autowired
	IVendedor iVendedor;
	
	@Autowired
	IProducto iProducto;

    @GetMapping("/devoluciones")
	public String Devoluciones(Model model) 
	{	
		
		model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
		
		
		if(model.getAttribute("devoluciones") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "devoluciones";
	}

	@PostMapping("/devoluciones")
	public String crearDevoluciones(Model model, DevolucionesDto Devoluciones) {
		if (Devoluciones.getID().longValue() == 0) {
			ValidacionCrearDevoluciones(model, Devoluciones);

			if (ValidacionCrearDevoluciones(model, Devoluciones) == true) {

				iDevoluciones.guardarDevoluciones(Devoluciones);
				model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
				model.addAttribute("mensaje", "Devoluciones Creada con exito");
			}
		} else {

			if (ValidacionCrearDevoluciones(model, Devoluciones) == true){
				iDevoluciones.ActualizarDevoluciones(Devoluciones, Devoluciones.getCodigoVenta());
				model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
				model.addAttribute("mensaje", "Datos del Devoluciones Actualizados");
			}
		}

		return "devoluciones";
	}

	@GetMapping("/devoluciones/{CodigoVenta}")
	public String actualizarDevoluciones(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {
		DevolucionesResponse devolucionesEditar = iDevoluciones.buscarDevolucionesCodigo(CodigoVenta);
		ValidacionActualizarDevoluciones(model, devolucionesEditar);
		if (ValidacionActualizarDevoluciones(model, devolucionesEditar) == true) {
			model.addAttribute("devolucionesEditar", devolucionesEditar);
			model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
			model.addAttribute("mensaje", "");
		}

		return "devoluciones";

	}
	
	@GetMapping("/BuscarDevolucionesPorCodigo/{CodigoVenta}")
	public String BuscarDevolucionesPorCodigo(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {

		if (ValidacionPorCodigo(model, CodigoVenta)) {
			DevolucionesResponse devolucionesEditar = iDevoluciones.buscarDevolucionesCodigo(CodigoVenta);

			if (devolucionesEditar == null) {
				model.addAttribute("mensaje", "Devoluciones Inexistente");
			} else {
				model.addAttribute("devolucionesEditar", devolucionesEditar);
				model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());

			}
		}

		return "devoluciones";
	}

	private boolean ValidacionPorCodigo(Model model, Long CodigoVenta) {
		if (CodigoVenta == 0) {
			model.addAttribute("mensaje", "Ingrese codigo de Venta para la busqueda");
			return false;
		}

		return true;
	}

	private boolean ValidacionCrearDevoluciones(Model model, DevolucionesDto Devoluciones) {

		while (Devoluciones.getCodigoVenta() == null || Devoluciones.getNombreVendedor() == null || Devoluciones.getFechaVenta().isEmpty() ){
			model.addAttribute("mensaje", "Faltan Datos por Favor Validar");
			model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
			

			return false;
		}

		int conteo = iDevoluciones.ContadordeDevoluciones(Devoluciones.getCodigoVenta());
		if (conteo == 1) {
			model.addAttribute("mensaje", "Devoluciones Repetida");
			
			model.addAttribute("devoluciones", iDevoluciones.ListarDevoluciones());
			return false;

		}
		
		return true;
	}

	private boolean ValidacionActualizarDevoluciones(Model model, DevolucionesResponse devolucionesEditar) {

		while (devolucionesEditar.getCodigoVenta() == null || devolucionesEditar.getNombreVendedor() == null || devolucionesEditar.getFechaVenta().isEmpty()){
			model.addAttribute("mensaje", "Faltan Datos para poder actualizar ");
			model.addAttribute("Devoluciones", iDevoluciones.ListarDevoluciones());
			

			return false;
		}
		
		return true;

	}

	@PostMapping("/detalledevoluciones/{CodigoVenta}")
	public String crearDetalleDevoluciones(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta,	DetalleDevolucionesDto Detalle) {
		if (Detalle.getID().longValue() == 0) {
			ValidacionCrearDetalledeunaDevoluciones(model, Detalle);

			if (ValidacionCrearDetalledeunaDevoluciones(model, Detalle) == true) {

				iDevoluciones.nuevoDevolucionesDetalle(CodigoVenta, Detalle);
				model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
				model.addAttribute("productos", iProducto.getProductos());
				model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
				model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
				model.addAttribute("TotalsinIVa",
				iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
				model.addAttribute("mensaje", "Producto Agregado con exito");
			}
		} else {
			iDevoluciones.ActualizarDetalleDevoluciones(CodigoVenta, Detalle.getNombreProducto(), Detalle);
			model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
			model.addAttribute("productos", iProducto.getProductos());
			model.addAttribute("mensaje", "Datos del Detalle Actualizados");
			model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
			model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
			model.addAttribute("TotalsinIVa",
				iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
		}

		return "detalledevoluciones";
	}

	@GetMapping("/detalledevoluciones/{CodigoVenta}/{nombreProducto}")
	public String actualizarDetalleDevoluciones(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {
		DetalleDevolucionesResponse DetalledevolucionesEditar = iDevoluciones.DetalladeunaDevoluciones(CodigoVenta, nombreProducto);
		ValidacionActualizarDetalle(model, DetalledevolucionesEditar);
		if (ValidacionActualizarDetalle(model, DetalledevolucionesEditar) == true) {
			model.addAttribute("detalledevolucionesEditar", DetalledevolucionesEditar);
			model.addAttribute("productos", iProducto.ListarProductosNombre(nombreProducto));
			model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
			model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
			model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
			model.addAttribute("TotalsinIVa",
				iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
			model.addAttribute("mensaje", "Detalle Actulizado");
		}

		return "detalledevoluciones";

	
	}

	private boolean ValidacionPorCodigoyNombre(Model model, Long CodigoVenta, String nombreProducto) {
		if (CodigoVenta == 0 && nombreProducto.isBlank()) {
			model.addAttribute("mensaje", "Ingrese datos correctos para la busqueda");
			return false;
		}

		return true;
	}

	@GetMapping("/BuscarDetalleDevoluciones/{CodigoVenta}/{nombreProducto}")
	public String BuscarDevolucionesDetallePorCodigoyNombre(Model model,
			@PathVariable(name = "CodigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {

		if (ValidacionPorCodigoyNombre(model, CodigoVenta, nombreProducto)) {
			DetalleDevolucionesResponse DetalleEditar = iDevoluciones.DetalladeunaDevoluciones(CodigoVenta, nombreProducto);

			if (DetalleEditar == null) {
				model.addAttribute("mensaje", "Devoluciones Inexistente");
			} else {
				model.addAttribute("detalledevolucionesEditar", DetalleEditar);
				model.addAttribute("productos", iProducto.ListarProductosNombre(nombreProducto));
				model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
				model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
				model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
				model.addAttribute("TotalsinIVa",
				iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta) * .16);
			}
		}

		return "detalledevoluciones";
	}

	
	private boolean ValidacionCrearDetalledeunaDevoluciones(Model model, DetalleDevolucionesDto detalle) {

		while(detalle.getCantidad() == 0 ){
			model.addAttribute("mensaje", "Faltan datos por favor verificar");
			return false;
		}

		
		return true;
	}

	private boolean ValidacionActualizarDetalle(Model model, DetalleDevolucionesResponse detalledevolucionesEditar) {

		if (detalledevolucionesEditar.getProductos().getNombreProducto().isBlank()) {
			model.addAttribute("mensaje", "Faltan datos del devoluciones");
			return false;
		}
		if (detalledevolucionesEditar.getCantidad() == 0) {
			model.addAttribute("mensaje", "Faltan datos del devoluciones");
			return false;
		}
		if (detalledevolucionesEditar.getPrecioProducto().longValue() == 0) {
			model.addAttribute("mensaje", "Faltan datos del devoluciones");
			return false;
		}

		return true;

	}


	@GetMapping("/reporteDevoluciones")
	public String reporteDevoluciones(Model model) {
		List<DevolucionesResponse> DevolucionesResponse = iDevoluciones.ListarDevoluciones();
		model.addAttribute("devoluciones", DevolucionesResponse);
		
		if(model.getAttribute("devoluciones") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteDevoluciones";
	}
	
	
	@GetMapping("/detalledevoluciones/{CodigoVenta}")
	public String reportesDetallesDevoluciones(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {
		// Double TotaldeunaDevoluciones =  iDevoluciones.totalDevoluciones(CodigoVenta);
		int valor  = 0;
		model.addAttribute("cantidad", valor);
		model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
		model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
		model.addAttribute("productos", iProducto.getProductos());
		model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
		model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta)* .16);
		model.addAttribute("TotalsinIVa",
		iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta)* .16);
		if(model.getAttribute("detalleDevoluciones") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "detalledevoluciones";
	}
	
	@GetMapping("/eliminarDetalleDevoluciones/{CodigoVenta}/{nombreProducto}")
	public String eliminarUsuario(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {
		
		iDevoluciones.eliminarDetalleDevoluciones(CodigoVenta, nombreProducto);
		model.addAttribute("CodigoVenta", CodigoVenta);
		model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
		model.addAttribute("detalledevoluciones", iDevoluciones.ListarDetalleDevoluciones(CodigoVenta));
		model.addAttribute("productos", iProducto.getProductos());
		model.addAttribute("TotalDevoluciones", iDevoluciones.totalDevoluciones(CodigoVenta));
		model.addAttribute("TotalIVa", iDevoluciones.totalDevoluciones(CodigoVenta)* .16);
		model.addAttribute("TotalsinIVa",
		iDevoluciones.totalDevoluciones(CodigoVenta) - iDevoluciones.totalDevoluciones(CodigoVenta)* .16);		
		return "detalledevoluciones";
	}


}
