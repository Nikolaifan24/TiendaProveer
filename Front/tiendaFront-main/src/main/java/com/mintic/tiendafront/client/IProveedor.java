package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ProveedoresDto;
import com.mintic.tiendafront.dto.ProveedorResponse;


public interface IProveedor {
	
	public List<ProveedorResponse> getProveedores();

	public ProveedorResponse nuevoProveedor(ProveedoresDto proveedorDto);
	
	public ProveedorResponse ActualizarProveedor(ProveedoresDto proveedorDto, Long nit);

	public ProveedorResponse buscarProveedor(Long nit);

	public int borrarProveedor(Long nit);
	
	
	

}
