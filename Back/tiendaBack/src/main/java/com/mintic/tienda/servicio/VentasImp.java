package com.mintic.tienda.servicio;

import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.detalleventaDto;
// import com.mintic.tienda.dto.ProductosDto;
// import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Detalleventa;
import com.mintic.tienda.entities.Vendedor;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentasImp implements IVentasService{
	
	@Autowired
	public
	IVenta iVenta;

	@Override
	public List<Ventas> listaVentas() {

		return (List<Ventas>) iVenta.findAll();
		
	}


	private VentasDto mapVentasDto(Ventas venta) {
		return new VentasDto(
				venta.getIDVenta(),
				venta.getClientes(),
				venta.getVendedor(),
				venta.getCodigoVenta(),
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

	
	private Ventas buildVenta(VentasDto ventasDto) {
		Ventas venta = new Ventas();
		
		Long id =  ventasDto.getIDVenta();
		Clientes clientes = ventasDto.getClientes();
		Vendedor vendedor = ventasDto.getVendedor();
		Long codigoventa = ventasDto.getCodigoVenta();
		Long CodigoVenta = ventasDto.getCodigoVenta();
		String fechaEntrega = ventasDto.getFechaEntrega();
		Double valorVenta = ventasDto.getTotalVenta();
		Double ivaVenta = ventasDto.getIvaVenta();
		Double valorPago = ventasDto.getValorPago();
		Double saldo = ventasDto.getSaldo();
		String formaPago = ventasDto.getFormaPago();
		String fechaPago = ventasDto.getFechaPago();
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
		if(codigoventa!= null) {
			venta.setCodigoVenta(codigoventa);
		}
		if(CodigoVenta != null) {
			venta.setCodigoVenta(null);
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
	public void crearVentas(VentasDto VentasDto) {
		// TODO Auto-generated method stub
		iVenta.save(buildVenta(VentasDto));
		
	}

	@Override
	public VentasDto buscarVentasPorCodigoventa(Long Codigoventa) {
		// TODO Auto-generated method stub
		Ventas venta = null;
		try {
			venta = iVenta.buscarVentasPorCodigo(Codigoventa);
			VentasDto ventasDto = mapVentasDto(venta);
			return ventasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	@Override
	public void eliminarVentas(Long Codigoventa) {
		// TODO Auto-generated method stub
			Ventas Ventas = iVenta.buscarVentasPorCodigo(Codigoventa);
			iVenta.delete(Ventas);
		
	}

	@Override
	public void actualizarVentas(Long Codigoventa, VentasDto VentasDto) {
		// TODO Auto-generated method stub

			Ventas Ventas = iVenta.buscarVentasPorCodigo(Codigoventa);
			upStringVentas(VentasDto, Ventas);
		
	}

	
	private void upStringVentas(VentasDto ventasDto, Ventas ventas) {

		Ventas venta = new Ventas();
		
		Long id =  ventasDto.getIDVenta();
		Clientes clientes = ventasDto.getClientes();
		Vendedor vendedor = ventasDto.getVendedor();
		Long codigoventa = ventasDto.getCodigoVenta();
		Long CodigoVenta = ventasDto.getCodigoVenta();
		String fechaEntrega = ventasDto.getFechaEntrega();
		Double valorVenta = ventasDto.getTotalVenta();
		Double ivaVenta = ventasDto.getIvaVenta();
		Double valorPago = ventasDto.getValorPago();
		Double saldo = ventasDto.getSaldo();
		String formaPago = ventasDto.getFormaPago();
		String fechaPago = ventasDto.getFechaPago();
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
		if(codigoventa!= null) {
			venta.setCodigoVenta(codigoventa);
		}
		if(CodigoVenta != null) {
			venta.setCodigoVenta(null);
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
	}


	@Override
	public List<Ventas> listaVentasProveedor(String nombreVendedor) {
		// TODO Auto-generated method stub
		List<Ventas> lista = new ArrayList<Ventas>();
		
		lista = iVenta.buscarVentaPorNombreVendedor(nombreVendedor);
		
		
		return (lista) ;
	}

	@Override
	public List<Ventas> listarVentasPorProveedor(String nombreProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ventas> listaVentasPorProductos(String nombreProducto) {
		List<Ventas> lista = new ArrayList<Ventas>();
		
		lista = iVenta.buscarVentaPorNombreProdcuto(nombreProducto);
		
		return (lista) ;
	}

	@Override
	public List<Detalleventa> listaVentasPordetalles(Long Codigoventa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleventaDto realizarCalculoventa(DetalleventaDto detalleventaDto) {
		// TODO Auto-generated method stub

		Double precioProducto = detalleventaDto.getPrecioProducto();
		Integer cantidadProducto = detalleventaDto.getCantidad();
		Double valorProductos = precioProducto * cantidadProducto;
		
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
		// return null;
	}

	
	

}
