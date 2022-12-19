package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.repositories.ICliente;

@Service
public class ClienteImp implements IClienteService {
	
	@Autowired
	public
	ICliente iCliente;
	
	@Override
	public void crearCliente(ClienteDto clienteDto) {
		iCliente.save(buildCliente(clienteDto));
		
	}
	
	private Clientes buildCliente(ClienteDto clienteDto) {
		Clientes cliente = new Clientes();
		// Long id = clienteDto.getID();
		Long documentoCliente = clienteDto.getDocumentoCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String apellidoCliente = clienteDto.getApellidoCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String barrioCliente = clienteDto.getBarrioCliente();
		String zonaCliente = clienteDto.getZonaCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		String telefonoadicionalCliente = clienteDto.getTelefonoadicional();
		String CorreoCliente = clienteDto.getCorreoCliente();

		
		// if (id != null) {
		// 	cliente.setIDCliente(id);
		// }
		if(documentoCliente != null) {
			cliente.setDocumentoCliente(documentoCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(apellidoCliente != null) {
			cliente.setApellidoCliente(apellidoCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(barrioCliente != null) {
			cliente.setBarrioCliente(barrioCliente);;
		}
		if(zonaCliente != null) {
			cliente.setZonaCliente(zonaCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
		if(telefonoadicionalCliente != null) {
			cliente.setTelefonoadicional(telefonoadicionalCliente);
		}
		if(CorreoCliente != null) {
			cliente.setCorreoCliente(CorreoCliente);
		}
		
		
		return cliente;
	}
	
	private void updateCliente(ClienteDto clienteDto, Clientes cliente) {
		
		// Clientes cliente = new Clientes();
		Long id = clienteDto.getID();
		Long documentoCliente = clienteDto.getDocumentoCliente();
		String nombreCliente = clienteDto.getNombreCliente();
		String apellidoCliente = clienteDto.getApellidoCliente();
		String direccionCliente = clienteDto.getDireccionCliente();
		String barrioCliente = clienteDto.getBarrioCliente();
		String zonaCliente = clienteDto.getZonaCliente();
		String telefonoCliente = clienteDto.getTelefonoCliente();
		String telefonoadicionalCliente = clienteDto.getTelefonoadicional();
		String CorreoCliente = clienteDto.getCorreoCliente();

		if (id != null) {
			cliente.setIDCliente(id);
		}
		if(documentoCliente != null) {
			cliente.setDocumentoCliente(documentoCliente);
		}
		if(nombreCliente != null) {
			cliente.setNombreCliente(nombreCliente);
		}
		if(apellidoCliente != null) {
			cliente.setApellidoCliente(apellidoCliente);
		}
		if(direccionCliente != null) {
			cliente.setDireccionCliente(direccionCliente);
		}
		if(barrioCliente != null) {
			cliente.setBarrioCliente(barrioCliente);;
		}
		if(zonaCliente != null) {
			cliente.setZonaCliente(zonaCliente);
		}
		if(telefonoCliente != null) {
			cliente.setTelefonoCliente(telefonoCliente);
		}
		if(telefonoadicionalCliente != null) {
			cliente.setTelefonoadicional(telefonoadicionalCliente);
		}
		if(CorreoCliente != null) {
			cliente.setCorreoCliente(CorreoCliente);
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
		} 
		catch (Exception e) {
			return null;
		}
	}

	// @Override
	// public ClienteDto buscarClientePorZona(String zonaCliente) {
	// 	Clientes cliente = null;
	// 	try {
	// 		cliente = iCliente.buscarClientePorZona(zonaCliente);
	// 		ClienteDto  clienteDto = mapClienteDto(cliente);
	// 		return clienteDto;
	// 	} catch (Exception e) {
	// 		return null;
	// 	}
		
	// }

	private ClienteDto mapClienteDto(Clientes cliente) {
		return new ClienteDto(
				cliente.getIDCliente(),
				cliente.getDocumentoCliente(),
				cliente.getNombreCliente(),
				cliente.getApellidoCliente(),
				cliente.getDireccionCliente(),
				cliente.getBarrioCliente(),
				cliente.getZonaCliente(),
				cliente.getTelefonoCliente(),
				cliente.getTelefonoadicional(),
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

	@Override
	public List<Clientes> listazonaCliente(String zonaCliente) {
		// TODO Auto-generated method stub
		List<Clientes> lista = new ArrayList<Clientes>();
		lista.add(iCliente.buscarClientePorZona(zonaCliente));
		return (lista) ;
	}
	

}
