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
import com.mintic.tiendafront.dto.ProveedoresDto;
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
	public String crearProveedor(Model model, ProveedoresDto proveedor) {

		if(proveedor.getIDProveedor().longValue() == 0 ) {
			
			ValidacionCrear(model, proveedor);
			
			if(ValidacionCrear(model, proveedor) == true) 
			{
				proveedores.nuevoProveedor(proveedor);				
				model.addAttribute("proveedores", proveedores.getProveedores());
				model.addAttribute("mensaje", "Proveedor Creado");			
			}	
			
		}
		else {
			proveedores.ActualizarProveedor(proveedor, proveedor.getNitProveedor());		
			model.addAttribute("proveedores", proveedores.getProveedores());
			model.addAttribute("mensaje", "Datos del proveedor Actualizados");		
		}	
		
		return "proveedor";
	}

	@GetMapping("/proveedor/{nitProveedor}")
	public String actualizarProveedor(Model model, @PathVariable(name = "nitProveedor") Long nit) 
	{
		if (nit > 0) {
			ProveedorResponse proveedorEditar = proveedores.buscarProveedor(nit);
			model.addAttribute("proveedorEditar", proveedorEditar);		
		}
		
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
		
	@GetMapping("/proveedorPorNit/{nitProveedor}")
	public String BuscarProveedorPorNit(Model model, @PathVariable(name = "nitProveedor") Long nitProveedor)
	{		
		
		if(ValidacionPorNit(model, nitProveedor))
		{	
			ProveedorResponse proveedorEditar = proveedores.buscarProveedor(nitProveedor);
			if(proveedorEditar == null) 
			{
				model.addAttribute("mensaje", "Proveedor Inexistente");
			}
			else {
				
				model.addAttribute("proveedorEditar", proveedorEditar);
				model.addAttribute("proveedores", proveedores.getProveedores());
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
	
	private boolean ValidacionCrear(Model model, ProveedoresDto proveedor) 
	{	
		while (proveedor.getNitProveedor() ==null && proveedor.getNombreProveedor() ==null && 
		proveedor.getCiudadProveedor() ==null && proveedor.getDireccionProveedor() ==null &&
		proveedor.getTelefonoProveedor() ==null && proveedor.getTipoProducto() ==null )	{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
				
		return true;
	}
	
	private boolean ValidacionActulizar(Model model, ProveedorResponse proveedor) {
		
		while (proveedor.getNitProveedor() == null && proveedor.getNombreProveedor() == null && 
		proveedor.getCiudadProveedor() == null && proveedor.getDireccionProveedor() == null &&
		proveedor.getTelefonoProveedor() == null && proveedor.getTipoProducto() == null )	{
			model.addAttribute("mensaje", "Faltan datos del Proveedor");
			return false;
		}
		return true;
		
	}
	
	

}
