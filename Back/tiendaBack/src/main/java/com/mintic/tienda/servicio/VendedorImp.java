package com.mintic.tienda.servicio;

import java.util.ArrayList;
// import java.util.HashMap;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
import com.mintic.tienda.dto.VendedorDto;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.repositories.IVendedor;

public class VendedorImp  implements IVendedorService{
    @Autowired
	IVendedor iVendedor;
	
	@Override
	public List<Vendedor> listarVendedores() {
		return (List<Vendedor>) iVendedor.findAll();
	}



	@Override
	public void crearVendedor(VendedorDto VendedorDto) {
		iVendedor.save(buildVendedor(VendedorDto));
		
	}

	private Vendedor buildVendedor(VendedorDto VendedorDto) {
		Vendedor myVendedor = new Vendedor();
		
		// Long id = VendedorDto.getID();
        Usuario usuario = VendedorDto.getUsuario();
        Long documentoVendedor = VendedorDto.getDocumentoVendedor();
        String nombreVendedor = VendedorDto.getNombreVendedor();
        String direcionVendedor = VendedorDto.getDirrecionVendedor();
        Double telefonoVendedor = VendedorDto.getTelefonoVendedor();
        Float comisionVendedor = VendedorDto.getComisionVendedor();
        String FechaIngreso = VendedorDto.getFechaIngreso();
        Double Salario = VendedorDto.getSalario();
		// myVendedor.setID(id);
		
		if(usuario != null) {
			myVendedor.setUsuario(usuario);;
		}
        if(documentoVendedor != null) {
			myVendedor.setDocumentoVendedor(documentoVendedor);;
		}
        if(nombreVendedor != null) {
			myVendedor.setNombreVendedor(nombreVendedor);
		}
        if(direcionVendedor != null) {
			myVendedor.setDirrecionVendedor(direcionVendedor);;
		}
		if(telefonoVendedor != null) {
			myVendedor.setTelefonoVendedor(telefonoVendedor);
		}
		if(comisionVendedor != null) {
			myVendedor.setComisionVendedor(comisionVendedor);
		}
        if(FechaIngreso != null) {
			myVendedor.setFechaIngreso(FechaIngreso);
		}
        if(Salario != null) {
			myVendedor.setSalario(Salario);
		}

		return myVendedor;
		
	}
	
	private void updateVendedor(VendedorDto VendedorDto, Vendedor myVendedor) {
		
        Usuario usuario = VendedorDto.getUsuario();
        Long documentoVendedor = VendedorDto.getDocumentoVendedor();
        String nombreVendedor = VendedorDto.getNombreVendedor();
        String direcionVendedor = VendedorDto.getDirrecionVendedor();
        Double telefonoVendedor = VendedorDto.getTelefonoVendedor();
        Float comisionVendedor = VendedorDto.getComisionVendedor();
        String FechaIngreso = VendedorDto.getFechaIngreso();
        Double Salario = VendedorDto.getSalario();
		// myVendedor.setID(id);
		
		if(usuario != null) {
			myVendedor.setUsuario(usuario);;
		}
        if(documentoVendedor != null) {
			myVendedor.setDocumentoVendedor(documentoVendedor);;
		}
        if(nombreVendedor != null) {
			myVendedor.setNombreVendedor(nombreVendedor);
		}
        if(direcionVendedor != null) {
			myVendedor.setDirrecionVendedor(direcionVendedor);;
		}
		if(telefonoVendedor != null) {
			myVendedor.setTelefonoVendedor(telefonoVendedor);
		}
		if(comisionVendedor != null) {
			myVendedor.setComisionVendedor(comisionVendedor);
		}
        if(FechaIngreso != null) {
			myVendedor.setFechaIngreso(FechaIngreso);
		}
        if(Salario != null) {
			myVendedor.setSalario(Salario);
		}
		
		iVendedor.save(myVendedor);
	}
	

	@Override
	public void eliminarVendedor(String nombreVendedor) {
		Vendedor Vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
		iVendedor.delete(Vendedor);
		
	}

	@Override
	public void actualizarVendedor(String nombreVendedor, VendedorDto VendedorDto) {
		
		Vendedor Vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
		updateVendedor(VendedorDto, Vendedor);
		
	}

	@Override
	public VendedorDto buscarVendedorPorDocumento(Long documentoVendedor) {
		Vendedor Vendedor = null;
		try {
			Vendedor = iVendedor.buscarVendedorPorDocumento(documentoVendedor);
			VendedorDto  VendedorDto = mapVendedorDto(Vendedor);
			return VendedorDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	private VendedorDto mapVendedorDto(Vendedor Vendedor) {
		return new VendedorDto(
				Vendedor.getIDVendedor(),
				Vendedor.getUsuario(),
				Vendedor.getDocumentoVendedor(),
				Vendedor.getNombreVendedor(),
				Vendedor.getDirrecionVendedor(),
				Vendedor.getTelefonoVendedor(),
				Vendedor.getComisionVendedor(),
				Vendedor.getFechaIngreso(),
				Vendedor.getSalario()


		);		
	}

	public List<Vendedor> encontrarVendedorPorNombre(String nombreVendedor){

		List<Vendedor> lista = new ArrayList<Vendedor>();
		lista.add(iVendedor.buscarVendedorPorNombre(nombreVendedor));
		return lista;

	}

  
	
}
