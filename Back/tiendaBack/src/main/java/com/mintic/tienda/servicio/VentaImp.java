package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.Date;
// import java.util.HashMap;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
// import org.springframework.stereotype.Service;
// import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Vendedor;
// import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentaImp  implements IVentaService{
    @Autowired
	public
	IVenta iVenta;
	
	@Override
	public List<Ventas> listarVentas() {
		return (List<Ventas>) iVenta.findAll();
	}



	@Override
	public void crearVentas(VentasDto VentaDto) {
		iVenta.save(buildVenta(VentaDto));
		
	}

	private Ventas buildVenta(VentasDto ventaDto) {
		Ventas venta = new Ventas();
		
		// Long id = VentaDto.getID();
		Long id =  ventaDto.getIDVenta();
		Clientes clientes = ventaDto.getClientes();
		Vendedor vendedor = ventaDto.getVendedor();
		Date fechaVenta = ventaDto.getFechaVenta();
		Date fechaEntrega = ventaDto.getFechaEntrega();
		Double totalVenta = ventaDto.getTotalVenta();
		Double ivaVenta = ventaDto.getIvaVenta();
		Double valorPago = ventaDto.getValorPago();
		Double saldo = ventaDto.getSaldo();
		String formaPago = ventaDto.getFormaPago();
		Date fechaPago = ventaDto.getFechaPago();
		String zonaVenta = ventaDto.getZonaventa();
		
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
			venta.setFechaVenta(fechaVenta);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(fechaEntrega);
		}
		if(totalVenta != null) {
			venta.setTotalVenta(totalVenta);
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
	
	private void updateVenta(VentasDto ventasDto, Ventas venta) {
		
		Long id =  ventasDto.getIDVenta();
		Clientes clientes = ventasDto.getClientes();
		Vendedor vendedor = ventasDto.getVendedor();
		Date fechaVenta = ventasDto.getFechaVenta();
		Date fechaEntrega = ventasDto.getFechaEntrega();
		Double totalVenta = ventasDto.getTotalVenta();
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
			venta.setFechaVenta(fechaVenta);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(fechaEntrega);
		}
		if(totalVenta != null) {
			venta.setTotalVenta(totalVenta);
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
		
		iVenta.save(venta);
	}
	

	@Override
	public void eliminarVenta(Date FechaVenta) {
		Ventas Venta = iVenta.buscarVentasPorFecha(FechaVenta);
		iVenta.delete(Venta);
		
	}

	@Override
	public void actualizarVenta(Date FechaVenta, VentasDto ventaDto) {
		
		Ventas venta = iVenta.buscarVentasPorFecha(FechaVenta);
		updateVenta(ventaDto, venta);
		
	}

	@Override
	public VentasDto buscarVentaPorFechaVenta(Date FechaVenta) {
		Ventas venta = null;
		try {
			venta = iVenta.buscarVentasPorFecha(FechaVenta);
			VentasDto  VentaDto = mapVentaDto(venta);
			return VentaDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	private VentasDto mapVentaDto(Ventas venta) {
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

	public List<Ventas> encontrarVentaPorNombre(Date FechaVenta){

		List<Ventas> lista = new ArrayList<Ventas>();
		lista.add(iVenta.buscarVentasPorFecha(FechaVenta));
		return lista;

	}



	@Override
	public List<Ventas> encontrarVentasPorNombre(Date FechaVenta) {
		// TODO Auto-generated method stub
		return null;
	}





  
	
}
