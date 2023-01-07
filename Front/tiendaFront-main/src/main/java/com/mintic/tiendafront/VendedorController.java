package com.mintic.tiendafront;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mintic.tiendafront.client.IVendedor;
// import com.mintic.tiendafront.client.Iendedor;
import com.mintic.tiendafront.dto.VendedorDto;
import com.mintic.tiendafront.dto.VendedorResponse;
// import com.mintic.tiendafront.dto.ProveedorResponse;


@Controller
public class VendedorController {

    @Autowired
	IVendedor ivendedor;	
	
	@GetMapping("/vendedor")
	public String vendedor(Model model) 
	{
		model.addAttribute("vendedor", ivendedor.ListarVendedors());
		
		if(model.getAttribute("vendedor") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "vendedor";
	}

	@PostMapping("/vendedor")
	public String crearvendedor(Model model, VendedorDto vendedor) 
	{
		if(vendedor.getIDVendedor().longValue() == 0) {
			ValidacionCrearvendedor(model, vendedor);
			
			if(ValidacionCrearvendedor(model, vendedor) == true) 
			{
				ivendedor.nuevoVendedor(vendedor);				
				model.addAttribute("vendedors", ivendedor.ListarVendedors());
				model.addAttribute("mensaje", "vendedor Creado");			
			}		
		}else {
			ivendedor.ActualizarVendedor(vendedor, vendedor.getNombreVendedor());		
			model.addAttribute("vendedors", ivendedor.ListarVendedors());
			model.addAttribute("mensaje", "Datos del vendedor Actualizados");		
		}	
		
		

		return "vendedor";
	}

	@GetMapping("/vendedor/{nombreVendedor}")
	public String actualizarvendedor(Model model, @PathVariable(name = "nombreVendedor") String nombreVendedor)
	{
		//VendedorResponse vendedorEditar = ivendedor.buscarvendedor(nombreVendedor);
		//ValidacionActualizarvendedor(model, vendedorEditar);
		//if(ValidacionActualizarvendedor(model, vendedorEditar) == true)
		//{			
			//model.addAttribute("vendedorEditar", vendedorEditar);
			//model.addAttribute("vendedors", ivendedor.getvendedors());
			//model.addAttribute("mensaje", "");
		//}

		//return "vendedor";
		
		if (nombreVendedor != " ") {
			VendedorResponse vendedorEditar = ivendedor.buscarVendedor(null);
			model.addAttribute("vendedorEditar", vendedorEditar);
		}
		
		return "vendedor";
	}

	@GetMapping("/eliminarvendedor/{nombreVendedor}")
	public String eliminarvendedor(Model model, @PathVariable(name = "nombreVendedor") String nombreVendedor) {

		ValidacionPorNombre(model, nombreVendedor);
		ivendedor.borrarVendedor(nombreVendedor);
		model.addAttribute("vendedors", ivendedor.ListarVendedors());
		model.addAttribute("mensaje", "Datos del vendedor Eliminados");
			
		return "vendedor";
	}
	
	@GetMapping("/BuscarvendedorPorCedula/{nombreVendedor}")
	public String BuscarvendedorPorCedula(Model model, @PathVariable(name = "nombreVendedor") String nombreVendedor)
	{		
		
		if(ValidacionPorNombre(model, nombreVendedor))
		{	
			VendedorResponse vendedorEditar = ivendedor.buscarVendedor(nombreVendedor);
			
			if(vendedorEditar == null) {
				model.addAttribute("mensaje", "vendedor Inexistente");
			}
			else {
				model.addAttribute("vendedorEditar", vendedorEditar);
			}	
		}

		return "vendedor";
	}
	
	private boolean ValidacionPorNombre(Model model, String nombreVendedor) 
	{		
		if(nombreVendedor == " ") 
		{
			model.addAttribute("mensaje", "Ingrese numero de vendedor para la busqueda");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionCrearvendedor(Model model, VendedorDto vendedor) 
	{		
		
		if(vendedor.getDireccionVendedor().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}
		if(vendedor.getNombreVendedor().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}
		if(vendedor.getTelefonoVendedor().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionActualizarvendedor(Model model, VendedorResponse vendedorEditar)
	{
		
		if(vendedorEditar.getIDVendedor().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}
		if(vendedorEditar.getDireccionVendedor().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}
		if(vendedorEditar.getNombreVendedor().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}
		if(vendedorEditar.getTelefonoVendedor().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del vendedor");
			return false;
		}		
		
		return true;
		
	}
	
	
	// @GetMapping("/reporte")
	// public String reportes() {
	// 	return "reporte";
	// }
	
	
	@GetMapping("/reportevendedor")
	public String reportesvendedor(Model model) {
		model.addAttribute("vendedors", ivendedor.ListarVendedors());
		
		if(model.getAttribute("vendedors") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reportevendedor";
	}
	


    
}
