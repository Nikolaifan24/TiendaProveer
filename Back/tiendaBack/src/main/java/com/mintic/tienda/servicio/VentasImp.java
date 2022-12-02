package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.CalculoDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.dto.ResultadoVentaDto;
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
				venta.getId(),
				venta.getCodigoVenta(),
				venta.getIdCliente(),
				venta.getIdUsuario(),
				venta.getIvaVenta(),
				venta.getTotalVenta(),
				venta.getValorVenta()
		);
	}

	@Override
	public void crearVenta(VentasDto ventasDto) {
		iVenta.save(buildVenta(ventasDto));
		
	}

	private Ventas buildVenta(VentasDto ventasDto) {
		Ventas venta = new Ventas();
		
		Long id =  ventasDto.getId();
		Long codigoVenta = ventasDto.getCodigoVenta();
		Long idCliente = ventasDto.getIdCliente();
		Long idUsuario = ventasDto.getIdUsuario();
		Double ivaVenta = ventasDto.getIvaVenta();
		Double totalVenta = ventasDto.getTotalVenta();
		Double valorVenta = ventasDto.getValorVenta();
		
		if(id != null) {
			venta.setId(id);
		}
		if(codigoVenta != null) {
			venta.setCodigoVenta(codigoVenta);
		}
		if(idCliente != null) {
			venta.setIdCliente(idCliente);
		}
		if(idUsuario != null) {
			venta.setIdUsuario(idUsuario);
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
