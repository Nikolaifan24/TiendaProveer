package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.DetalleventaDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detalleventa;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.servicio.IDetalleVentasService;

@RestController
public class ControladorDetalleVentas {
	
	@Autowired
	IDetalleVentasService iDetalleVentas;
	
	DetalleventaDto detalleVentaDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/detalleVentas")
	public List<Detalleventa> listarDetalleVentas() {
		return iDetalleVentas.getDetalleVentas();
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/detalleVentas/{idVenta}")
	public DetalleventaDto buscarDetalleVentaPorIdVenta(@PathVariable Long idVenta) {
		return iDetalleVentas.buscarDetalleVentasPorIdVenta(idVenta);
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@PostMapping("/detalleVentas")
	public void creadDetalleVentas(@RequestBody DetalleventaDto DetalleVentaDto) {
		iDetalleVentas.crearDetalleVentas(DetalleVentaDto);
		
	}
	
	

}
