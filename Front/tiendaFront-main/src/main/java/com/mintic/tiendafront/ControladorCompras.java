package com.mintic.tiendafront;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mintic.tiendafront.client.ICompra;
// import com.mintic.tiendafront.client.Iendedor;
import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;

@Controller
public class ControladorCompras {

    @Autowired
	ICompra iCompras;

    @GetMapping("/compras")
	public String Compras(Model model) 
	{
		model.addAttribute("compras", iCompras.ListarCompras());
		
		if(model.getAttribute("compras") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "compras";
	}

	@PostMapping("/Compras")
	public String crearCompras(Model model, ComprasDto Compras) 
	{
		if(Compras.getIDCompras().longValue() == 0) {
			ValidacionCrearCompras(model, Compras);
			
			if(ValidacionCrearCompras(model, Compras) == true) 
			{
				iCompras.nuevoCompra(Compras);				
				model.addAttribute("compras", iCompras.ListarCompras());
				model.addAttribute("mensaje", "Compra Creada con exito");			
			}		
		}else {
			iCompras.ActualizarCompra(Compras, Compras.getCodigoCompra());		
			model.addAttribute("compras", iCompras.ListarCompras());
			model.addAttribute("mensaje", "Datos del Compras Actualizados");		
		}	
		
		

		return "Compras";
	}

	@GetMapping("/Compras/{CodigoCompra}")
	public String actualizarCompras(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra)
	{
		ComprasResponse ComprasEditar = iCompras.buscarCompra(CodigoCompra);
		ValidacionActualizarCompras(model, ComprasEditar);
		if(ValidacionActualizarCompras(model, ComprasEditar) == true)
		{			
			model.addAttribute("ComprasEditar", ComprasEditar);
			model.addAttribute("Comprass", iCompras.ListarCompras());
			model.addAttribute("mensaje", "");
		}

		return "Compras";
		
		// if (CodigoCompra != 0) {
		// 	ComprasResponse ComprasEditar = iCompras.buscarCompra(CodigoCompra);
		// 	model.addAttribute("comprasEditar", ComprasEditar);
		// }
		
		// return "Compras";
	}

	// @GetMapping("/eliminarCompras/{CodigoCompra}")
	// public String eliminarCompras(Model model, @PathVariable(name = "CodigoCompra") String CodigoCompra) {

	// 	ValidacionPorNombre(model, CodigoCompra);
	// 	iCompras.borrarCompras(CodigoCompra);
	// 	model.addAttribute("Comprass", iCompras.ListarCompras());
	// 	model.addAttribute("mensaje", "Datos del Compras Eliminados");
			
	// 	return "Compras";
	// }
	
	@GetMapping("/BuscarComprasPorCodigo/{CodigoCompra}")
	public String BuscarComprasPorCodigo(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra)
	{		
		
		if(ValidacionPorCodigo(model, CodigoCompra))
		{	
			ComprasResponse ComprasEditar = iCompras.buscarCompra(CodigoCompra);
			
			if(ComprasEditar == null) {
				model.addAttribute("mensaje", "Compra Inexistente");
			}
			else {
				model.addAttribute("comprasEditar", ComprasEditar);
			}	
		}

		return "Compras";
	}
	
	private boolean ValidacionPorCodigo(Model model, Long CodigoCompra) 
	{		
		if(CodigoCompra == 0) 
		{
			model.addAttribute("mensaje", "Ingrese numero de Compras para la busqueda");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionCrearCompras(Model model, ComprasDto Compras) 
	{		
		
		if(Compras.getCodigoCompra().longValue() == 0)
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(Compras.getTotalCompra().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(Compras.getTotalCompra().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}		
		
		return true;
	}
	
	private boolean ValidacionActualizarCompras(Model model, ComprasResponse ComprasEditar)
	{
		
		if(ComprasEditar.getIDCompras().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(ComprasEditar.getCodigoCompra().longValue() == 0)
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(ComprasEditar.getTotalCompra().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(ComprasEditar.getTotalCompra().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		return true;
		
	}
	
	
	// @GetMapping("/reporte")
	// public String reportes() {
	// 	return "reporte";
	// }
	
	
	@GetMapping("/reporteCompras")
	public String reportesCompras(Model model) {
		model.addAttribute("Comprass", iCompras.ListarCompras());
		
		if(model.getAttribute("Comprass") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteCompras";
	}
	

	@GetMapping("/detallecompra/{CodigoCompra}")
	public String reportesDetallesCompras(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra) {
		model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));
		
		if(model.getAttribute("detallecompra") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "detallecompra";
	}


    
}
