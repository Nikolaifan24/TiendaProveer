package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.NominaDto;
import com.mintic.tienda.entities.Nomina;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Nomina;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.INomina;
import com.mintic.tienda.repositories.IDevoluciones;
import com.mintic.tienda.repositories.IFaltantes;
import com.mintic.tienda.repositories.INomina;
import com.mintic.tienda.repositories.IVendedor;
import com.mintic.tienda.repositories.IVenta;

@Service
public class NominaImp implements INominaService{
    @Autowired
	IVenta iVenta;

	@Autowired
	IVendedor iVendedor;

    @Autowired
	IFaltantes iFaltantes;

    @Autowired
	IDevoluciones iDevoluciones;

    @Autowired
	INomina iNomina;

    @Override
	public List<Nomina> listarNomina() {

		return (List<Nomina>) iNomina.ListarNominasenOrden();
		
	}


	private NominaDto mapNominaDto(Nomina nomina) {
		return new NominaDto(
				nomina.getID(),
				nomina.getVentas(),
				nomina.getVendedor(),
                nomina.getDevoluciones(),
                nomina.getFaltantes(),
                nomina.getNombreVendedor(),
				nomina.getCodigoVenta(),
				nomina.getFechaInicio(),
				nomina.getFechaFinal(), 
                nomina.getTotalDevoluciones(),
				nomina.getTotalFaltantes(),
                nomina.getTotalVentas(),
				nomina.getTotalReal()
						
		);
	}

	
	private Nomina buildNomina(NominaDto NominaDto) {
		Nomina nomina = new Nomina();
        Long codigoVenta = nomina.getCodigoVenta();
        String nombreVendedor = nomina.getNombreVendedor();
        Ventas venta = iVenta.buscarVentasPorCodigo(codigoVenta);
        Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(codigoVenta);
        Faltantes faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(codigoVenta);
		Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        String fechaIncio = nomina.getFechaInicio();
        String fechaFinal = nomina.getFechaFinal();
        Double TotalDevoluciones = iNomina.SumarDevolucionessenunPeriodoTiempo(fechaIncio, fechaFinal);
        Double TotalFaltantes = iNomina.SumarFaltantessenunPeriodoTiempo(fechaIncio, fechaFinal);
        Double TotalVentas = iNomina.SumarVentasenunPeriodoTiempo(fechaIncio, fechaFinal);
		Double TotalReal = TotalVentas -TotalDevoluciones -TotalFaltantes;
		
		
		if(codigoVenta  != null) {
			nomina.setCodigoVenta(codigoVenta);
		}
		if(nombreVendedor  != null) {
			nomina.setNombreVendedor(nombreVendedor);
		}
		if(venta  != null) {
			nomina.setVentas(venta);
		}
		if(vendedor  != null) {
			nomina.setVendedor(vendedor);
		}
		if(devoluciones != null) {
			nomina.setDevoluciones(devoluciones);
		}
		if(faltantes != null) {
			nomina.setFaltantes(faltantes);
        }
		if(fechaIncio != null) {
			nomina.setFechaInicio(fechaIncio);
		}
		if(fechaFinal != null) {
			nomina.setFechaFinal(fechaFinal);
		}
		if(TotalVentas != null) {
			nomina.setTotalVentas(TotalVentas);
		}
		if(TotalDevoluciones != null) {
			nomina.setTotalDevoluciones(TotalDevoluciones);
        }
		if(TotalFaltantes != null) {
			nomina.setTotalFaltantes(TotalFaltantes);
		}
		if(TotalReal != null) {
			nomina.setTotalReal(TotalReal);
		}

		return nomina;
		
		
	}

		
	@Override
	public void crearNomina(NominaDto NominaDto) {
		
		Nomina nomina = buildNomina(NominaDto);
		String fechainicio = nomina.getFechaInicio();
        String fechafinal = nomina.getFechaFinal();
        String nombreVendedor = nomina.getNombreVendedor();
		int repetidos = iNomina.contadorNomina(nombreVendedor, fechainicio, fechafinal);
		if (repetidos != 0) {
			System.out.println("esta repetido un detalle por favor rectificar");
			// return 0;
		}
		// while(Detallecompra.getNomina() != detallecompra2.getNomina()) {
		else {

			iNomina.save(nomina);
		}
	


			
	}

	@Override
	public NominaDto buscarNomina(String nombreVendedor, String FechaInicio, String FechaFinal) {
		// TODO Auto-generated method stub
		Nomina venta = null;
		try {
			venta = iNomina.BuscarunaNomina(nombreVendedor, FechaInicio, FechaFinal);
			NominaDto NominaDto = mapNominaDto(venta);
			return NominaDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	@Override
	public void eliminarNomina(String nombreVendedor, String FechaInicio, String FechaFinal ) {
		// TODO Auto-generated method stub
			Nomina Nomina = iNomina.BuscarunaNomina(nombreVendedor, FechaInicio, FechaFinal);
			iNomina.delete(Nomina);
		
	}

	@Override
	public void actualizarNomina(String nombreVendedor, String FechaInicio, String FechaFinal, NominaDto NominaDto) {
		// TODO Auto-generated method stub

			Nomina Nomina = iNomina.BuscarunaNomina(nombreVendedor, FechaInicio, FechaFinal);
			upStringNomina(NominaDto, Nomina);
		
	}

	
	private void upStringNomina(NominaDto NominaDto, Nomina nomina) {
        Long codigoVenta = nomina.getCodigoVenta();
        String nombreVendedor = nomina.getNombreVendedor();
        Ventas venta = iVenta.buscarVentasPorCodigo(codigoVenta);
        Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(codigoVenta);
        Faltantes faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(codigoVenta);
		Vendedor vendedor = iVendedor.buscarVendedorPorNombre(nombreVendedor);
        String fechaIncio = nomina.getFechaInicio();
        String fechaFinal = nomina.getFechaFinal();
        Double TotalDevoluciones = iNomina.SumarDevolucionessenunPeriodoTiempo(fechaIncio, fechaFinal);
        Double TotalFaltantes = iNomina.SumarFaltantessenunPeriodoTiempo(fechaIncio, fechaFinal);
        Double TotalVentas = iNomina.SumarVentasenunPeriodoTiempo(fechaIncio, fechaFinal);
		Double TotalReal = TotalVentas -TotalDevoluciones -TotalFaltantes;
		
		
		if(codigoVenta  != null) {
			nomina.setCodigoVenta(codigoVenta);
		}
		if(nombreVendedor  != null) {
			nomina.setNombreVendedor(nombreVendedor);
		}
		if(venta  != null) {
			nomina.setVentas(venta);
		}
		if(vendedor  != null) {
			nomina.setVendedor(vendedor);
		}
		if(devoluciones != null) {
			nomina.setDevoluciones(devoluciones);
		}
		if(faltantes != null) {
			nomina.setFaltantes(faltantes);
        }
		if(fechaIncio != null) {
			nomina.setFechaInicio(fechaIncio);
		}
		if(fechaFinal != null) {
			nomina.setFechaFinal(fechaFinal);
		}
		if(TotalVentas != null) {
			nomina.setTotalVentas(TotalVentas);
		}
		if(TotalDevoluciones != null) {
			nomina.setTotalDevoluciones(TotalDevoluciones);
        }
		if(TotalFaltantes != null) {
			nomina.setTotalFaltantes(TotalFaltantes);
		}
		if(TotalReal != null) {
			nomina.setTotalReal(TotalReal);
		}
		iNomina.save(nomina);
	}
}
