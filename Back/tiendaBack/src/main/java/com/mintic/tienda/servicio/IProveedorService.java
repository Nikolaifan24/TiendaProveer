package com.mintic.tienda.servicio;


import java.util.List;

import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.entities.Proveedores;

public interface IProveedorService {
	
	void crearProveedor(ProveedoresDto proveedorDto);

	ProveedoresDto buscarProveedorPorNit(Long nitProveedor);

	ProveedoresDto buscarProveedorPorTipoproducto(String TipoProducto);

	void eliminarProveedor(Long nitProveedor);

	void actualizarProveedor(Long nitProveedor, ProveedoresDto ProveedorDto);
	
	List<Proveedores> listaProvedores();
}
