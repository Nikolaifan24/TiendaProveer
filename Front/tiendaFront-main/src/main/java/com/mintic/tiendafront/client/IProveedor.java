package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorResponse;


public interface IProveedor {
	
	public List<ProveedorResponse> getProveedores();

	public ProveedorResponse nuevoProveedor(Proveedor proveedorDto);
	
	public ProveedorResponse ActualizarProveedor(Proveedor proveedorDto, Long nit);

	public ProveedorResponse buscarProveedor(Long nit);

	public int borrarProveedor(Long nit);
	
	
	

}
