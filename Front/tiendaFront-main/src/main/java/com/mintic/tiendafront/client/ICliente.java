package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;


public interface ICliente {
	
	//public ClienteDto BuscarClientePorId(int Id);

	//public List<ClienteDto> ListarClientes();

	//public ClienteDto NuevoCliente(ClienteDto clienteDto);

	//public ClienteDto ActualizarCliente(int id, ClienteDto clienteDto);

	// public int BorrarCliente(int id);
	
	public List<ClienteResponse> getClientes();

	public ClienteResponse nuevocliente(ClienteDto clienteDto);

	public ClienteResponse buscarCliente(Long cedulacliente);
	

	public int borrarCliente(Long cedulaCliente);

	public ClienteResponse ActualizarCliente(ClienteDto cliente, Long id);

}
