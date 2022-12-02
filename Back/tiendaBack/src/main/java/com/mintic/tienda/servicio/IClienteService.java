package com.mintic.tienda.servicio;

import java.util.List;


import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Clientes;

public interface IClienteService {

	void crearCliente(ClienteDto clienteDto);

	ClienteDto buscarClientePorCedula(Long cedulaCliente);

	void eliminarCliente(Long cedulaCliente);

	void actualizarCliente(Long cedulaCliente, ClienteDto clienteDto);

	List<Clientes> listaCliente();
	
}
