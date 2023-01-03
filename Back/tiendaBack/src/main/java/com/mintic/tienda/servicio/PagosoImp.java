package com.mintic.tienda.servicio;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
// import java.util.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Clientes;
// import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.IPagos;

@Service
public class PagosoImp implements IPagosService {

    @Autowired
	public
	IPagos iPagos;
	
	@Override
	public void crearPagos(PagosDto PagosDto) {
		iPagos.save(buildPagos(PagosDto));
		
	}
	
	private Pagos buildPagos(PagosDto PagosDto) {
		Pagos Pagos = new Pagos();
		// Long id = PagosDto.getID();
		Clientes clientes = PagosDto.getClientes();
		Ventas ventas = PagosDto.getVentas();
        String FechaVenta = PagosDto.getFechaVenta();
        String FechaPago = PagosDto.getFechaPago();
		String TipoPago = PagosDto.getTipoPago();
		String MedioPago = PagosDto.getMedioPago();
        Double Valor = PagosDto.getValorPago();
		
        if(ventas!= null) {
			Pagos.setVentas(ventas);;
		}
		if(clientes != null) {
			Pagos.setClientes(clientes);;
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
		
		// Pagos Pagos = new Pagos();
		Clientes clientes = PagosDto.getClientes();
		Ventas ventas = PagosDto.getVentas();
        String FechaVenta = PagosDto.getFechaVenta();
        String FechaPago = PagosDto.getFechaPago();
		String TipoPago = PagosDto.getTipoPago();
		String MedioPago = PagosDto.getMedioPago();
        Double Valor = PagosDto.getValorPago();
		
        if(ventas!= null) {
			Pagos.setVentas(ventas);;
		}
		if(clientes != null) {
			Pagos.setClientes(clientes);;
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
	public PagosDto buscarPagosPorFechaPago(String FechaPago) {
		Pagos Pagos = null;
		try {
			Pagos = iPagos.buscarPagosporFechapago(FechaPago);
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
				Pagos.getFechaVenta(),
				Pagos.getFechaPago(),
				Pagos.getTipoPago(),
                Pagos.getMedioPago(),
                Pagos.getValorPago()
						
		);		
	}

	@Override
	public void eliminarPagos(String FechaPago) {
		
		Pagos Pagos = iPagos.buscarPagosporFechapago(FechaPago);
		iPagos.delete(Pagos);
		
	}

	@Override
	public void actualizarPagos(String FechaPago, PagosDto PagosDto) {
		Pagos Pagos = iPagos.buscarPagosporFechapago(FechaPago);
		upStringPagos(PagosDto, Pagos);

	}

	@Override
	public List<Pagos> listaPagos() {
		return (List<Pagos>) iPagos.findAll();
	}

	@Override
	public List<Pagos> listaPagosCliente(String nombreCliente, String apellidoCliente) {
		// TODO Auto-generated method stub
		
		List<Pagos> lista = new ArrayList<Pagos>();
		
		lista = iPagos.buscarPagosPorCliente(nombreCliente, apellidoCliente);
		
		
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
        // TODO Auto-generated method stub
        return null;
    }

	

  
    
}
