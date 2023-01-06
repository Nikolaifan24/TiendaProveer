package com.mintic.tienda.servicio;

import java.util.ArrayList;
// import java.util.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.dto.DetallecompraDto;
// import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Detallecompra;
import com.mintic.tienda.entities.Proveedores;
import com.mintic.tienda.repositories.ICompras;
import com.mintic.tienda.repositories.IDetalleCompra;
import com.mintic.tienda.repositories.IProveedor;

@Service
public class ComprasImp implements IComprasService{
    @Autowired
	public
	ICompras iCompras;
	IDetalleCompra idetallecompra;
	IProveedor iProveedor;
	
	@Override
	public void crearCompras(ComprasDto ComprasDto) {
		iCompras.save(buildCompras(ComprasDto));
		// iCompras.save(realizarCalculoCompra(detallecompraDto));
		
	}
	
	private Compras buildCompras(ComprasDto ComprasDto) {
		Compras Compras = new Compras();
		// Long id = ComprasDto.getID();
		// realizarCalculoCompra(detallecompraDto);
		// ProveedoresDto proveedoresdto = new ProveedoresDto();
		// Long nitProveedor = proveedoresdto.getNitProveedor();
		Long nit = ComprasDto.getProveedores().getNitProveedor();
		Proveedores proveedores = iProveedor.buscarProveedorPorNit(nit);
		String FechaCompra = ComprasDto.getFechaCompra();
        Double totalCompra = ComprasDto.getTotalCompra();
		Double ivaCompra = ComprasDto.getIvaCompra();
		// Proveedores proveedores = iProveedor.buscarProveedorPorNit(nitProveedor);
		// System.out.println("el Proveedor es aca" +ivaCompra);
		if(proveedores != null) {
			System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setProveedores(proveedores);
		}
		if(FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if(totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if(ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}
				
		return Compras;
	}
	
	private void upStringCompras(ComprasDto ComprasDto, Compras Compras) {
		
		// Compras Compras = new Compras();
		
		// Proveedores proveedores = ComprasDto.getProveedores();
		String FechaCompra = ComprasDto.getFechaCompra();
        Double totalCompra = ComprasDto.getTotalCompra();
		Double ivaCompra = ComprasDto.getIvaCompra();
		
		// if(proveedores != null) {
		// 	Compras.setProveedores(proveedores);
		// }
		if(FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if(totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if(ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}
	}

	@Override
	public ComprasDto buscarComprasPorFechaCompra(String FechaCompra) {
		Compras Compras = null;
		try {
			Compras = iCompras.buscarComprasPorFecha(FechaCompra);
			ComprasDto  ComprasDto = mapComprasDto(Compras);
			return ComprasDto;
		} 
		catch (Exception e) {
			return null;
		}
	}


	private ComprasDto mapComprasDto(Compras Compras) {
		return new ComprasDto(
				Compras.getIDCompras(),
				Compras.getProveedores(),
				Compras.getFechaCompra(),
				Compras.getTotalCompra(),
				Compras.getIvaCompra()
									
		);		
	}

	@Override
	public void eliminarCompras(String FechaCompra) {
		
		Compras Compras = iCompras.buscarComprasPorFecha(FechaCompra);
		iCompras.delete(Compras);
		
	}

	@Override
	public void actualizarCompras(String FechaCompra, ComprasDto ComprasDto) {
		Compras Compras = iCompras.buscarComprasPorFecha(FechaCompra);
		upStringCompras(ComprasDto, Compras);

	}

	@Override
	public List<Compras> listaCompras() {
		return (List<Compras>) iCompras.findAll();
	}

	@Override
	public List<Compras> listaComprasProveedor(String nombreProveedor) {
		// TODO Auto-generated method stub
		
		List<Compras> lista = new ArrayList<Compras>();
		
		lista = iCompras.buscarCompraPorNombreProveedor(nombreProveedor);
		
		
		return (lista) ;
	}


	@Override
	public List<Compras> listaComprasPorProductos(String nombreProducto) {
		// TODO Auto-generated method stub
		
		List<Compras> lista = new ArrayList<Compras>();
		
		lista = iCompras.buscarCompraPorProductos(nombreProducto);
		
		
		return (lista) ;
	}

	@Override
	public List<Detallecompra> listaComprasPordetalles(String FechaCompra) {
		// TODO Auto-generated method stub
		
		List<Detallecompra> lista = new ArrayList<Detallecompra>();
		
		lista = idetallecompra.buscarDetalleCompraPorFecha(FechaCompra);
		
		
		return (lista) ;
	}

	@Override
	public List<Compras> listarComprasPorProveedor(String nombreProveedor) {
		// TODO Auto-generated method stub
		
		List<Compras> lista = new ArrayList<Compras>();
		
		lista = iCompras.buscarCompraPorNombreProveedor(nombreProveedor);
		
		
		return (lista) ;
	}

	

	@Override
	public DetallecompraDto realizarCalculoCompra(DetallecompraDto detallecompraDto) {
	
		Double valorunitario = detallecompraDto.getValorUnitario();
		Integer cantidadProducto = detallecompraDto.getCantidadProducto();
		Double valorProductos = valorunitario * cantidadProducto;
		
		if(cantidadProducto != null) {
			detallecompraDto.setCantidadProducto(cantidadProducto);
		}
		if(valorunitario != null) {
			detallecompraDto.setValorUnitario(valorunitario);
		}
		if(valorProductos != null) {
			detallecompraDto.setValorTotal(valorProductos);
		}
		
		
		return detallecompraDto;
	}

	
}
