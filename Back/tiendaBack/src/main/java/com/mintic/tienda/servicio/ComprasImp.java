package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Proveedores;
import com.mintic.tienda.repositories.ICompras;

@Service
public class ComprasImp implements IComprasService{
    @Autowired
	public
	ICompras iCompras;
	
	@Override
	public void crearCompras(ComprasDto ComprasDto) {
		iCompras.save(buildCompras(ComprasDto));
		
	}
	
	private Compras buildCompras(ComprasDto ComprasDto) {
		Compras Compras = new Compras();
		// Long id = ComprasDto.getID();
		Proveedores proveedores = ComprasDto.getProveedores();
		Date FechaCompra = ComprasDto.getFechaCompra();
        Double totalCompra = ComprasDto.getTotalCompra();
		Double ivaCompra = ComprasDto.getIvaCompra();
		
		if(proveedores != null) {
			Compras.setProveedores(proveedores);
		}
		if(FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if(totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if(ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}
				
		return Compras;
	}
	
	private void updateCompras(ComprasDto ComprasDto, Compras Compras) {
		
		// Compras Compras = new Compras();
		
		Proveedores proveedores = ComprasDto.getProveedores();
		Date FechaCompra = ComprasDto.getFechaCompra();
        Double totalCompra = ComprasDto.getTotalCompra();
		Double ivaCompra = ComprasDto.getIvaCompra();
		
		if(proveedores != null) {
			Compras.setProveedores(proveedores);
		}
		if(FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if(totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if(ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}
	}

	@Override
	public ComprasDto buscarComprasPorFechaCompra(Date FechaCompra) {
		Compras Compras = null;
		try {
			Compras = iCompras.buscarComprasPorFecha(FechaCompra);
			ComprasDto  ComprasDto = mapComprasDto(Compras);
			return ComprasDto;
		} 
		catch (Exception e) {
			return null;
		}
	}


	private ComprasDto mapComprasDto(Compras Compras) {
		return new ComprasDto(
				Compras.getIDCompras(),
				Compras.getProveedores(),
				Compras.getFechaCompra(),
				Compras.getTotalCompra(),
				Compras.getIvaCompra()
									
		);		
	}

	@Override
	public void eliminarCompras(Date FechaCompra) {
		
		Compras Compras = iCompras.buscarComprasPorFecha(FechaCompra);
		iCompras.delete(Compras);
		
	}

	@Override
	public void actualizarCompras(Date FechaCompra, ComprasDto ComprasDto) {
		Compras Compras = iCompras.buscarComprasPorFecha(FechaCompra);
		updateCompras(ComprasDto, Compras);

	}

	@Override
	public List<Compras> listaCompras() {
		return (List<Compras>) iCompras.findAll();
	}

	@Override
	public List<Compras> listaComprasProveedor(Long IDProveedor) {
		// TODO Auto-generated method stub
		
		List<Compras> lista = new ArrayList<Compras>();
		
		lista = iCompras.buscarComprasPorProveedor(IDProveedor);
		
		
		return (lista) ;
	}


	@Override
	public List<Compras> listarComprasPorFechaComprayProveedor(Date FechaVenta, Long IDProveedor) {
		// TODO Auto-generated method stub
		
		List<Compras> lista = new ArrayList<Compras>();
		
		lista = iCompras.buscarComprasPorFechayProveedor(FechaVenta, IDProveedor);
		
		
		return (lista) ;
	}

	

	
}
