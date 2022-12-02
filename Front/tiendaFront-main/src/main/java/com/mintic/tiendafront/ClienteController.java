package com.mintic.tiendafront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mintic.tiendafront.client.ICliente;
import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProveedorResponse;

@Controller
public class ClienteController {
	
	@Autowired
	ICliente icliente;	
	
	@GetMapping("/cliente")
	public String cliente(Model model) 
	{
		model.addAttribute("clientes", icliente.getClientes());
		
		if(model.getAttribute("clientes") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "cliente";
	}

	@PostMapping("/cliente")
	public String crearCliente(Model model, ClienteDto cliente) 
	{
		if(cliente.getId().longValue() == 0) {
			ValidacionCrearCliente(model, cliente);
			
			if(ValidacionCrearCliente(model, cliente) == true) 
			{
				icliente.nuevocliente(cliente);				
				model.addAttribute("clientes", icliente.getClientes());
				model.addAttribute("mensaje", "Cliente Creado");			
			}		
		}else {
			icliente.ActualizarCliente(cliente, cliente.getCedulaCliente().longValue());		
			model.addAttribute("clientes", icliente.getClientes());
			model.addAttribute("mensaje", "Datos del Cliente Actualizados");		
		}	
		
		

		return "cliente";
	}

	@GetMapping("/cliente/{cedulaCliente}")
	public String actualizarCliente(Model model, @PathVariable(name = "cedulaCliente") Long cedulaCliente)
	{
		//ClienteResponse clienteEditar = icliente.buscarCliente(cedulaCliente);
		//ValidacionActualizarCliente(model, clienteEditar);
		//if(ValidacionActualizarCliente(model, clienteEditar) == true)
		//{			
			//model.addAttribute("clienteEditar", clienteEditar);
			//model.addAttribute("clientes", icliente.getClientes());
			//model.addAttribute("mensaje", "");
		//}

		//return "cliente";
		
		if (cedulaCliente > 0) {
			ClienteResponse clienteEditar = icliente.buscarCliente(cedulaCliente);
			model.addAttribute("clienteEditar", clienteEditar);
		}
		
		return "cliente";
	}

	@GetMapping("/eliminarcliente/{cedulaCliente}")
	public String eliminarCliente(Model model, @PathVariable(name = "cedulaCliente") Long cedulaCliente) {

		ValidacionPorCedula(model, cedulaCliente);
		icliente.borrarCliente(cedulaCliente);
		model.addAttribute("clientes", icliente.getClientes());
		model.addAttribute("mensaje", "Datos del Cliente Eliminados");
			
		return "cliente";
	}
	
	@GetMapping("/BuscarClientePorCedula/{cedulaCliente}")
	public String BuscarClientePorCedula(Model model, @PathVariable(name = "cedulaCliente") Long cedulaCliente)
	{		
		
		if(ValidacionPorCedula(model, cedulaCliente))
		{	
			ClienteResponse clienteEditar = icliente.buscarCliente(cedulaCliente);
			
			if(clienteEditar == null) {
				model.addAttribute("mensaje", "Cliente Inexistente");
			}
			else {
				model.addAttribute("clienteEditar", clienteEditar);
			}	
		}

		return "cliente";
	}
	
	private boolean ValidacionPorCedula(Model model, Long cedulaCliente) 
	{		
		if(cedulaCliente == 0) 
		{
			model.addAttribute("mensaje", "Ingrese numero de Cliente para la busqueda");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionCrearCliente(Model model, ClienteDto cliente) 
	{		
		if(cliente.getCedulaCliente().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(cliente.getDireccionCliente().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(cliente.getNombreCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(cliente.getEmailCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(cliente.getTelefonoCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionActualizarCliente(Model model, ClienteResponse clienteEditar)
	{
		
		if(clienteEditar.getcedulaCliente().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(clienteEditar.getdireccionCliente().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(clienteEditar.getnombreCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(clienteEditar.getemailCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}
		if(clienteEditar.gettelefonoCliente().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Cliente");
			return false;
		}		
		
		return true;
		
	}
	
	
	@GetMapping("/reporte")
	public String reportes() {
		return "reporte";
	}
	
	
	@GetMapping("/reporteCliente")
	public String reportesCliente(Model model) {
		model.addAttribute("clientes", icliente.getClientes());
		
		if(model.getAttribute("clientes") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteCliente";
	}
	

	
}
