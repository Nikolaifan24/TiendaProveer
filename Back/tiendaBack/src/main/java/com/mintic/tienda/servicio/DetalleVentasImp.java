package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetalleVentasDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.DetalleVentas;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleVentas;

@Service
public class DetalleVentasImp implements IDetalleVentasService{

	@Autowired
	IDetalleVentas iDetalleVentas;

	@Override
	public List<DetalleVentas> getDetalleVentas() {
		return (List<DetalleVentas>) iDetalleVentas.findAll();
	}

	@Override
	public DetalleVentasDto buscarDetalleVentasPorIdVenta(Long idVenta) {
		DetalleVentas detalleVentas = null;
		try {
			detalleVentas = iDetalleVentas.buscarDetalleVentaPorIdVenta(idVenta);
			DetalleVentasDto detalleVentasDto = mapDetalleVentasDto(detalleVentas);
			return detalleVentasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetalleVentasDto mapDetalleVentasDto(DetalleVentas detalleVentas) {
			return new DetalleVentasDto(
					detalleVentas.getId(),
					detalleVentas.getCodigoDetalleVenta(),
					detalleVentas.getCantidadProducto(),
					detalleVentas.getIdProducto(),
					detalleVentas.getIdVenta(),
					detalleVentas.getValorTotal(),
					detalleVentas.getValorVenta(),
					detalleVentas.getValorIva()
			);		
				
	}

	@Override
	public void crearDetalleVentas(DetalleVentasDto detalleVentasDto) {
		iDetalleVentas.save(buildDetalleVentas(detalleVentasDto));
		
	}

	private DetalleVentas buildDetalleVentas(DetalleVentasDto detalleVentasDto) {
		DetalleVentas detalleVentas = new DetalleVentas();
		
		Long id = detalleVentasDto.getId();
		Long codigoDetalleVenta = detalleVentasDto.getCodigoDetalleVenta();
		Integer cantidadProducto = detalleVentasDto.getCantidadProducto();
		Long idProducto = detalleVentasDto.getIdProducto();
		Long idVenta = detalleVentasDto.getIdVenta();
		Double valorTotal = detalleVentasDto.getValorTotal();
		Double valorVenta = detalleVentasDto.getValorVenta();
		Double valorIva = detalleVentasDto.getValorIva();
		
		if(id != null) {
			detalleVentas.setId(idVenta);
		}
		if(codigoDetalleVenta != null) {
			detalleVentas.setCodigoDetalleVenta(codigoDetalleVenta);
		}
		if(cantidadProducto != null) {
			detalleVentas.setCantidadProducto(cantidadProducto);;
		}
		if(idProducto != null) {
			detalleVentas.setIdProducto(idProducto);
		}
		if(idVenta != null) {
			detalleVentas.setIdVenta(idVenta);
		}
		if(valorTotal != null) {
			detalleVentas.setValorTotal(valorTotal);
		}
		if(valorVenta != null) {
			detalleVentas.setValorVenta(valorVenta);
		}
		if(valorIva != null) {
			detalleVentas.setValorIva(valorIva);
		}
		return detalleVentas;
		
	}
	
	
}
