package com.mintic.tiendafront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mintic.tiendafront.client.IProveedor;
import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorResponse;


@Controller
public class ProveedorController {
	
	@Autowired
	IProveedor proveedores;
	
	@GetMapping("/proveedor")
	public String proveedor(Model model) {

		model.addAttribute("proveedores", proveedores.getProveedores());
		
		if(model.getAttribute("proveedores") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}
		
		return "proveedor";
		
	}

	@PostMapping("/proveedor")
	public String crearProveedor(Model model, Proveedor proveedor) {

		if(proveedor.getid().longValue() == 0 ) {
			
			Validacion(model, proveedor);
			
			if(Validacion(model, proveedor) == true) 
			{
				proveedores.nuevoProveedor(proveedor);				
				model.addAttribute("proveedores", proveedores.getProveedores());
				model.addAttribute("mensaje", "Proveedor Creado");			
			}	
			
		}
		else {
			proveedores.ActualizarProveedor(proveedor, proveedor.getNit().longValue());		
			model.addAttribute("proveedores", proveedores.getProveedores());
			model.addAttribute("mensaje", "Datos del proveedor Actualizados");		
		}	
		
		return "proveedor";
	}

	@GetMapping("/proveedor/{nit}")
	public String actualizarProveedor(Model model, @PathVariable(name = "nit") Long nit) 
	{
		if (nit > 0) {
			ProveedorResponse proveedorEditar = proveedores.buscarProveedor(nit);
			model.addAttribute("proveedorEditar", proveedorEditar);		
		}
		
		//Validacion(model, proveedorEditar);
		//if(Validacion(model, proveedorEditar) == true)
		//{			
				
			//model.addAttribute("proveedores", proveedores.getProveedores());
			//model.addAttribute("mensaje", "Datos del proveedor Actualizados");
		//}
		

		return "proveedor";
	}

	@GetMapping("/eliminarproveedor/{nit}")
	
	public String eliminarProveedor(Model model, @PathVariable("nit") long nit) {

		ValidacionPorNit(model, nit);
		proveedores.borrarProveedor(nit);
		model.addAttribute("proveedores", proveedores.getProveedores());
		model.addAttribute("mensaje", "Datos del proveedor Eliminados");
			
		return "proveedor";
	}
		
	@GetMapping("/proveedorPorNit/{nit}")
	public String BuscarProveedorPorNit(Model model, @PathVariable(name = "nit") Long nit)
	{		
		
		if(ValidacionPorNit(model, nit))
		{	
			ProveedorResponse proveedorEditar = proveedores.buscarProveedor(nit);
			if(proveedorEditar == null) 
			{
				model.addAttribute("mensaje", "Proveedor Inexistente");
			}
			else {
				
				model.addAttribute("proveedorEditar", proveedorEditar);
			}	
		}

		return "proveedor";
	}
		
	private boolean ValidacionPorNit(Model model, Long Nit) 
	{		
		if(Nit == 0 || Nit == null) 
		{
			model.addAttribute("mensaje", "Ingrese numero de Proveedor para la busqueda");
			return false;
		}		
		
		return true;
	}
	
	private boolean Validacion(Model model, Proveedor proveedor) 
	{		
		if(proveedor.getNit().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedor.getNombre().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedor.getCiudad().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedor.getAddress().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedor.getTelefono().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}		
		
		return true;
	}
	
	private boolean Validacion(Model model, ProveedorResponse proveedorEditar) {
		
		if(proveedorEditar.getNit().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedorEditar.getNombre().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedorEditar.getCiudad().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedorEditar.getAddress().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		if(proveedorEditar.getTelefono().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}		
		
		return true;
		
	}
	
	

}
