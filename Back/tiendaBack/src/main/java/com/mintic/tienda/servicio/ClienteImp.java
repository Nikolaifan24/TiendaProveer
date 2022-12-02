package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.repositories.ICliente;

@Service
public class ClienteImp implements IClienteService {
	
	@Autowired
	ICliente iCliente;
	
	@Override
	public void crearCliente(ClienteDto clienteDto) {
		iCliente.save(buildCliente(clienteDto));
		
	}
	
	private Clientes buildCliente(ClienteDto clienteDto) {
		Clientes cliente = new Clientes();
		Long id = clienteDto.getId();
		Long cedulaCliente = clienteDto.getCedulaCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String emailCliente = clienteDto.getEmailCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		
		if (id != null) {
			cliente.setId(id);
		}
		
		if(cedulaCliente != null) {
			cliente.setCedulaCliente(cedulaCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(emailCliente != null) {
			cliente.setEmailCliente(emailCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
			
		return cliente;
	}
	
	private void updateCliente(ClienteDto clienteDto, Clientes cliente) {
		
		Long id = clienteDto.getId();
		Long cedulaCliente = clienteDto.getCedulaCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String emailCliente = clienteDto.getEmailCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		
		if(id != null) {
			cliente.setId(id);
		}
		if(cedulaCliente != null) {
			cliente.setCedulaCliente(cedulaCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(emailCliente != null) {
			cliente.setEmailCliente(emailCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
			
		iCliente.save(cliente);
	}

	@Override
	public ClienteDto buscarClientePorCedula(Long cedulaCliente) {
		Clientes cliente = null;
		try {
			cliente = iCliente.buscarClientePorCedula(cedulaCliente);
			ClienteDto  clienteDto = mapClienteDto(cliente);
			return clienteDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	private ClienteDto mapClienteDto(Clientes cliente) {
		return new ClienteDto(
				cliente.getId(),
				cliente.getCedulaCliente(),
				cliente.getDireccionCliente(),
				cliente.getEmailCliente(),
				cliente.getNombreCliente(),
				cliente.getTelefonoCliente()
		);		
	}

	@Override
	public void eliminarCliente(Long cedulaCliente) {
		
		Clientes cliente = iCliente.buscarClientePorCedula(cedulaCliente);
		iCliente.delete(cliente);
		
	}

	@Override
	public void actualizarCliente(Long cedulaCliente, ClienteDto clienteDto) {
		Clientes cliente = iCliente.buscarClientePorCedula(cedulaCliente);
		updateCliente(clienteDto, cliente);

	}

	@Override
	public List<Clientes> listaCliente() {
		return (List<Clientes>) iCliente.findAll();
	}
	
	

}
