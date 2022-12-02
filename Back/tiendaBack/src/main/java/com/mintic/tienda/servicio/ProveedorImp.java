package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mintic.tienda.dto.ProveedoresDto;

import com.mintic.tienda.entities.Proveedores;
import com.mintic.tienda.repositories.IProveedor;

@Service
public class ProveedorImp implements IProveedorService {
	
	@Autowired
	IProveedor iProveedor;

	@Override
	public void crearProveedor(ProveedoresDto proveedorDto) {
		
		iProveedor.save(buildProveedor(proveedorDto));
		
	}
	
	private Proveedores buildProveedor(ProveedoresDto proveedorDto) {
		Proveedores proveedor = new Proveedores();
		Long id = proveedorDto.getId();
		Long nitProveedor = proveedorDto.getNitProveedor();
		String ciudadProveedor = proveedorDto.getCiudadProveedor();
		String direccionProveedor = proveedorDto.getDireccionProveedor();
		String nombreProveedor = proveedorDto.getNombreProveedor();
		String telefonoProveedor = proveedorDto.getTelefonoProveedor();
		
		if(id != null) {
			proveedor.setId(id);
		}
		if(nitProveedor != null) {
			proveedor.setNitProveedor(nitProveedor);
		}
		if(ciudadProveedor != null) {
			proveedor.setCiudadProveedor(ciudadProveedor);
		}
		if(direccionProveedor != null) {
			proveedor.setDireccionProveedor(direccionProveedor);
		}
		if(nombreProveedor != null) {
			proveedor.setNombreProveedor(nombreProveedor);
		}
		if(telefonoProveedor != null) {
			proveedor.setTelefonoProveedor(telefonoProveedor);
		}
		
		System.out.println(proveedor);
		return proveedor;
	}
	
	private void updateProveedor(ProveedoresDto ProveedorDto, Proveedores Proveedor) {
		
		Long nitProveedor = ProveedorDto.getNitProveedor();
		String ciudadProveedor = ProveedorDto.getCiudadProveedor();
		String direccionProveedor = ProveedorDto.getDireccionProveedor();
		String nombreProveedor = ProveedorDto.getNombreProveedor();
		String telefonoProveedor = ProveedorDto.getTelefonoProveedor();
		
		if(nitProveedor != null) {
			Proveedor.setNitProveedor(nitProveedor);
		}
		if(ciudadProveedor != null) {
			Proveedor.setCiudadProveedor(ciudadProveedor);
		}
		if(direccionProveedor != null) {
			Proveedor.setDireccionProveedor(direccionProveedor);
		}
		if(nombreProveedor != null) {
			Proveedor.setDireccionProveedor(direccionProveedor);
		}
		if(telefonoProveedor != null) {
			Proveedor.setTelefonoProveedor(telefonoProveedor);
		}		
		
		iProveedor.save(Proveedor);
	}


	@Override
	public ProveedoresDto buscarProveedorPorNit(Long nitProveedor) {
		Proveedores proveedores = null;
		try {
			proveedores = iProveedor.buscarProveedorPorNit(nitProveedor);
			ProveedoresDto  proveedoresDto = mapProveedorDto(proveedores);
			return proveedoresDto;
		} catch (Exception e) {
			return null;
		}
	}
	
	private ProveedoresDto mapProveedorDto(Proveedores proveedores) {
		return new ProveedoresDto(
				proveedores.getId(),
				proveedores.getNitProveedor(),
				proveedores.getCiudadProveedor(),
				proveedores.getDireccionProveedor(),
				proveedores.getNombreProveedor(),
				proveedores.getTelefonoProveedor()
		);		
	}
	

	@Override
	public void eliminarProveedor(Long nitProveedor) {
		// TODO Auto-generated method stub
		Proveedores proveedor = iProveedor.buscarProveedorPorNit(nitProveedor);
		iProveedor.delete(proveedor);
	}

	@Override
	public void actualizarProveedor(Long nitProveedor, ProveedoresDto ProveedorDto) {
		// TODO Auto-generated method stub
		Proveedores proveedor = iProveedor.buscarProveedorPorNit(nitProveedor);
		updateProveedor(ProveedorDto, proveedor);
	}

	@Override
	public List<Proveedores> listaProvedores() {
		return (List<Proveedores>) iProveedor.findAll();
	}

}
