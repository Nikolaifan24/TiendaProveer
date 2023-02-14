package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.DevolucionesDto;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IDevoluciones;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class DevolucionesImp implements IDevolucionesService {
    @Autowired
	public
	IDevoluciones iDevoluciones;
	IVenta iVenta;
	@Autowired
	IVendedor iVendedor;

    @Override
	public void crearDevoluciones(DevolucionesDto DevolucionesDto) {
		iDevoluciones.save(buildDevoluciones(DevolucionesDto));
	}

    private Devoluciones buildDevoluciones(DevolucionesDto DevolucionesDto) {
		Devoluciones Devoluciones = new Devoluciones();
        String nombreVendedor = DevolucionesDto.getNombreVendedor();
        Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        Long codigoventa = DevolucionesDto.getCodigoVenta();
        Ventas ventas = iVenta.buscarVentasPorCodigo(codigoventa);
		String fechaVenta = ventas.getFechaVenta();

		if(nombreVendedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Devoluciones.setNombreVendedor(nombreVendedor);
		}
		if(vendedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Devoluciones.setVendedor(vendedor);
		}
		if(codigoventa != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Devoluciones.setCodigoVenta(codigoventa);
		}
		if(ventas != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Devoluciones.setVentas(ventas);
		}
        if(fechaVenta != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Devoluciones.setFechaVenta(fechaVenta);
		}

		return Devoluciones;
	}

	@Override
	public List<Devoluciones> listaDevoluciones() {
		return (List<Devoluciones>) iDevoluciones.ListarDevolucionesenOrden();
	}
}
