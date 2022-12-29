package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.CarteraDto;
import com.mintic.tienda.entities.Cartera;
import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.ICartera;

@Service 
public class CarteraImp implements ICarteraService{

    @Autowired
	public
	ICartera iCartera;
	
	@Override
	public void crearCartera(CarteraDto CarteraDto) {
		iCartera.save(buildCartera(CarteraDto));
		
	}
	
	private Cartera buildCartera(CarteraDto CarteraDto) {
		Cartera Cartera = new Cartera();
		// Long id = CarteraDto.getID();
		Clientes clientes = CarteraDto.getClientes();
		Ventas ventas = CarteraDto.getVentas();
		Pagos pagos = CarteraDto.getPagos();
		Date FechaVenta = CarteraDto.getFechaVenta();
		Date FechaPago = CarteraDto.getFechaPago();
		Double Saldo = ventas.getTotalVenta()-pagos.getValorPago();
		
		if(clientes != null) {
			Cartera.setClientes(clientes);;
		}
		if(ventas!= null) {
			Cartera.setVentas(ventas);;
		}
		if(pagos != null) {
			Cartera.setPagos(pagos);;
		}
		if(FechaVenta != null) {
			Cartera.setFechaVenta(FechaVenta);
		}
		if(FechaPago != null) {
			Cartera.setFechaPago(FechaPago);
		}
		if(Saldo != null) {
			Cartera.setSaldo(Saldo);
		}
				
		return Cartera;
	}
	
	private void updateCartera(CarteraDto CarteraDto, Cartera Cartera) {
		
		// Cartera Cartera = new Cartera();
		Clientes clientes = CarteraDto.getClientes();
		Ventas ventas = CarteraDto.getVentas();
		Pagos pagos = CarteraDto.getPagos();
		Date FechaVenta = CarteraDto.getFechaVenta();
		Date FechaPago = CarteraDto.getFechaPago();
		Double Saldo = ventas.getTotalVenta()-pagos.getValorPago();
		
		if(clientes != null) {
			Cartera.setClientes(clientes);;
		}
		if(ventas!= null) {
			Cartera.setVentas(ventas);;
		}
		if(pagos != null) {
			Cartera.setPagos(pagos);;
		}
		if(FechaVenta != null) {
			Cartera.setFechaVenta(FechaVenta);
		}
		if(FechaPago != null) {
			Cartera.setFechaPago(FechaPago);
		}
		if(Saldo != null) {
			Cartera.setSaldo(Saldo);
		}
		iCartera.save(Cartera);
	}

	@Override
	public CarteraDto buscarCarteraPorFechaPago(Date FechaPago) {
		Cartera Cartera = null;
		try {
			Cartera = iCartera.buscarCarteraporFechapago(FechaPago);
			CarteraDto  CarteraDto = mapCarteraDto(Cartera);
			return CarteraDto;
		} 
		catch (Exception e) {
			return null;
		}
	}


	private CarteraDto mapCarteraDto(Cartera Cartera) {
		return new CarteraDto(
				Cartera.getIDCartera(),
				Cartera.getClientes(),
				Cartera.getVentas(),
				Cartera.getPagos(),
				Cartera.getFechaVenta(),
				Cartera.getFechaPago(),
				Cartera.getSaldo()
						
		);		
	}

	@Override
	public void eliminarCartera(Date FechaPago) {
		
		Cartera Cartera = iCartera.buscarCarteraporFechapago(FechaPago);
		iCartera.delete(Cartera);
		
	}

	@Override
	public void actualizarCartera(Date FechaPago, CarteraDto CarteraDto) {
		Cartera Cartera = iCartera.buscarCarteraporFechapago(FechaPago);
		updateCartera(CarteraDto, Cartera);

	}

	@Override
	public List<Cartera> listaCartera() {
		return (List<Cartera>) iCartera.findAll();
	}

	@Override
	public List<Cartera> listaCarteraCliente(Long IDCliente) {
		// TODO Auto-generated method stub
		
		List<Cartera> lista = new ArrayList<Cartera>();
		
		lista = iCartera.buscarCarteraPorCliente(IDCliente);
		
		
		return (lista) ;
	}

    @Override
	public List<Cartera> listarCarteraFechaVenta(Date FechaVenta) {
		// TODO Auto-generated method stub
		
		List<Cartera> lista = new ArrayList<Cartera>();
		
		lista = iCartera.buscarCarteraPorFechaVenta(FechaVenta);
		
		
		return (lista) ;
	}

	@Override
	public List<Cartera> listarCarteraPorFechaPagoyVenta(Date FechaVenta, Date FechaPago) {
		// TODO Auto-generated method stub
		
		List<Cartera> lista = new ArrayList<Cartera>();
		
		lista = iCartera.buscarCarteraporFechapagoyVenta(FechaVenta, FechaPago);
		
		
		return (lista) ;
	}

	

	    
}
