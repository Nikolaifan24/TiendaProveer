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
import com.mintic.tiendafront.client.IVenta;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.ProductoResponse;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;
import com.mintic.tiendafront.Controlador;

@Controller
public class ControladorVentas {
	
	@Autowired
	IVenta iVenta;
	
	@Autowired
	IClientTienda clienteTienda;
	
	@Autowired
	ICliente icliente;
	
	LoginDto loginDto;
	
	

	// @PostMapping("/venta")
	// public String buscarProducto(Model model, ProductoResponse productosVenta) {
	// 	Long idUsuario = 1l;
	// 	ClienteResponse cliente = icliente.buscarCliente(idUsuario);
		
	// 	ProductoDto producto = iVenta.BuscarProductopornombre(productosVenta.getNombreProducto());
				
	// 	Map<ProductoDto, Integer> productosMap = new LinkedHashMap<>();
	// 	productosMap.put(producto,  productosVenta.getCantidadProducto1());
	// 	VentaDto totalVenta = iVenta.calcularTotalVenta(productosMap);
	// 	if (cliente != null && cliente.getDocumentoCliente() != null) {
	// 		iVenta.guardarVenta(totalVenta, idUsuario, cliente );
	// 	}
	// 	//VentaDto totalVenta = iVenta.guardarVenta(totalVenta, idUsuario, );
		
		
	// 	model.addAttribute("totalVenta", totalVenta);
		
	// 	return "venta";
	// }

	@GetMapping("/venta")
	public String ventas(Model model) 
	{
		model.addAttribute("ventas", iVenta.ListarVentas());
		
		if(model.getAttribute("ventas") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "ventas";
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
		model.addAttribute("detalleventa", iVenta.ListarDetalleVentas(CodigoVenta));
		
		if(model.getAttribute("detalleventa") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "detalleventa";
	}
	
}
