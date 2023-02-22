package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.ICartera;
import com.mintic.tienda.repositories.IFaltantes;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class FaltantesImp implements IFaltantesServices{
    @Autowired
	IFaltantes iFaltantes;
	
	@Autowired
	IVendedor iVendedor;

	@Autowired
	IVenta iVenta;

	@Autowired
	ICartera iCartera;

	@Override
	public List<Faltantes> listaFaltantes() {
		return (List<Faltantes>) iFaltantes.ListarFaltantesenOrden();
	}

	private FaltantesDto mapFaltantesDto(Faltantes Faltantes) {
		return new FaltantesDto(

			Faltantes.getIDFaltantes(),
			Faltantes.getVentas(),
			Faltantes.getVendedor(),
			Faltantes.getCodigoventa(),
			Faltantes.getFechaVenta(),
			Faltantes.getNombreVendedor(),
			Faltantes.getTotalFaltantes()
				
		);
	}

	@Override
	public FaltantesDto buscarFaltantesPorCodigoventa(Long Codigoventa) {
		// TODO Auto-generated method stub
		Faltantes Faltantes = null;
		try {
			Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(Codigoventa);
			FaltantesDto FaltantesDto = mapFaltantesDto(Faltantes);
			return FaltantesDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

    @Override
	public void crearFaltantes(FaltantesDto FaltantesDto) {
		iFaltantes.save(buildFaltantes(FaltantesDto));
				
	}
    
	private Faltantes buildFaltantes(FaltantesDto FaltantesDto) {
		Faltantes Faltantes = new Faltantes();
        Long codigoventa = FaltantesDto.getCodigoventa();
        Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
		String nombreVendedor = ventas.getNombreVendedor();
		Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
		String fechaVenta = ventas.getFechaVenta();
		Double Total = cargarCalculosdeunFaltante(codigoventa);
		if(nombreVendedor != null) {
			Faltantes.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			Faltantes.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			Faltantes.setCodigoventa(codigoventa);
		}
		if(ventas != null) {
			Faltantes.setVentas(ventas);
		}
        if(fechaVenta != null) {
			Faltantes.setFechaVenta(fechaVenta);
		}
		if(Total != null) {
			
			Faltantes.setTotalFaltantes(Total);
		}

		return Faltantes;
	}

	@Override
	public void eliminarFaltantes(Long Codigoventa) {
		// TODO Auto-generated method stub
			Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(Codigoventa);
			iFaltantes.delete(Faltantes);
		
	}

	@Override
	public void actualizarFaltantes(Long Codigoventa, FaltantesDto FaltantesDto) {
		// TODO Auto-generated method stub

			Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(Codigoventa);
			updateFaltantes(Codigoventa, FaltantesDto, Faltantes);
		
	}
	private void updateFaltantes (Long CodigoVenta, FaltantesDto FaltantesDto, Faltantes faltantes){
		
		String nombreVendedor = FaltantesDto.getNombreVendedor();
        Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        Long codigoventa = FaltantesDto.getCodigoventa();
		Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
        String fechaVenta = ventas.getFechaVenta();
		Double Total = cargarCalculosdeunFaltante(codigoventa);

		if(nombreVendedor != null) {
			
			faltantes.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			
			faltantes.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			
			faltantes.setCodigoventa(codigoventa);
		}
		if(ventas != null) {
			
			faltantes.setVentas(ventas);
		}
		if(fechaVenta != null) {
			
			faltantes.setFechaVenta(fechaVenta);
		}
		if(Total != null) {
			
			faltantes.setTotalFaltantes(Total);
		}
		iFaltantes.save(faltantes);
	}

	@Override
	public List<Faltantes> listaFaltantesporVendedor(String nombreVendedor) {
		List<Faltantes> lista = new ArrayList<Faltantes>();
		
		lista = iFaltantes.buscarFaltantesPorVendedor(nombreVendedor);
		
		
		return (lista) ;
	}
	
	@Override
	public List<Productos> listaFaltantesPorProductos(String nombreProducto) {

		List<Productos> lista = new ArrayList<Productos>();
		
		lista = iFaltantes.buscarfaltantesPornombreProducto(nombreProducto);
		
		return (lista) ;
	}

	@Override
	public Double cargarCalculosdeunFaltante(Long CodigoVenta) {
		Double total = iFaltantes.TotaldeunFaltante(CodigoVenta);
		if (total == null) {
			total = 0.0;
		}
		return total;
	}

	@Override
	public Integer ContarFaltantes(Long CodigoVenta){
		int conteo = iFaltantes.ContadorRepetidosFaltantes(CodigoVenta);
		return conteo;
	}
}
