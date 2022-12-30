package com.mintic.tienda;

// import java.util.String;
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

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.servicio.IPagosService;
// import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPagos {
    @Autowired
	IPagosService iPagos;
	
	PagosDto PagosDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Pagos/fehca/pago/{FehcaPago}")
	public PagosDto buscarPagosByFechaPago(@PathVariable String FehcaPago) {
		return iPagos.buscarPagosPorFechaPago(FehcaPago);
	}
	
	
	@PostMapping("/crearPagos")
	public void crearPagos(@RequestBody PagosDto PagosDto) {
		iPagos.crearPagos(PagosDto);
	}
	
	@DeleteMapping("/eliminarPagos/{FehcaPago}")
	public void eliminarPagos(@PathVariable String FehcaPago) {
		iPagos.eliminarPagos(FehcaPago);
	}
	
	@PatchMapping("/actualizarPagos/{FehcaPago}")
	public void actualizaralPagos(@PathVariable String FehcaPago, @RequestBody PagosDto PagosDto) {
		iPagos.actualizarPagos(FehcaPago, PagosDto);
	}
	
	@GetMapping("/pagos")
	public List<Pagos> listaPagos() {
		return iPagos.listaPagos();
	}
	
	@GetMapping("/Pagos/cliente/id/{IDCliente}")
	public List<Pagos> listaPagosByCliente(@PathVariable Long IDCliente){
		return iPagos.listaPagosCliente(IDCliente);
	}

    @GetMapping("/Pagos/mediopago/{MedioPagp}")
	public List<Pagos> listaPagosByFechaVenta(@PathVariable String MedioPago){
		return iPagos.listarPagosMedioPago(MedioPago);
	}

	@GetMapping("/Pagos/buscarPagos/ventaypago/{FechaVenta}/{FechaPago}")
	public List<Pagos> listarPagosByFechaVentaYPago(@PathVariable String FechaVenta, @PathVariable String FechaPago ){
		return iPagos.listarPagosPorFechaPagoyVenta(FechaVenta, FechaPago);
	}




}
