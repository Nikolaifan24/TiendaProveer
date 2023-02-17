package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.DevolucionesDto;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.repositories.ICartera;
import com.mintic.tienda.repositories.IDevoluciones;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class DevolucionesImp implements IDevolucionesService {
    @Autowired
	IDevoluciones iDevoluciones;
	
	@Autowired
	IVendedor iVendedor;

	@Autowired
	ICartera iCartera;

	@Autowired
	IVenta iVenta;

	@Override
	public List<Devoluciones> listaDevoluciones() {
		return (List<Devoluciones>) iDevoluciones.ListarDevolucionesenOrden();
	}

	private DevolucionesDto mapDevolucionesDto(Devoluciones devoluciones) {
		return new DevolucionesDto(

			devoluciones.getID(),
			devoluciones.getVentas(),
			devoluciones.getVendedor(),
			devoluciones.getCodigoVenta(),
			devoluciones.getFechaVenta(),
			devoluciones.getNombreVendedor(),
			devoluciones.getTotalDevoluciones()
				
		);
	}

	
	@Override
	public DevolucionesDto buscarDevolucionesPorCodigoventa(Long Codigoventa) {
		// TODO Auto-generated method stub
		Devoluciones devoluciones = null;
		try {
			devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(Codigoventa);
			DevolucionesDto DevolucionesDto = mapDevolucionesDto(devoluciones);
			return DevolucionesDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

    @Override
	public void crearDevoluciones(DevolucionesDto DevolucionesDto) {
		iDevoluciones.save(buildDevoluciones(DevolucionesDto));
	}

    private Devoluciones buildDevoluciones(DevolucionesDto DevolucionesDto) {
		Devoluciones Devoluciones = new Devoluciones();
        Long codigoventa = DevolucionesDto.getCodigoVenta();
		Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
		String nombreVendedor = ventas.getNombreVendedor();
        Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        String fechaVenta = ventas.getFechaVenta();
		Double Total = cargarCalculosdeunaDevolucion(codigoventa);

		if(nombreVendedor != null) {
			Devoluciones.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			
			Devoluciones.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			
			Devoluciones.setCodigoVenta(codigoventa);
		}
		if(ventas != null) {
			
			Devoluciones.setVentas(ventas);
		}
		if(fechaVenta != null) {
			
			Devoluciones.setFechaVenta(fechaVenta);
		}
		if(Total != null) {
			
			Devoluciones.setTotalDevoluciones(Total);
		}


		return Devoluciones;
	}

	@Override
	public void eliminarDevoluciones(Long Codigoventa) {
		// TODO Auto-generated method stub
			Devoluciones Devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(Codigoventa);
			iDevoluciones.delete(Devoluciones);
		
	}

	@Override
	public void actualizarDevoluciones(Long Codigoventa, DevolucionesDto DevolucionesDto) {
		// TODO Auto-generated method stub

			Devoluciones Devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(Codigoventa);
			updateDevoluciones(Codigoventa, DevolucionesDto, Devoluciones);
		
	}
	private void updateDevoluciones (Long CodigoVenta, DevolucionesDto DevolucionesDto, Devoluciones devoluciones){
	
        Long codigoventa = DevolucionesDto.getCodigoVenta();
		Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
		String nombreVendedor = ventas.getNombreVendedor();
        Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        String fechaVenta = ventas.getFechaVenta();
		Double Total = cargarCalculosdeunaDevolucion(codigoventa);

		if(nombreVendedor != null) {
			
			devoluciones.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			
			devoluciones.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			
			devoluciones.setCodigoVenta(codigoventa);
		}
		if(ventas != null) {
			
			devoluciones.setVentas(ventas);
		}
		if(fechaVenta != null) {
			
			devoluciones.setFechaVenta(fechaVenta);
		}
		if(Total != null) {
			
			devoluciones.setTotalDevoluciones(Total);
		}
		iDevoluciones.save(devoluciones);
	}

	@Override
	public List<Devoluciones> listaDevolucionesporVendedor(String nombreVendedor) {
		List<Devoluciones> lista = new ArrayList<Devoluciones>();
		
		lista = iDevoluciones.buscarDevolucionesPorVendedor(nombreVendedor);
		
		
		return (lista) ;
	}
	
	@Override
	public List<Productos> listaDevolucionesPorProductos(String nombreProducto) {

		List<Productos> lista = new ArrayList<Productos>();
		
		lista = iDevoluciones.buscarDevolucionesPornombreProducto(nombreProducto);
		
		return (lista) ;
	}

	@Override
	public Double cargarCalculosdeunaDevolucion(Long CodigoVenta) {
		Double total = iDevoluciones.TotaldeunaDevolucion(CodigoVenta);
		if (total == null) {
			total = 0.0;
		}
		return total;
	}

	@Override
	public Integer ContarDevoluciones(Long CodigoVenta){
		int conteo = iDevoluciones.ContadorRepetidosDevoluciones(CodigoVenta);
		return conteo;
	}
}	
