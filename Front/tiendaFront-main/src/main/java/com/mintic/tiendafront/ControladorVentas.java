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
import com.mintic.tiendafront.client.IVenta;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.DetalleVentaResponse;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;
import com.mintic.tiendafront.Controlador;

@Controller
public class ControladorVentas {
	
	@Autowired
	IVenta iVenta;
	
	@Autowired
	ICliente icliente;
	
	@Autowired
	IVendedor iVendedor;
	
	@Autowired
	IProducto iProducto;
	



	@GetMapping("/venta")
	public String ventas(Model model) 
	{	
		
		model.addAttribute("ventas", iVenta.ListarVentas());
		model.addAttribute("vendedor", iVendedor.ListarVendedors());
		
		if(model.getAttribute("ventas") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "ventas";
	}

	@PostMapping("/venta")
	public String crearVentas(Model model, VentaDto ventas) {
		if (ventas.getID().longValue() == 0) {
			ValidacionCrearVentas(model, ventas);

			if (ValidacionCrearVentas(model, ventas) == true) {

				iVenta.guardarVenta(ventas);
				model.addAttribute("ventas", iVenta.ListarVentas());
				model.addAttribute("vendedor", iVendedor.ListarVendedors());
				model.addAttribute("mensaje", "Venta Creada con exito");
			}
		} else {

			if (ValidacionCrearVentas(model, ventas) == true){
				iVenta.ActualizarVenta(ventas, ventas.getCodigoVenta());
				model.addAttribute("ventas", iVenta.ListarVentas());
				model.addAttribute("mensaje", "Datos del ventas Actualizados");
			}
		}

		return "ventas";
	}

	@GetMapping("/venta/{CodigoVenta}")
	public String actualizarVentas(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {
		VentaResponse VentasEditar = iVenta.buscarVentaCodigo(CodigoVenta);
		ValidacionActualizarVentas(model, VentasEditar);
		if (ValidacionActualizarVentas(model, VentasEditar) == true) {
			model.addAttribute("VentasEditar", VentasEditar);
			model.addAttribute("ventas", iVenta.ListarVentas());
			model.addAttribute("mensaje", "");
		}

		return "ventas";

	}
	
	@GetMapping("/BuscarVentasPorCodigo/{CodigoVenta}")
	public String BuscarVentasPorCodigo(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {

		if (ValidacionPorCodigo(model, CodigoVenta)) {
			VentaResponse VentasEditar = iVenta.buscarVentaCodigo(CodigoVenta);

			if (VentasEditar == null) {
				model.addAttribute("mensaje", "Venta Inexistente");
			} else {
				model.addAttribute("VentaEditar", VentasEditar);
				model.addAttribute("Ventas", iVenta.ListarVentas());

			}
		}

		return "ventas";
	}

	private boolean ValidacionPorCodigo(Model model, Long CodigoVenta) {
		if (CodigoVenta == 0) {
			model.addAttribute("mensaje", "Ingrese numero de Ventas para la busqueda");
			return false;
		}

		return true;
	}

	private boolean ValidacionCrearVentas(Model model, VentaDto Ventas) {

		while (Ventas.getCodigoVenta() == null || Ventas.getDocumentoCliente() == null || Ventas.getFechaVenta().isEmpty() ||  Ventas.getFechaEntrega().isEmpty()){
			model.addAttribute("mensaje", "Faltan Datos por Favor Validar");
			model.addAttribute("ventas", iVenta.ListarVentas());
			model.addAttribute("vendedor", iVendedor.ListarVendedors());

			return false;
		}

		int conteo = iVenta.ContadordeVentas(Ventas.getCodigoVenta());
		if (conteo == 1) {
			model.addAttribute("mensaje", "Venta Repetida");
			model.addAttribute("vendedor", iVendedor.ListarVendedors());
			model.addAttribute("ventas", iVenta.ListarVentas());
			return false;

		}
		
		return true;
	}

	private boolean ValidacionActualizarVentas(Model model, VentaResponse VentasEditar) {

		while (VentasEditar.getCodigoVenta() == null || VentasEditar.getDocumentoCliente() == null || VentasEditar.getFechaVenta().isEmpty() ||  VentasEditar.getFechaEntrega().isEmpty()){
			model.addAttribute("mensaje", "Faltan Datos para poder actualizar ");
			model.addAttribute("ventas", iVenta.ListarVentas());
			model.addAttribute("vendedor", iVendedor.ListarVendedors());

			return false;
		}
		
		return true;

	}

	@PostMapping("/detalleventa/{CodigoVenta}")
	public String crearDetalleVentas(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta,	DetalleVentaDto Detalle) {
		if (Detalle.getID().longValue() == 0) {
			ValidacionCrearDetalledeunaVenta(model, Detalle);

			if (ValidacionCrearDetalledeunaVenta(model, Detalle) == true) {

				iVenta.nuevoVentaDetalle(CodigoVenta, Detalle);
				model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
				model.addAttribute("productos", iProducto.getProductos());
				model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
				model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta) * .16);
				model.addAttribute("TotalsinIVa",
				iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta) * .16);
				model.addAttribute("mensaje", "Producto Agregado con exito");
			}
		} else {
			iVenta.ActualizarDetalleVenta(CodigoVenta, Detalle.getNombreProducto(), Detalle);
			model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
			model.addAttribute("productos", iProducto.getProductos());
			model.addAttribute("mensaje", "Datos del Detalle Actualizados");
			model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
			model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta) * .16);
			model.addAttribute("TotalsinIVa",
				iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta) * .16);
		}

		return "detalleventa";
	}

	@GetMapping("/detalleVenta/{CodigoVenta}/{nombreProducto}")
	public String actualizarDetalleVentas(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {
		DetalleVentaResponse DetalleVentasEditar = iVenta.DetalladeunaVenta(CodigoVenta, nombreProducto);
		ValidacionActualizarDetalle(model, DetalleVentasEditar);
		if (ValidacionActualizarDetalle(model, DetalleVentasEditar) == true) {
			model.addAttribute("detalleVentaEditar", DetalleVentasEditar);
			model.addAttribute("productos", iProducto.ListarProductosNombre(nombreProducto));
			model.addAttribute("detalleVenta", iVenta.ListarDetalleVentas(CodigoVenta));
			model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
			model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta) * .16);
			model.addAttribute("TotalsinIVa",
				iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta) * .16);
			model.addAttribute("mensaje", "Detalle Actulizado");
		}

		return "detalleVenta";

	
	}

	private boolean ValidacionPorCodigoyNombre(Model model, Long CodigoVenta, String nombreProducto) {
		if (CodigoVenta == 0 && nombreProducto.isBlank()) {
			model.addAttribute("mensaje", "Ingrese datos correctos para la busqueda");
			return false;
		}

		return true;
	}

	@GetMapping("/BuscarDetalle/{CodigoVenta}/{nombreProducto}")
	public String BuscarVentasDetallePorCodigoyNombre(Model model,
			@PathVariable(name = "CodigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {

		if (ValidacionPorCodigoyNombre(model, CodigoVenta, nombreProducto)) {
			DetalleVentaResponse DetalleEditar = iVenta.DetalladeunaVenta(CodigoVenta, nombreProducto);

			if (DetalleEditar == null) {
				model.addAttribute("mensaje", "Venta Inexistente");
			} else {
				model.addAttribute("detalleVentaEditar", DetalleEditar);
				model.addAttribute("productos", iProducto.ListarProductosNombre(nombreProducto));
				model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
				model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
				model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta) * .16);
				model.addAttribute("TotalsinIVa",
				iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta) * .16);
			}
		}

		return "detalleventa";
	}

	
	private boolean ValidacionCrearDetalledeunaVenta(Model model, DetalleVentaDto detalle) {

		while(detalle.getCantidad() == 0 ){
			model.addAttribute("mensaje", "Faltan datos por favor verificar");
			return false;
		}

		
		return true;
	}

	private boolean ValidacionActualizarDetalle(Model model, DetalleVentaResponse detalleVentaEditar) {

		if (detalleVentaEditar.getProductos().getNombreProducto().isBlank()) {
			model.addAttribute("mensaje", "Faltan datos del Ventas");
			return false;
		}
		if (detalleVentaEditar.getCantidad() == 0) {
			model.addAttribute("mensaje", "Faltan datos del Ventas");
			return false;
		}
		if (detalleVentaEditar.getPrecioProducto().longValue() == 0) {
			model.addAttribute("mensaje", "Faltan datos del Ventas");
			return false;
		}

		return true;

	}


	@GetMapping("/reporteVenta")
	public String reporteVenta(Model model) {
		List<VentaResponse> ventaResponse = iVenta.ListarVentas();
		model.addAttribute("ventas", ventaResponse);
		
		if(model.getAttribute("ventas") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteVenta";
	}
	
	
	@GetMapping("/detalleventa/{CodigoVenta}")
	public String reportesDetallesventas(Model model, @PathVariable(name = "CodigoVenta") Long CodigoVenta) {
		// Double Totaldeunaventa =  iVenta.totalVenta(CodigoVenta);
		int valor  = 0;
		model.addAttribute("cantidad", valor);
		model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
		model.addAttribute("detalleVenta", iVenta.ListarDetalleVentas(CodigoVenta));
		model.addAttribute("productos", iProducto.getProductos());
		model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
		model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta)* .16);
		model.addAttribute("TotalsinIVa",
		iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta)* .16);
		if(model.getAttribute("detalleventa") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "detalleventa";
	}
	
	@GetMapping("/eliminarDetalleVenta/{codigoVenta}/{nombreProducto}")
	public String eliminarUsuario(Model model, @PathVariable(name = "codigoVenta") Long CodigoVenta,
			@PathVariable(name = "nombreProducto") String nombreProducto) {
		
		iVenta.eliminarDetalleVenta(CodigoVenta, nombreProducto);
		model.addAttribute("CodigoVenta", CodigoVenta);
		model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
		model.addAttribute("detalleVenta", iVenta.ListarDetalleVentas(CodigoVenta));
		model.addAttribute("productos", iProducto.getProductos());
		model.addAttribute("TotalVenta", iVenta.totalVenta(CodigoVenta));
		model.addAttribute("TotalIVa", iVenta.totalVenta(CodigoVenta)* .16);
		model.addAttribute("TotalsinIVa",
		iVenta.totalVenta(CodigoVenta) - iVenta.totalVenta(CodigoVenta)* .16);		
		return "detalleventa";
	}


}
