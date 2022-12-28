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

import com.mintic.tienda.dto.VendedorDto;
import com.mintic.tienda.entities.Vendedor;
// import com.mintic.tienda.dto.LoginDto;
// import com.mintic.tienda.dto.ProveedoresDto;
// import com.mintic.tienda.dto.VendedorDto;
// import com.mintic.tienda.entities.Vendedors;
// import com.mintic.tienda.entities.Vendedors;
import com.mintic.tienda.servicio.IVendedorService;
// import com.mintic.tienda.servicio.IVendedorService;

@RestController
public class ControladorVendedor {
    @Autowired
	IVendedorService iVendedor;
	
	VendedorDto VendedorDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/Vendedor/{nombreVendedor}")
	public List<Vendedor> MostarVendedorPorNombre(@PathVariable String nombreVendedor) {
		return iVendedor.encontrarVendedorPorNombre(nombreVendedor);
	}
	
	
	@PostMapping("/crearVendedor")
	public void crearVendedor(@RequestBody VendedorDto VendedorDto) {
		iVendedor.crearVendedor(VendedorDto);
	}
	
	@DeleteMapping("/eliminarVendedor/{nombreVendedor}")
	public void eliminarVendedor(@PathVariable String nombreVendedor) {
		iVendedor.eliminarVendedor(nombreVendedor);
	}
	
	@PatchMapping("/actualizarVendedor/{nombreVendedor}")
	public void actualizaralVendedor(@PathVariable String nombreVendedor, @RequestBody VendedorDto VendedorDto) {
		iVendedor.actualizarVendedor(nombreVendedor, VendedorDto);;
	}
	
	@GetMapping("/Vendedoreslistar")
	public List<Vendedor> listaVendedor() {
		return iVendedor.listarVendedores();
	}
	
	
	
}
