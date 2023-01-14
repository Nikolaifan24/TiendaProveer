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
import com.mintic.tienda.repositories.IProducto;
import com.mintic.tienda.repositories.IVenta;

@Service
public class DetalleVentasImp implements IDetalleVentasService{

	@Autowired
	IDetalleVenta iDetalleVentas;

	@Autowired
	IProducto iProducto;

	@Autowired
	IVenta iVenta;


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
					detalleVentas.getNombreProducto(),
					detalleVentas.getCantidadProducto(),
					detalleVentas.getPrecioProducto(),
					detalleVentas.getTotalDetalle()
										
			);		
				
	}

	@Override
	public void crearDetalleventas(Long CodigoVenta, DetalleventaDto DetalleventasDto){
		iDetalleVentas.save(buildDetalleVentas(CodigoVenta, DetalleventasDto));
		
	}

	private Detalleventa buildDetalleVentas(Long CodigoVenta, DetalleventaDto detalleVentasDto) {
		Detalleventa detalleVenta = new Detalleventa();
		
		// Long id = detalleVentasDto.getID();
		// Long idVenta = detalleVentasDto.getIDVenta();
		// Long idProducto = detalleVentasDto.getIDProducto();
		String nombredelProducto = detalleVentasDto.getNombreProducto();
		Ventas ventas = iVenta.buscarVentasPorCodigo(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = detalleVentasDto.getCantidad();
		Double precioProducto = detalleVentasDto.getPrecioProducto();
		Double totalDetalle = cantidadProducto*precioProducto;
		System.out.println("el total de mi detalle es:  "+totalDetalle);
		Long inventario = productos.getCantidadProducto()- cantidadProducto;
		if (nombredelProducto != null){
			detalleVenta.setNombreProducto(nombredelProducto);
		}
		if (ventas != null){
			detalleVenta.setVentas(ventas);
		}
		if (productos != null){
			detalleVenta.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			detalleVenta.setCantidadProducto(cantidadProducto);;
		}
		if(precioProducto != null) {
			detalleVenta.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			detalleVenta.setTotalDetalle(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}

		iProducto.save(productos);

		return detalleVenta;
		
	}

	@Override
	public void actualizarDetalleventa(Long codigoventa, String nombreProducto, DetalleventaDto detalleDto) {
		// TODO Auto-generated method stub

		Detalleventa detalle = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoventa, nombreProducto);
        updateDetalleventa(codigoventa, detalleDto, detalle);
	}

	private void updateDetalleventa (Long CodigoVenta, DetalleventaDto detalleDto, Detalleventa detalle){
        String nombredelProducto = detalleDto.getNombreProducto();
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		Integer cantidadProducto = detalleDto.getCantidad();
		Double precioProducto = detalleDto.getPrecioProducto();
		Double totalDetalle = cantidadProducto*precioProducto;
		Long inventario = productos.getCantidadProducto()-cantidadProducto;	
		if (productos != null){
			detalle.setProductos(productos);
		}
		if(cantidadProducto != null) {
			detalle.setCantidadProducto(cantidadProducto);;
		}
		if(precioProducto != null) {
			detalle.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			detalle.getTotalDetalle();
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iProducto.save(productos);
        iDetalleVentas.save(detalle);
    }

	
	
	
	@Override
	public List<Detalleventa> ListarDetalleventasPorCodigo(Long Codigoventa)  {
		
		List<Detalleventa> lista = new ArrayList<Detalleventa>();
		
		lista = iDetalleVentas.buscarDetalleVentaPorCodigoVenta(Codigoventa);
		
		
		return (lista) ;
	}
	

	
	
}
