package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetalleventaDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detalleventa;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleVenta;

@Service
public class DetalleVentasImp implements IDetalleVentasService{

	@Autowired
	IDetalleVenta iDetalleVentas;

	@Override
	public List<Detalleventa> getDetalleVentas() {
		return (List<Detalleventa>) iDetalleVentas.findAll();
	}

	@Override
	public DetalleventaDto buscarDetalleVentasPorIdVenta(Long idVenta) {
		Detalleventa detalleVentas = null;
		try {
			detalleVentas = iDetalleVentas.buscarDetalleVentaPorIdVenta(idVenta);
			DetalleventaDto detalleVentasDto = mapDetalleVentasDto(detalleVentas);
			return detalleVentasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetalleventaDto mapDetalleVentasDto(Detalleventa detalleVentas) {
			return new DetalleventaDto(
					detalleVentas.getID(),
					detalleVentas.getVentas(),
					detalleVentas.getProductos(),
					detalleVentas.getCantidadProducto(),
					detalleVentas.getPrecioProducto(),
					detalleVentas.getTotalDetalle()
										
			);		
				
	}

	@Override
	public void crearDetalleVentas(DetalleventaDto detalleVentasDto) {
		iDetalleVentas.save(buildDetalleVentas(detalleVentasDto));
		
	}

	private Detalleventa buildDetalleVentas(DetalleventaDto detalleVentasDto) {
		Detalleventa detalleVenta = new Detalleventa();
		
		Long id = detalleVentasDto.getID();
		Long idVenta = detalleVentasDto.getIDVenta();
		Long idProducto = detalleVentasDto.getIDProducto();
		Integer cantidadProducto = detalleVentasDto.getCantidad();
		Double precioProducto = detalleVentasDto.getPrecioProducto();
		Double totalDetalle = detalleVentasDto.getTotalDetalle();
			
		if(id != null) {
			detalleVenta.setID(id);
		}
		if(id != null) {
			detalleVenta.setIDVenta(idVenta);
		}
		if(id != null) {
			detalleVenta.setIDProducto(idProducto);
		}
		if(cantidadProducto != null) {
			detalleVenta.setCantidadProducto(cantidadProducto);;
		}
		if(precioProducto != null) {
			detalleVenta.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			detalleVenta.getTotalDetalle();
		}
		
		return detalleVenta;
		
	}

	
	
}
