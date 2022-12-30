package com.mintic.tienda;


// import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import com.mintic.tienda.dto.CalculoDto;
// import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.VentasDto;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
// import com.mintic.tienda.repositories.IVenta;

// import com.mintic.tienda.servicio.IDetalleVentasService;
// import com.mintic.tienda.servicio.IProductoService;
import com.mintic.tienda.servicio.IVentasService;


@RestController
public class ControladorVentas {
	
	@Autowired
	IVentasService iVentas;
	
	
	VentasDto ventasDto;
	// CalculoDto calculoDto;
	// ProductosDto productosDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/venta/{fechaVenta}")
	public VentasDto buscarVentaPorfecha(@PathVariable String fechaVenta) {
		return iVentas.buscarVentaPorfecha(fechaVenta);
	}

	@GetMapping("/ventas")
	public List<Ventas> listardeVentas() {
		return iVentas.ListarVentas();
	}
	
	@PostMapping("/venta")
	public void crearVenta(@RequestBody VentasDto ventasDto) {
		iVentas.crearVenta(ventasDto);
	}
	
	

	

}
