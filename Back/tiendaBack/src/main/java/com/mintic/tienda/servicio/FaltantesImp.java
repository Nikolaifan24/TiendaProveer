package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IFaltantes;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class FaltantesImp implements IFaltantesServices{
    @Autowired
	public
	IFaltantes iFaltantes;
	IVenta iVenta;
	@Autowired
	IVendedor iVendedor;

    @Override
	public void crearFaltantes(FaltantesDto FaltantesDto) {
		iFaltantes.save(buildFaltantes(FaltantesDto));
		// iFaltantes.save(realizarCalculoCompra(detallecompraDto));
		
	}
    
	private Faltantes buildFaltantes(FaltantesDto FaltantesDto) {
		Faltantes Faltantes = new Faltantes();
        String nombreVendedor = FaltantesDto.getNombreVendedor();
        Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        Long codigoventa = FaltantesDto.getCodigoventa();
        Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
		String fechaVenta = ventas.getFechaVenta();

		if(nombreVendedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Faltantes.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Faltantes.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Faltantes.setCodigoventa(codigoventa);
		}
		if(ventas != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Faltantes.setVentas(ventas);
		}
        if(fechaVenta != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Faltantes.setFechaVenta(fechaVenta);
		}

		return Faltantes;
	}

	@Override
	public List<Faltantes> listaFaltantes() {
		return (List<Faltantes>) iFaltantes.ListarFaltantesenOrden();
	}

}
