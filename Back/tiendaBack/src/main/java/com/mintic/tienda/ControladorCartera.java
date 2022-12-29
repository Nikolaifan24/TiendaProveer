package com.mintic.tienda;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.CarteraDto;
import com.mintic.tienda.entities.Cartera;
import com.mintic.tienda.servicio.ICarteraService;

@RestController
public class ControladorCartera {
    
    @Autowired
	ICarteraService iCartera;
	
	CarteraDto CarteraDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Cartera/fehca/pago/{FehcaPago}")
	public CarteraDto buscarCarteraByFechaPago(@PathVariable Date FehcaPago) {
		return iCartera.buscarCarteraPorFechaPago(FehcaPago);
	}
	
	
	@PostMapping("/crearCartera")
	public void crearCartera(@RequestBody CarteraDto CarteraDto) {
		iCartera.crearCartera(CarteraDto);
	}
	
	@DeleteMapping("/eliminarCartera/{FehcaPago}")
	public void eliminarCartera(@PathVariable Date FehcaPago) {
		iCartera.eliminarCartera(FehcaPago);
	}
	
	@PatchMapping("/actualizarCartera/{FehcaPago}")
	public void actualizaralCartera(@PathVariable Date FehcaPago, @RequestBody CarteraDto CarteraDto) {
		iCartera.actualizarCartera(FehcaPago, CarteraDto);
	}
	
	@GetMapping("/carteras")
	public List<Cartera> listaCartera() {
		return iCartera.listaCartera();
	}
	
	@GetMapping("/Cartera/cliente/id/{IDCliente}")
	public List<Cartera> listaCarteraByCliente(@PathVariable Long IDCliente){
		return iCartera.listaCarteraCliente(IDCliente);
	}

    @GetMapping("/Cartera/fechaventa/{FechaVenta}")
	public List<Cartera> listaCarteraByFechaVenta(@PathVariable Date FechaVenta){
		return iCartera.listarCarteraFechaVenta(FechaVenta);
	}

	@GetMapping("/Cartera/buscarCartera/ventaypago/{FechaVenta}/{FechaPago}")
	public List<Cartera> listarCarteraByFechaVentaYPago(@PathVariable Date FechaVenta, @PathVariable Date FechaPago ){
		return iCartera.listarCarteraPorFechaPagoyVenta(FechaVenta, FechaPago);
	}



}
