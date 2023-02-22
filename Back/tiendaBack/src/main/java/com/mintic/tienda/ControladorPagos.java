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
	
	@CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/Pagos/fehca/pago/{CodigoVenta}-{FehcaPago}")
	public PagosDto buscarPagosByFechaPago(@PathVariable Long CodigoVenta, @PathVariable String FehcaPago) {
		return iPagos.buscarPagosPorFechaPago(CodigoVenta, FehcaPago);
	}
	
	
	@PostMapping("/crearPagos")
	public void crearPagos(@RequestBody PagosDto PagosDto) {
		iPagos.crearPagos(PagosDto);
	}
	
	@DeleteMapping("/eliminarPagos/{CodigoVenta}-{FehcaPago}")
	public void eliminarPagos(@PathVariable Long CodigoVenta, @PathVariable String FehcaPago) {
		iPagos.eliminarPagos(CodigoVenta, FehcaPago);
	}
	
	@PatchMapping("/actualizarPagos/{CodigoVenta}/{FehcaPago}")
	public void actualizaralPagos(@PathVariable Long CodigoVenta, @PathVariable String FehcaPago, @RequestBody PagosDto PagosDto) {
		iPagos.actualizarPagos(CodigoVenta, FehcaPago, PagosDto);
	}
	
	@GetMapping("/pagos")
	public List<Pagos> listaPagos() {
		return iPagos.listaPagos();
	}
	
	@GetMapping("/Pagos/cliente/nombre/{nombreCliente}-{apellidoCliente}")
	public List<Pagos> listaPagosByCliente(@PathVariable String nombreCliente, @PathVariable String apellidoCliente){
		return iPagos.listaPagosCliente(nombreCliente, apellidoCliente);
	}

	@GetMapping("/Pagos/venta/fechaventa/{FechaVenta}")
	public List<Pagos> listaPagosByVenta(@PathVariable String FechaVenta){
		return iPagos.listaPagosFechaVenta(FechaVenta);
	}


    @GetMapping("/Pagos/mediopago/{MedioPagp}")
	public List<Pagos> listaPagosByMedioPago(@PathVariable String MedioPago){
		return iPagos.listarPagosMedioPago(MedioPago);
	}

	@GetMapping("/Pagos/buscarPagos/ventaypago/{FechaVenta}/{FechaPago}")
	public List<Pagos> listarPagosByFechaVentaYPago(@PathVariable String FechaVenta, @PathVariable String FechaPago ){
		return iPagos.listarPagosPorFechaPagoyVenta(FechaVenta, FechaPago);
	}




}
