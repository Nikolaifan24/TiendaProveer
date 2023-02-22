package com.mintic.tienda.servicio;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
// import java.util.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Cartera;
import com.mintic.tienda.entities.Clientes;
// import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.ICartera;
import com.mintic.tienda.repositories.ICliente;
import com.mintic.tienda.repositories.IPagos;
import com.mintic.tienda.repositories.IVenta;

@Service
public class PagosoImp implements IPagosService {

    @Autowired
	IPagos iPagos;

	@Autowired
	ICliente iCliente;

	@Autowired
	IVenta iVenta;

	@Autowired
	ICartera iCartera;
	
	@Override
	public void crearPagos(PagosDto PagosDto) {
		Pagos pagos = buildPagos(PagosDto);
		Long CodigoVenta = pagos.getCodigoVenta();
		iPagos.save(pagos);
		ModificarCartera(pagos, CodigoVenta);
	}

	public void ModificarCartera(Pagos pagos, Long CodigoVenta){

		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Double Total= pagos.getValorPago();
		Double TotalCartera = cartera.getSaldo() - Total;

		if (TotalCartera!= null){
			cartera.setSaldo(TotalCartera);
		}
		iCartera.save(cartera);

	}
	
	private Pagos buildPagos(PagosDto PagosDto) {
		Pagos Pagos = new Pagos();
		Long Codigoventa = PagosDto.getCodigoVenta();
		Long documentoCliente = PagosDto.getDocumentoCliente();
		Clientes clientes = iCliente.buscarClientePorCedula(documentoCliente);
		Ventas ventas = iVenta.buscarVentasPorCodigo(Codigoventa);
        String FechaVenta = ventas.getFechaVenta();
        String FechaPago = PagosDto.getFechaPago();
		String TipoPago = PagosDto.getTipoPago();
		String MedioPago = PagosDto.getMedioPago();
        Double Valor = PagosDto.getValorPago();

		if(Codigoventa!= null) {
			Pagos.setCodigoVenta(Codigoventa);
		}
		if(documentoCliente!= null) {
			Pagos.setDocumentoCliente(documentoCliente);
		}
        if(ventas!= null) {
			Pagos.setVentas(ventas);
		}
		if(clientes != null) {
			Pagos.setClientes(clientes);
		}
		if(FechaVenta != null) {
			Pagos.setFechaVenta(FechaVenta);
		}
		if(FechaPago != null) {
			Pagos.setFechaPago(FechaPago);
		}
        if(TipoPago!= null) {
			Pagos.setTipoPago(TipoPago);
		}
        if(MedioPago != null) {
			Pagos.setMedioPago(MedioPago);
		}
		if(Valor != null) {
			Pagos.setValorPago(Valor);
		}
				
		return Pagos;

	}
	
	private void upStringPagos(PagosDto PagosDto, Pagos Pagos) {
		
		Long Codigoventa = PagosDto.getCodigoVenta();
		Long documentoCliente = PagosDto.getDocumentoCliente();
		Clientes clientes = iCliente.buscarClientePorCedula(documentoCliente);
		Ventas ventas = iVenta.buscarVentasPorCodigo(Codigoventa);
        String FechaVenta = ventas.getFechaVenta();
        String FechaPago = PagosDto.getFechaPago();
		String TipoPago = PagosDto.getTipoPago();
		String MedioPago = PagosDto.getMedioPago();
        Double Valor = PagosDto.getValorPago();
		

		if(Codigoventa!= null) {
			Pagos.setCodigoVenta(Codigoventa);
		}
		if(documentoCliente!= null) {
			Pagos.setDocumentoCliente(documentoCliente);
		}
        if(ventas!= null) {
			Pagos.setVentas(ventas);
		}
		if(clientes != null) {
			Pagos.setClientes(clientes);
		}
		if(FechaVenta != null) {
			Pagos.setFechaVenta(FechaVenta);
		}
		if(FechaPago != null) {
			Pagos.setFechaPago(FechaPago);
		}
        if(TipoPago!= null) {
			Pagos.setTipoPago(TipoPago);
		}
        if(MedioPago != null) {
			Pagos.setMedioPago(MedioPago);
		}
		if(Valor != null) {
			Pagos.setValorPago(Valor);
		}
		iPagos.save(Pagos);
	}

	@Override
	public PagosDto buscarPagosPorFechaPago(Long CodigoVenta, String FechaPago) {
		Pagos Pagos = null;
		try {
			Pagos = iPagos.buscarPagosporCodigoVentaFechapago(CodigoVenta, FechaPago);
			PagosDto  PagosDto = mapPagosDto(Pagos);
			return PagosDto;
		} 
		catch (Exception e) {
			return null;
		}
	}


	private PagosDto mapPagosDto(Pagos Pagos) {
		return new PagosDto(
				Pagos.getIDPagos(),
                Pagos.getClientes(),
				Pagos.getVentas(),
				Pagos.getCodigoVenta(),
				Pagos.getDocumentoCliente(),
				Pagos.getFechaVenta(),
				Pagos.getFechaPago(),
				Pagos.getTipoPago(),
                Pagos.getMedioPago(),
                Pagos.getValorPago()
						
		);		
	}

	@Override
	public void eliminarPagos(Long CodigoVenta, String FechaPago) {
		
		Pagos Pagos = iPagos.buscarPagosporCodigoVentaFechapago(CodigoVenta, FechaPago);
		iPagos.delete(Pagos);
		
	}

	@Override
	public void actualizarPagos(Long CodigoVenta, String FechaPago, PagosDto PagosDto) {
		Pagos Pagos = iPagos.buscarPagosporCodigoVentaFechapago(CodigoVenta, FechaPago);
		upStringPagos(PagosDto, Pagos);
		ModificarCartera(Pagos, CodigoVenta);

	}

	@Override
	public List<Pagos> listaPagos() {
		return (List<Pagos>) iPagos.findAll();
	}

	@Override
	public List<Pagos> listaPagosCliente(Long documentoCliente) {
		// TODO Auto-generated method stub
		
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorCliente(documentoCliente);
		
		
		return (lista) ;
	}

	@Override
	public List<Pagos> listaPagosFechaVenta(String Fechaventa) {
		// TODO Auto-generated method stub
		
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorFechaVenta(Fechaventa);
		
		
		return (lista) ;
	}

    @Override
	public List<Pagos> listarPagosMedioPago(String MedioPago) {
		// TODO Auto-generated method stub
		
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorMedio(MedioPago);
		
		
		return (lista) ;
	}

	@Override
	public List<Pagos> listarPagosPorFechaPagoyTipo(String FechaVenta, String TipoPago) {
		// TODO Auto-generated method stub
		
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorFechayTipo(FechaVenta, TipoPago);
		
		
		return (lista) ;
	}

    @Override
    public List<Pagos> listarPagosPorFechaPagoyVenta(String fechaVenta, String fechaPago) {
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorFechaPagoFechaVenta(fechaPago, fechaVenta);
		
		
		return (lista) ;
    }

	

  
    
}
