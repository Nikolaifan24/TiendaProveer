package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.UsuarioDto;
import com.mintic.tiendafront.dto.UsuarioResponse;


public interface ICliente {
	
	public List<ClienteResponse> getClientes();

	public ClienteResponse nuevocliente(ClienteDto clienteDto);

	public ClienteResponse buscarCliente(Long cedulacliente);
	

	public int borrarCliente(Long cedulaCliente);

	public ClienteResponse ActualizarCliente(ClienteDto cliente, Long documentoCliente);

}
