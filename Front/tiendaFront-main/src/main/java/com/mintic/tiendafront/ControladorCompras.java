package com.mintic.tiendafront;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mintic.tiendafront.client.ICompra;
// import com.mintic.tiendafront.client.Iendedor;
import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;
import com.mintic.tiendafront.dto.DetalleCompraDto;
import com.mintic.tiendafront.dto.DetalleCompraResponse;

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

	@PostMapping("/compras")
	public String crearCompras(Model model, ComprasDto Compras) 
	{
		if(Compras.getIDCompras().longValue() == 0) {
			ValidacionCrearCompras(model, Compras);
			
			if(ValidacionCrearCompras(model, Compras) == true) 
			{
				iCompras.nuevaCompras(Compras);
				model.addAttribute("compras", iCompras.ListarCompras());
				model.addAttribute("mensaje", "Compra Creada con exito");			
			}		
		}else {
			iCompras.ActualizarCompra(Compras, Compras.getCodigoCompra());		
			model.addAttribute("compras", iCompras.ListarCompras());
			model.addAttribute("mensaje", "Datos del Compras Actualizados");		
		}	
		
		

		return "compras";
	}

	@GetMapping("/Compras/{codigoCompra}")
	public String actualizarCompras(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra)
	{
		ComprasResponse ComprasEditar = iCompras.buscarCompraCodigo(CodigoCompra);
		ValidacionActualizarCompras(model, ComprasEditar);
		if(ValidacionActualizarCompras(model, ComprasEditar) == true)
		{			
			model.addAttribute("ComprasEditar", ComprasEditar);
			model.addAttribute("Comprass", iCompras.ListarCompras());
			model.addAttribute("mensaje", "");
		}

		return "compras";
		
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
	
	@GetMapping("/BuscarComprasPorCodigo/{codigoCompra}")
	public String BuscarComprasPorCodigo(Model model, @PathVariable(name = "codigoCompra") Long CodigoCompra)
	{		
		
		if(ValidacionPorCodigo(model, CodigoCompra))
		{	
			ComprasResponse ComprasEditar = iCompras.buscarCompraCodigo(CodigoCompra);
			
			if(ComprasEditar == null) {
				model.addAttribute("mensaje", "Compra Inexistente");
			}
			else {
				model.addAttribute("compraEditar", ComprasEditar);
				model.addAttribute("compras", iCompras.ListarCompras());

			}	
		}

		return "compras";
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
			model.addAttribute("mensaje", "Faltan id");
			return false;
		}
		if(Compras.getTotalCompra() == null) 
		{
			model.addAttribute("mensaje", "Faltan total");
			return false;
		}
		if(Compras.getIvaCompra() == null) 
		{
			model.addAttribute("mensaje", "Faltan iva");
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

	@PostMapping("/detallecompra/{CodigoCompra}")
	public String crearDetalleCompras(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra, DetalleCompraDto Detalle) 
	{
		if(Detalle.getID().longValue() == 0) {
			ValidacionCrearDetalledeunaCompra(model, Detalle);
			
			if(ValidacionCrearDetalledeunaCompra(model, Detalle) == true) 
			{	

				iCompras.nuevoCompraDetalle(CodigoCompra, Detalle);
				model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));
				model.addAttribute("TotalCompra", iCompras.totalCompra(CodigoCompra));
				model.addAttribute("mensaje", "Compra Creada con exito");			
			}		
		}else {
			iCompras.ActualizarDetalledeCompra(CodigoCompra, Detalle.getNombreProducto(), Detalle);		
			model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));
			model.addAttribute("mensaje", "Datos del Detalle Actualizados");		
		}	
		
		

		return "detallecompra";
	}

	@GetMapping("/detallecompra/{CodigoCompra}/{nombreProducto}")
	public String actualizarDetalleCompras(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra, @PathVariable(name = "nombreProducto") String nombreProducto)
	{
		DetalleCompraResponse DetalleComprasEditar = iCompras.DetalladeunaCompra(CodigoCompra, nombreProducto);
		ValidacionActualizarDetalle(model, DetalleComprasEditar);
		if(ValidacionActualizarDetalle(model, DetalleComprasEditar) == true)
		{			
			model.addAttribute("detallecompraEditar", DetalleComprasEditar);
			model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));
			model.addAttribute("mensaje", "Detalle Actulizado");
		}

		return "detallecompra";
		
		// if (CodigoCompra != 0) {
		// 	ComprasResponse ComprasEditar = iCompras.buscarCompra(CodigoCompra);
		// 	model.addAttribute("comprasEditar", ComprasEditar);
		// }
		
		// return "Compras";
	}

	private boolean ValidacionPorCodigoyNombre(Model model, Long CodigoCompra, String nombreProducto) 
	{		
		if(CodigoCompra == 0 && nombreProducto.isBlank()) 
		{
			model.addAttribute("mensaje", "Ingrese datos correctos para la busqueda");
			return false;
		}		
		
		return true;
	}

	@GetMapping("/BuscarDetalle/{CodigoCompra}/{nombreProducto}")
	public String BuscarComprasDetallePorCodigoyNombre(Model model, @PathVariable(name = "CodigoCompra") Long CodigoCompra,  @PathVariable(name = "nombreProducto") String nombreProducto)
	{		
		
		if(ValidacionPorCodigoyNombre(model, CodigoCompra, nombreProducto))
		{	
			DetalleCompraResponse DetalleEditar = iCompras.DetalladeunaCompra(CodigoCompra, nombreProducto);
			
			if(DetalleEditar == null) {
				model.addAttribute("mensaje", "Compra Inexistente");
			}
			else {
				model.addAttribute("detallecompraEditar", DetalleEditar);
				// model.addAttribute("CodigoCompra", CodigoCompra);
				model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));

			}	
		}

		return "detallecompra";
	}

	// @PatchMapping("/detallecompra/{CodigoCompra}")
	// public String actualizarDetalle(Model model, ComprasDto Compras,  @PathVariable(name = "CodigoCompra") Long CodigoCompra){
	// 	iCompras.CargarDatosdeunaCompra(Compras, CodigoCompra);
	// 	model.addAttribute("mensaje", "Productos cargados");

	// 	return "compras"; 
	// }
	
	private boolean ValidacionCrearDetalledeunaCompra(Model model, DetalleCompraDto detalle) 
	{		
		
		if(detalle.getNombreProducto().isBlank())
		{
			model.addAttribute("mensaje", "Faltan datos del detalle");
			return false;
		}
		if(detalle.getCantidadProducto() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del detalle");
			return false;
		}
		if(detalle.getValorUnitario().longValue() == 0) 
		{
			model.addAttribute("mensaje", "Faltan datos del detalle");
			return false;
		}		
		
		return true;
	}

	private boolean ValidacionActualizarDetalle(Model model, DetalleCompraResponse detallecompraEditar)
	{
		
		if(detallecompraEditar.getProductos().getNombreProducto().isBlank()) 
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(detallecompraEditar.getCantidadProducto() == 0)
		{
			model.addAttribute("mensaje", "Faltan datos del Compras");
			return false;
		}
		if(detallecompraEditar.getValorUnitario().longValue() == 0) 
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
		model.addAttribute("CodigoCompra", CodigoCompra);
		model.addAttribute("TotalCompra", iCompras.totalCompra(CodigoCompra));
		model.addAttribute("TotalIVa", iCompras.totalCompra(CodigoCompra)*.16);
		model.addAttribute("TotalsinIVa", iCompras.totalCompra(CodigoCompra)-iCompras.totalCompra(CodigoCompra)*.16);
		


		if(model.getAttribute("detallecompra") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "detallecompra";
	}

	@GetMapping("/eliminarDetalleCompra/{codigoCompra}/{nombreProducto}")
	public String eliminarUsuario(Model model,@PathVariable(name = "codigoCompra") Long CodigoCompra, @PathVariable(name = "nombreProducto") String nombreProducto) {

		iCompras.borrarDetalleCompras(CodigoCompra, nombreProducto);
		model.addAttribute("detallecompra", iCompras.ListarDetalleCompras(CodigoCompra));
			
		return "detallecompra";
	}
    
}
