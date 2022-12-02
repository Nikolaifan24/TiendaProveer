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
import com.mintic.tiendafront.dto.ProductoVenta;
import com.mintic.tiendafront.dto.ResultadoVentaDto;
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
	
	

	@GetMapping("/venta")
	public String b() {
		//Controlador controlador = new Controlador();
		//System.out.println(" Esto es una prueba: " +controlador.clienteTienda.login(loginDto));
		return "venta";
	}
	
	@PostMapping("/venta")
	public String buscarProducto(Model model, ProductoVenta productosVenta) {
		Long idUsuario = 1l;
		ClienteResponse cliente = icliente.buscarCliente(productosVenta.getCedulaCliente());
		
		ProductoDto producto1 = iVenta.getProduct(Long.valueOf(productosVenta.getCodigoProducto1()));
		ProductoDto producto2 = iVenta.getProduct(Long.valueOf(productosVenta.getCodigoProducto2()));
		ProductoDto producto3 = iVenta.getProduct(Long.valueOf(productosVenta.getCodigoProducto3()));
		
		Map<ProductoDto, Integer> productosMap = new LinkedHashMap<>();
		productosMap.put(producto1,  productosVenta.getCantidadProducto1());
		productosMap.put(producto2,  productosVenta.getCantidadProducto2());
		productosMap.put(producto3,  productosVenta.getCantidadProducto3());
		VentaDto totalVenta = iVenta.calcularTotalVenta(productosMap);
		if (cliente != null && cliente.getcedulaCliente() != null) {
			iVenta.guardarVenta(totalVenta, idUsuario, cliente );
		}
		//VentaDto totalVenta = iVenta.guardarVenta(totalVenta, idUsuario, );
		
		
		model.addAttribute("totalVenta", totalVenta);
		
		return "venta";
	}
	
	@GetMapping("/reporteVenta")
	public String reporteVenta(Model model) {
		List<VentaResponse> ventaResponse = iVenta.getVentas();
		model.addAttribute("ventas", ventaResponse);
		
		if(model.getAttribute("ventas") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteVenta";
	}
	
	
	
	
}
