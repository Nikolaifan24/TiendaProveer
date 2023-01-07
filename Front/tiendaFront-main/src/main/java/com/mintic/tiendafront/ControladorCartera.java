package com.mintic.tiendafront;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mintic.tiendafront.client.ICartera;
// import com.mintic.tiendafront.client.icartera;
import com.mintic.tiendafront.dto.CarteraDto;
import com.mintic.tiendafront.dto.CarteraResponse;
import com.mintic.tiendafront.dto.ProveedorResponse;

public class ControladorCartera {
    
    
    @Autowired
	ICartera icartera;	
	
	@GetMapping("/Cartera")
	public String Cartera(Model model) 
	{
		model.addAttribute("Carteras", icartera.ListarCarteras());
		
		if(model.getAttribute("Carteras") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "Cartera";
	}

	@PostMapping("/Cartera")
	public String crearCartera(Model model, CarteraDto Cartera) 
	{
		if(Cartera.getIDCartera().longValue() == 0) {
			ValidacionCrearCartera(model, Cartera);
			
			if(ValidacionCrearCartera(model, Cartera) == true) 
			{
				icartera.nuevaCartera(Cartera);				
				model.addAttribute("Carteras", icartera.ListarCarteras());
				model.addAttribute("mensaje", "Cartera Creado");			
			}		
		}else {
			icartera.ActualizarCartera(Cartera, Cartera.getClientes().getNombreCliente());		
			model.addAttribute("Carteras", icartera.ListarCarteras());
			model.addAttribute("mensaje", "Datos del Cartera Actualizados");		
		}	
		
		

		return "Cartera";
	}

	@GetMapping("/Cartera/{nombreCliente}")
	public String actualizarCartera(Model model, @PathVariable(name = "nombreCliente") String nombreCliente)
	{
		//CarteraResponse CarteraEditar = icartera.buscarCartera(nombreCliente);
		//ValidacionActualizarCartera(model, CarteraEditar);
		//if(ValidacionActualizarCartera(model, CarteraEditar) == true)
		//{			
			//model.addAttribute("CarteraEditar", CarteraEditar);
			//model.addAttribute("Carteras", icartera.ListarCarteras);
			//model.addAttribute("mensaje", "");
		//}

		//return "Cartera";
		
		if (nombreCliente != " ") {
			CarteraResponse CarteraEditar = icartera.buscarCartera(nombreCliente);
			model.addAttribute("CarteraEditar", CarteraEditar);
		}
		
		return "Cartera";
	}


	@GetMapping("/BuscarCarteraPorCedula/{nombreCliente}")
	public String BuscarCarteraPorCedula(Model model, @PathVariable(name = "nombreCliente") String nombreCliente)
	{		
		
		if(ValidacionPorCedula(model, nombreCliente))
		{	
			CarteraResponse CarteraEditar = icartera.buscarCartera(null);
			
			if(CarteraEditar == null) {
				model.addAttribute("mensaje", "Cartera Inexistente");
			}
			else {
				model.addAttribute("CarteraEditar", CarteraEditar);
			}	
		}

		return "Cartera";
	}
	
	private boolean ValidacionPorCedula(Model model, String nombreCliente) 
	{		
		if(nombreCliente != " ") 
		{
			model.addAttribute("mensaje", "Ingrese numero de Cartera para la busqueda");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionCrearCartera(Model model, CarteraDto Cartera) 
	{		
		if(Cartera.getClientes().getNombreCliente().isBlank() ) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cartera");
			return false;
		}
		if(Cartera.getVentas().getFechaVenta().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del Cartera");
			return false;
		}
		if(Cartera.getPagos().getFechaPago().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cartera");
			return false;
		}
		if(Cartera.getSaldo().longValue()  == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cartera");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionActualizarCartera(Model model, CarteraResponse CarteraEditar)
	{
		
		if(CarteraEditar.getClientes().getNombreCliente().isBlank() ) 
		{
			model.addAttribute("mensaje", "Faltan datos de Cartera");
			return false;
		}
		if(CarteraEditar.getVentas().getFechaVenta().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos de CarteraEditar");
			return false;
		}
		if(CarteraEditar.getPagos().getFechaPago().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos de CarteraEditar");
			return false;
		}
		if(CarteraEditar.getSaldo().longValue()  == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos de Cartera");
			return false;
		}		
		
		return true;
		
	}
	
	
	// @GetMapping("/reporte")
	// public String reportes() {
	// 	return "reporte";
	// }
	
	
	@GetMapping("/reporteCartera")
	public String reportesCartera(Model model) {
		model.addAttribute("Carteras", icartera.ListarCarteras());
		
		if(model.getAttribute("Carteras") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteCartera";
	}
	


}
