package com.mintic.tienda;
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

import com.mintic.tienda.dto.NominaDto;
import com.mintic.tienda.entities.Nomina;
import com.mintic.tienda.servicio.INominaService;
// import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorNomina {
    @Autowired
	INominaService iNomina;
	
    @CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/Nomina/fehca/pago/{FechaInicio}-{FechaFinal}")
	public NominaDto buscarNominaByFechaPago(@PathVariable String nombreVendedor, @PathVariable String FehcaInicio, @PathVariable String FehcaFinal) {
		return iNomina.buscarNomina(nombreVendedor, FehcaInicio, FehcaFinal);
	}
	
	
	@PostMapping("/crearNomina")
	public void crearNomina(@RequestBody NominaDto NominaDto) {
		iNomina.crearNomina(NominaDto);
	}
	
	@DeleteMapping("/eliminarNomina/{FechaInicio}-{FechaFinal}")
	public void eliminarNomina(@PathVariable String nombreVendedor, @PathVariable String FechaInicio, @PathVariable String FechaFinal) {
		iNomina.eliminarNomina(nombreVendedor, FechaInicio, FechaFinal);
	}
	
	@PatchMapping("/actualizarNomina/{FechaInicio}-{FechaFinal}")
	public void actualizaralNomina(@PathVariable String nombreVendedor, @PathVariable Long FechaInicio, @PathVariable String FechaFinal, @RequestBody NominaDto NominaDto) {
		iNomina.actualizarNomina(nombreVendedor, nombreVendedor, FechaFinal, NominaDto);
	}
	
	@GetMapping("/Nomina")
	public List<Nomina> listaNomina() {
		return iNomina.listarNomina();
	}
    
}
