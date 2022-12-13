package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.CalculoDto;
import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Productos;
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
	public VentasDto buscarVentaPorCodigo(Long codigoVenta) {
		Ventas venta = null;
		try {
			venta = iVenta.buscarVentaPorCodigo(codigoVenta);
			VentasDto ventasDto = mapVentasDto(venta);
			return ventasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private VentasDto mapVentasDto(Ventas venta) {
		return new VentasDto(
				venta.getIDVenta(),
				venta.getIDCliente(),
				venta.getIDVendedor(),
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
		Long idCliente = ventasDto.getIDCliente();
		Long idVendedor = ventasDto.getIDVendedor();
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
		if(idCliente  != null) {
			venta.setIDCliente(idCliente);
		}
		if(fechaVenta != null) {
			venta.setFechaVenta(null);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(null);
		}
		if(ivaVenta != null) {
			venta.setIvaVenta(ivaVenta);
		}
		if(totalVenta != null) {
			venta.setTotalVenta(totalVenta);
		}
		if(valorVenta != null) {
			venta.setValorVenta(valorVenta);
		}
			
		return venta;
		
		
	}

	@Override
	public CalculoDto realizarCalculo(ProductosDto productosDto, Integer cantidad) {
		CalculoDto calculoDto = new CalculoDto();
		
		Long codigoProducto = productosDto.getCodigoProducto();
		Double precioCompra = productosDto.getPrecioCompra();
		Double ivaCompra = productosDto.getIvaCompra();
		Integer cantidadProducto = cantidad;
		Double valorProductos = precioCompra * cantidadProducto;
		Double valorIvas = ivaCompra * cantidadProducto;
		Double valorVenta = valorProductos + valorIvas;
		
		if(codigoProducto != null) {
			calculoDto.setCodigoProducto(codigoProducto);
		}
		if(precioCompra != null) {
			calculoDto.setPrecioCompra(precioCompra);
		}
		if(ivaCompra != null) {
			calculoDto.setIvaCompra(ivaCompra);
		}
		if(cantidadProducto != null) {
			calculoDto.setCantidadProducto(cantidadProducto);
		}
		if(valorProductos != null) {
			calculoDto.setValorProductos(valorProductos);
		}
		if(valorIvas != null) {
			calculoDto.setValorIvas(valorIvas);
		}
		if(valorVenta != null) {
			calculoDto.setValorVenta(valorVenta);
		}
		
		return calculoDto;
	}

	
	

}
