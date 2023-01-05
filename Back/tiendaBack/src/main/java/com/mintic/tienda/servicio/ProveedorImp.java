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
		Long id = proveedorDto.getIDProveedor();
		String nombreProveedor = proveedorDto.getNombreProveedor();
		Long nitProveedor = proveedorDto.getNitProveedor();
		String ciudadProveedor = proveedorDto.getCiudadProveedor();
		String direccionProveedor = proveedorDto.getDireccionProveedor();
		String telefonoProveedor = proveedorDto.getTelefonoProveedor();
		String tipoproducto = proveedorDto.getTipoProducto();
		
		if(id != null) {
			proveedor.setIDProveedor(nitProveedor);
		}
		if(nombreProveedor != null) {
			proveedor.setNombreProveedor(nombreProveedor);
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
		if(telefonoProveedor != null) {
			proveedor.setTelefonoProveedor(telefonoProveedor);
		}
		if(tipoproducto != null) {
			proveedor.setTipoProducto(tipoproducto);
		}

		System.out.println(proveedor);
		return proveedor;
	}
	
	private void updateProveedor(ProveedoresDto ProveedorDto, Proveedores Proveedor) {
		String nombreProveedor = ProveedorDto.getNombreProveedor();
		Long nitProveedor = ProveedorDto.getNitProveedor();
		String ciudadProveedor = ProveedorDto.getCiudadProveedor();
		String direccionProveedor = ProveedorDto.getDireccionProveedor();
		String telefonoProveedor = ProveedorDto.getTelefonoProveedor();
		String tipoProducto = ProveedorDto.getTipoProducto();
		
		if(nombreProveedor != null) {
			Proveedor.setNombreProveedor(nombreProveedor);
		}
		if(nitProveedor != null) {
			Proveedor.setNitProveedor(nitProveedor);
		}
		if(ciudadProveedor != null) {
			Proveedor.setCiudadProveedor(ciudadProveedor);
		}
		if(direccionProveedor != null) {
			Proveedor.setDireccionProveedor(direccionProveedor);
		}
		if(telefonoProveedor != null) {
			Proveedor.setTelefonoProveedor(telefonoProveedor);
		}
		if(tipoProducto != null) {
			Proveedor.setTipoProducto(tipoProducto);
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
				proveedores.getIDProveedor(),
				// proveedores.getProductos(),
				proveedores.getNombreProveedor(),
				proveedores.getNitProveedor(),
				proveedores.getCiudadProveedor(),
				proveedores.getDireccionProveedor(),
				proveedores.getTelefonoProveedor(),
				proveedores.getTipoProducto()

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

	@Override
	public ProveedoresDto buscarProveedorPorTipoproducto(String TipoProducto) {
		Proveedores proveedores = null;
		try {
			proveedores = iProveedor.buscarProveedorPorTipoproducto(TipoProducto);
			ProveedoresDto  proveedoresDto = mapProveedorDto(proveedores);
			return proveedoresDto;
		} catch (Exception e) {
			return null;
		}
	}

}
