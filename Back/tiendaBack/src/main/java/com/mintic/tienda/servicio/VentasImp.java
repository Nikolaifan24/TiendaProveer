package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.detalleventaDto;
// import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Vendedor;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentasImp implements IVentasService{
	
	@Autowired
	IVenta iVenta;

	@Override
	public List<Ventas> getVentas() {
		return (List<Ventas>) iVenta.findAll();
	}

	@Override
	public VentasDto buscarVentaPorfecha(Long fechaVenta) {
		Ventas venta = null;
		try {
			venta = iVenta.buscarVentaPorfecha(fechaVenta);
			VentasDto ventasDto = mapVentasDto(venta);
			return ventasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private VentasDto mapVentasDto(Ventas venta) {
		return new VentasDto(
				venta.getIDVenta(),
				venta.getClientes(),
				venta.getVendedor(),
				venta.getFechaVenta(),
				venta.getFechaEntrega(),
				venta.getTotalVenta(),
				venta.getIvaVenta(),
				venta.getValorPago(),
				venta.getSaldo(),
				venta.getFormaPago(),
				venta.getFechaPago(),
				venta.getZonaventa()
		
		);
	}

	@Override
	public void crearVenta(VentasDto ventasDto) {
		iVenta.save(buildVenta(ventasDto));
		
	}

	private Ventas buildVenta(VentasDto ventasDto) {
		Ventas venta = new Ventas();
		
		Long id =  ventasDto.getID();
		Clientes clientes = ventasDto.getClientes();
		Vendedor vendedor = ventasDto.getVendedor();
		Date fechaVenta = ventasDto.getFechaVenta();
		Date fechaEntrega = ventasDto.getFechaEntrega();
		Double valorVenta = ventasDto.getTotalVenta();
		Double ivaVenta = ventasDto.getIvaVenta();
		Double valorPago = ventasDto.getValorPago();
		Double saldo = ventasDto.getSaldo();
		String formaPago = ventasDto.getFormaPago();
		Date fechaPago = ventasDto.getFechaPago();
		String zonaVenta = ventasDto.getZonaventa();
		
		if(id != null) {
			venta.setIDVenta(id);
		}
		if(clientes  != null) {
			venta.setClientes(clientes);
		}
		if(vendedor  != null) {
			venta.setVendedor(vendedor);
		}
		if(fechaVenta != null) {
			venta.setFechaVenta(null);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(null);
		}
		if(valorVenta != null) {
			venta.setTotalVenta(ivaVenta);
		}
		if(ivaVenta != null) {
			venta.setIvaVenta(ivaVenta);
		}
		if(valorPago != null) {
			venta.setValorPago(valorPago);
		}
		if(saldo != null) {
			venta.setSaldo(saldo);
		}
		if(formaPago != null) {
			venta.setFormaPago(formaPago);
		}
		if(fechaPago != null) {
			venta.setFechaPago(null);
		}
		if(zonaVenta != null) {
			venta.setZonaventa(zonaVenta);
		}
			
		return venta;
		
		
	}

	@Override
	public DetalleventaDto realizarCalculo(DetalleventaDto detalleventaDto, Integer cantidad) {
		// DetalleventaDto detalleventaDto = new DetalleventaDto();
		
		// Long fechaProducto = detalleventaDto.getfechaProducto();
		// Double precioCompra = detalleventaDto.getPrecioCompra();
		// Double ivaCompra = productosDto.getIvaCompra();
		Double precioProducto = detalleventaDto.getPrecioProducto();
		Integer cantidadProducto = detalleventaDto.getCantidad();
		Double valorProductos = precioProducto * cantidadProducto;
		// Double valorIvas = ivaCompra * cantidadProducto;
		// Double valorVenta = valorProductos + valorIvas;
		
		// if(fechaProducto != null) {
		// 	detalleventaDto.setfechaProducto(fechaProducto);
		// }
		// if(precioCompra != null) {
		// 	detalleventaDto.setPrecioCompra(precioCompra);
		// }
		// if(ivaCompra != null) {
		// 	detalleventaDto.setIvaCompra(ivaCompra);
		// }
		if(cantidadProducto != null) {
			detalleventaDto.setCantidad(cantidadProducto);
		}
		if(precioProducto != null) {
			detalleventaDto.setPrecioProducto(precioProducto);
		}
		if(valorProductos != null) {
			detalleventaDto.setTotalDetalle(valorProductos);
		}
		
		
		return detalleventaDto;
	}

	
	

}
