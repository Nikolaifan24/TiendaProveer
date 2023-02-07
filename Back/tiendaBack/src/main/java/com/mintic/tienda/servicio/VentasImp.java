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
import com.mintic.tienda.repositories.ICliente;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentasImp implements IVentasService{
	
	@Autowired
	public
	IVenta iVenta;

	@Autowired
	ICliente iCliente;

	@Autowired
	IVendedor iVendedor;

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
				venta.getDocumentoCliente(),
				venta.getNombreVendedor(),
				venta.getDescuento(),
				venta.getTotalVenta(),
				venta.getIvaVenta(),
				venta.getZonaventa()
		
		);
	}

	
	private Ventas buildVenta(VentasDto ventasDto) {
		Ventas venta = new Ventas();
		
		// Long id =  ventasDto.getIDVenta();
		Long documentoCliente = ventasDto.getDocumentoCliente();
		String nombreVendedor = ventasDto.getNombreVendedor();
		Clientes clientes = iCliente.buscarClientePorCedula(documentoCliente);
		Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
		Long CodigoVenta = ventasDto.getCodigoVenta();
		String fechaVenta = ventasDto.getFechaVenta();
		String fechaEntrega = ventasDto.getFechaEntrega();
		Integer descuento = ventasDto.getDescuento();
		String zonaVenta = ventasDto.getZonaventa();
		Double Total = cargarCalculosdeVenta(CodigoVenta);
		Double iva = Total*0.19;
		
		// if(id != null) {
		// 	venta.setIDVenta(id);
		// }
		if(nombreVendedor  != null) {
			venta.setNombreVendedor(nombreVendedor);
		}
		if(documentoCliente  != null) {
			venta.setDocumentoCliente(documentoCliente);
		}
		if(clientes  != null) {
			venta.setClientes(clientes);
		}
		if(vendedor  != null) {
			venta.setVendedor(vendedor);
		}
		if(CodigoVenta != null) {
			venta.setCodigoVenta(CodigoVenta);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(fechaEntrega);
		}
		if(fechaVenta != null) {
			venta.setFechaVenta(fechaVenta);
		}
		if(descuento != null) {
			venta.setDescuento(descuento);
		}
		if(zonaVenta != null) {
			venta.setZonaventa(zonaVenta);
		}
		if(Total != null) {
			venta.setTotalVenta(Total);
		}
		if(iva != null) {
			venta.setIvaVenta(iva);
		}
			
		return venta;
		
		
	}

	
	@Override
	public void crearVentas(VentasDto VentasDto) {
		
		Ventas ventas = buildVenta(VentasDto);
		Long Codigo = ventas.getCodigoVenta();
		int repetidos = iVenta.ContadorRepetidosdeunaVenta(Codigo);
		System.out.println("este es el total de repetidos" + repetidos);
		if (repetidos != 0) {
			System.out.println("esta repetido un detalle por favor rectificar");
			// return 0;
		}
		// while(Detallecompra.getVentas() != detallecompra2.getVentas()) {
		else {
			iVenta.save(buildVenta(VentasDto));
			// return 1;
		}
	


		// iVenta.save(buildVenta(VentasDto));
		
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
		Long documentoCliente = ventasDto.getDocumentoCliente();
		String nombreVendedor = ventasDto.getNombreVendedor();
		Clientes clientes = iCliente.buscarClientePorCedula(documentoCliente);
		Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
		Long CodigoVenta = ventasDto.getCodigoVenta();
		String fechaVenta = ventasDto.getFechaVenta();
		String fechaEntrega = ventasDto.getFechaEntrega();
		Integer descuento = ventasDto.getDescuento();
		String zonaVenta = ventasDto.getZonaventa();
		Double Total = cargarCalculosdeVenta(CodigoVenta);
		Double iva = Total*0.19;
		
		// if(id != null) {
		// 	venta.setIDVenta(id);
		// }
		if(nombreVendedor  != null) {
			venta.setNombreVendedor(nombreVendedor);
		}
		if(documentoCliente  != null) {
			venta.setDocumentoCliente(documentoCliente);
		}
		if(clientes  != null) {
			venta.setClientes(clientes);
		}
		if(vendedor  != null) {
			venta.setVendedor(vendedor);
		}
		if(CodigoVenta != null) {
			venta.setCodigoVenta(CodigoVenta);
		}
		if(fechaEntrega != null) {
			venta.setFechaEntrega(fechaEntrega);
		}
		if(fechaVenta != null) {
			venta.setFechaVenta(fechaVenta);
		}
		if(descuento != null) {
			venta.setDescuento(descuento);
		}
		if(zonaVenta != null) {
			venta.setZonaventa(zonaVenta);
		}
		if(Total != null) {
			venta.setTotalVenta(Total);
		}
		if(iva != null) {
			venta.setIvaVenta(iva);
		}
		iVenta.save(venta);
	}


	@Override
	public List<Ventas> listaVentasporVendedor(String nombreVendedor) {
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
	public Double cargarCalculosdeVenta(Long CodigoVenta) {
		Double total = iVenta.TotaldelaVenta(CodigoVenta);
		if (total == null) {
			total = 0.0;
		}
		return total;
	}
	
	

	
}
