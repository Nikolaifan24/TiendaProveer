package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetalleventaDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detalleventa;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleVenta;

@Service
public class DetalleVentasImp implements IDetalleVentasService{

	@Autowired
	IDetalleVenta iDetalleVentas;

	@Override
	public List<Detalleventa> ListarDetalleventas()  {
		return (List<Detalleventa>) iDetalleVentas.findAll();
	}

	
	@Override
	public DetalleventaDto buscarDetalleventaCodigoyNombre(Long codigoventa, String nombreProducto)  {
		Detalleventa detalleVentas = null;
		try {
			detalleVentas = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoventa, nombreProducto);
			DetalleventaDto detalleVentasDto = mapDetalleVentasDto(detalleVentas);
			return detalleVentasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetalleventaDto mapDetalleVentasDto(Detalleventa detalleVentas) {
			return new DetalleventaDto(
					detalleVentas.getIDDetalle(),
					detalleVentas.getVentas(),
					detalleVentas.getProductos(),
					detalleVentas.getCantidadProducto(),
					detalleVentas.getPrecioProducto(),
					detalleVentas.getTotalDetalle()
										
			);		
				
	}

	@Override
	public void crearDetalleventas(DetalleventaDto DetalleventasDto){
		iDetalleVentas.save(buildDetalleVentas(DetalleventasDto));
		
	}

	private Detalleventa buildDetalleVentas(DetalleventaDto detalleVentasDto) {
		Detalleventa detalleVenta = new Detalleventa();
		
		Long id = detalleVentasDto.getID();
		// Long idVenta = detalleVentasDto.getIDVenta();
		// Long idProducto = detalleVentasDto.getIDProducto();
		Integer cantidadProducto = detalleVentasDto.getCantidad();
		Double precioProducto = detalleVentasDto.getPrecioProducto();
		Double totalDetalle = detalleVentasDto.getTotalDetalle();
			
		if(id != null) {
			detalleVenta.setIDDetalle(id);;
		}
		if(id != null) {
			detalleVenta.getVentas();
		}
		if(id != null) {
			detalleVenta.getProductos();
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

	@Override
	public void actualizarDetalleventa(Long codigoventa, String nombreProducto, DetalleventaDto detalleDto) {
		// TODO Auto-generated method stub

		Detalleventa detalle = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoventa, nombreProducto);
        updateDetalleventa(detalleDto, detalle);
	}

	private void updateDetalleventa (DetalleventaDto detalleDto, Detalleventa detalle){
        Ventas ventas = detalleDto.getVentas();
        Productos productos = detalleDto.getProductos();
        Double valorunitario = detalleDto.getPrecioProducto();
		Integer cantidadProducto = detalleDto.getCantidad();
		Double valortotal = detalleDto.getTotalDetalle();
	
			
		if(ventas != null) {
			detalle.setVentas(ventas);;
		}
		if(productos != null) {
			detalle.getProductos();
        }
		if(valorunitario != null) {
			detalle.getPrecioProducto();
		}
		if(cantidadProducto != 0) {
			detalle.setCantidadProducto(0); 
		}
		if(valortotal != null) {
			detalle.setTotalDetalle(valortotal);;
		}

        iDetalleVentas.save(detalle);
    }

	
	
	
	@Override
	public List<Detalleventa> ListarDetalleventasPorCodigo(Long Codigoventa)  {
		
		List<Detalleventa> lista = new ArrayList<Detalleventa>();
		
		lista = iDetalleVentas.buscarDetalleVentaPorCodigoVenta(Codigoventa);
		
		
		return (lista) ;
	}
	

	
	
}
