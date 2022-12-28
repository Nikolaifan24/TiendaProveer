package com.mintic.tienda.servicio;
import java.util.List;

// import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.VendedorDto;
import com.mintic.tienda.entities.Vendedor;

public interface IVendedorService {
    
	void crearVendedor(VendedorDto VendedorDto);

	VendedorDto buscarVendedorPorDocumento(Long documentoVendedor);

	void eliminarVendedor(String nombreVendedor);

	void actualizarVendedor(String nombreVendedor, VendedorDto VendedorDto);

    List<Vendedor> listarVendedores();
	
	List<Vendedor> encontrarVendedorPorNombre(String nombreVendedor);


    
}
