package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.entities.Proveedores;
import com.mintic.tienda.servicio.IProveedorService;

@RestController
public class ControladorProveedores {
	
	@Autowired
	IProveedorService iProveedor;
	
	ProveedoresDto proveedorDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/proveedor/{nitProveedor}")
	public ProveedoresDto buscarProveedorPorNit(@PathVariable Long nitProveedor) {
		return iProveedor.buscarProveedorPorNit(nitProveedor);
	}
	
	@PostMapping("/proveedor")
	public void crearProveedor(@RequestBody ProveedoresDto proveedorDto) {
		iProveedor.crearProveedor(proveedorDto);
	}
	
	@DeleteMapping("/proveedor/{nitProveedor}")
	public void eliminarProveedor(@PathVariable Long nitProveedor) {
		iProveedor.eliminarProveedor(nitProveedor);
	}
	
	@PatchMapping("/proveedor/{nitProveedor}")
	public void actualizarProveedor(@PathVariable Long nitProveedor, @RequestBody ProveedoresDto ProveedorDto) {
		iProveedor.actualizarProveedor(nitProveedor, ProveedorDto);
	}
	
	@GetMapping("/proveedor")
	public List<Proveedores> listaProvedores() {
		return iProveedor.listaProvedores();
	}
}
