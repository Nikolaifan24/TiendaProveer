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
		Long id = clienteDto.getID();
		Long documentoCliente = clienteDto.getCedulaCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String CorreoCliente = clienteDto.getCorreoCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		String telefonoadicionalCliente = clienteDto.getTelefonoadicional();
		String zonaCliente = clienteDto.getZonaCliente();
		String barrioCliente = clienteDto.getBarrioCliente();

		
		if (id != null) {
			cliente.setID(id);
		}
		
		if(documentoCliente != null) {
			cliente.setCedulaCliente(documentoCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(CorreoCliente != null) {
			cliente.setCorreoCliente(CorreoCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
		if(telefonoadicionalCliente != null) {
			cliente.setTelefonoadicional(telefonoadicionalCliente);
		}
		if(barrioCliente != null) {
			cliente.setBarrioCliente(barrioCliente);;
		}
		if(zonaCliente != null) {
			cliente.setZonaCliente(zonaCliente);
		}

		return cliente;
	}
	
	private void updateCliente(ClienteDto clienteDto, Clientes cliente) {
		
		// Clientes cliente = new Clientes();
		Long id = clienteDto.getID();
		Long documentoCliente = clienteDto.getCedulaCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String CorreoCliente = clienteDto.getCorreoCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		String telefonoadicionalCliente = clienteDto.getTelefonoadicional();
		String zonaCliente = clienteDto.getZonaCliente();
		String barrioCliente = clienteDto.getBarrioCliente();

		
		if (id != null) {
			cliente.setID(id);
		}
		
		if(documentoCliente != null) {
			cliente.setCedulaCliente(documentoCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(CorreoCliente != null) {
			cliente.setCorreoCliente(CorreoCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
		if(telefonoadicionalCliente != null) {
			cliente.setTelefonoadicional(telefonoadicionalCliente);
		}
		if(barrioCliente != null) {
			cliente.setBarrioCliente(barrioCliente);;
		}
		if(zonaCliente != null) {
			cliente.setZonaCliente(zonaCliente);
		}
			
		iCliente.save(cliente);
	}

	@Override
	public ClienteDto buscarClientePorCedula(Long documentoCliente) {
		Clientes cliente = null;
		try {
			cliente = iCliente.buscarClientePorCedula(documentoCliente);
			ClienteDto  clienteDto = mapClienteDto(cliente);
			return clienteDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	private ClienteDto mapClienteDto(Clientes cliente) {
		return new ClienteDto(
				cliente.getID(),
				cliente.getCedulaCliente(),
				cliente.getDireccionCliente(),
				cliente.getCorreoCliente(),
				cliente.getNombreCliente(),
				cliente.getTelefonoCliente(),
				cliente.getTelefonoadicional(),
				cliente.getZonaCliente(),
				cliente.getBarrioCliente(),
				cliente.getCorreoCliente()
		);		
	}

	@Override
	public void eliminarCliente(Long documentoCliente) {
		
		Clientes cliente = iCliente.buscarClientePorCedula(documentoCliente);
		iCliente.delete(cliente);
		
	}

	@Override
	public void actualizarCliente(Long documentoCliente, ClienteDto clienteDto) {
		Clientes cliente = iCliente.buscarClientePorCedula(documentoCliente);
		updateCliente(clienteDto, cliente);

	}

	@Override
	public List<Clientes> listaCliente() {
		return (List<Clientes>) iCliente.findAll();
	}
	
	

}
