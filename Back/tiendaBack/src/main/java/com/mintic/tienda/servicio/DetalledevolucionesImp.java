package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mintic.tienda.dto.DetalledevolucionesDto;
import com.mintic.tienda.entities.Cartera;
import com.mintic.tienda.entities.Detalledevoluciones;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.repositories.ICartera;
import com.mintic.tienda.repositories.IDetellaDevoluciones;
import com.mintic.tienda.repositories.IDevoluciones;
import com.mintic.tienda.repositories.IProducto;
import com.mintic.tienda.repositories.IDevoluciones;

@Service
public class DetalledevolucionesImp implements IDetalleDevolucionesService{
    @Autowired
	IDetellaDevoluciones iDetalledevoluciones;

	@Autowired
	IProducto iProducto;

	@Autowired
	IDevoluciones iDevoluciones;

	@Autowired
	ICartera iCartera;


	@Override
	public List<Detalledevoluciones> ListarDetalledevoluciones()  {
		return (List<Detalledevoluciones>) iDetalledevoluciones.findAll();
	}

	
	@Override
	public DetalledevolucionesDto buscarDetalledevolucionesCodigoyNombre(Long codigoventa, String nombreProducto)  {
		Detalledevoluciones Detalledevolucioness = null;
		try {
			Detalledevolucioness = iDetalledevoluciones.buscarDetalledevolucionesPorCodigoyNombreProducto(codigoventa, nombreProducto);
			DetalledevolucionesDto DetalledevolucionessDto = mapDetalledevolucionessDto(Detalledevolucioness);
			return DetalledevolucionessDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetalledevolucionesDto mapDetalledevolucionessDto(Detalledevoluciones Detalledevoluciones) {
			return new DetalledevolucionesDto(

					Detalledevoluciones.getID(),
					Detalledevoluciones.getDevoluciones(),
					Detalledevoluciones.getProductos(),
					Detalledevoluciones.getNombreProducto(),
					Detalledevoluciones.getPrecioProducto(),
					Detalledevoluciones.getCantidad(),
					Detalledevoluciones.getValorDevoluciones()
											
			);		
				
	}

	@Override
	public void crearDetalledevolucioness(Long CodigoVenta, DetalledevolucionesDto DetalledevolucionessDto){
		Detalledevoluciones detalle = buildDetalledevolucioness(CodigoVenta, DetalledevolucionessDto);
		Devoluciones devoluciones = detalle.getDevoluciones();
		Productos productos = detalle.getProductos();
		String nombreProducto = detalle.getNombreProducto();
		int repetidos = iDetalledevoluciones.ContadorRepetidos(CodigoVenta, nombreProducto);
		if (repetidos != 0){

		}

		else{
			iDevoluciones.save(devoluciones);
			iDetalledevoluciones.save(detalle);
			iProducto.save(productos);
			CreacionAlternativa(CodigoVenta);
			
		}
		
	}

	private void CreacionAlternativa(Long CodigoVenta){
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(CodigoVenta);
		Double Total= devoluciones.getTotalDevoluciones();
		Double TotalCartera = cartera.getSaldo() - Total;

		if (TotalCartera!= null){
			cartera.setSaldo(TotalCartera);
		}
		iCartera.save(cartera);
	}

	private Detalledevoluciones buildDetalledevolucioness(Long CodigoVenta, DetalledevolucionesDto DetalledevolucionessDto) {
		Detalledevoluciones Detalledevoluciones = new Detalledevoluciones();
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		String nombredelProducto = DetalledevolucionessDto.getNombreProducto();
		Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = DetalledevolucionessDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		Double TotalDevoluciones = devoluciones.getTotalDevoluciones() + totalDetalle;
		// Double TotalCartera = cartera.getSaldo() - TotalDevoluciones;
		Long inventario = productos.getCantidadProducto()- cantidadProducto;


		if (nombredelProducto != null){
			Detalledevoluciones.setNombreProducto(nombredelProducto);
		}
		if (devoluciones != null){
			Detalledevoluciones.setDevoluciones(devoluciones);;
		}
		if (productos != null){
			Detalledevoluciones.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			Detalledevoluciones.setCantidad(cantidadProducto);
		}
		if(precioProducto != null) {
			Detalledevoluciones.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			Detalledevoluciones.setValorDevoluciones(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if (TotalDevoluciones != null){
			devoluciones.setTotalDevoluciones(TotalDevoluciones);
		}
		// if (TotalCartera != null){
		// 	cartera.setSaldo(TotalCartera);
		// }


		return Detalledevoluciones;
		
	}

	@Override
	public void actualizarDetalledevoluciones(Long codigoventa, String nombreProducto, DetalledevolucionesDto detalleDto) {
		// TODO Auto-generated method stub

		Detalledevoluciones detalle = iDetalledevoluciones.buscarDetalledevolucionesPorCodigoyNombreProducto(codigoventa, nombreProducto);
		volvervalor(detalle);
		volvervalorDevoluciones(codigoventa, detalle);
        updateDetalledevoluciones(codigoventa, detalleDto, detalle);
	}

	private void updateDetalledevoluciones (Long CodigoVenta, DetalledevolucionesDto DetalledevolucionessDto, Detalledevoluciones Detalledevoluciones){
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		String nombredelProducto = DetalledevolucionessDto.getNombreProducto();
		Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = DetalledevolucionessDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		Double TotalDevoluciones = devoluciones.getTotalDevoluciones() + totalDetalle;
		Double TotalCartera = cartera.getSaldo() - totalDetalle;
		Long inventario = productos.getCantidadProducto()- cantidadProducto;


		if (nombredelProducto != null){
			Detalledevoluciones.setNombreProducto(nombredelProducto);
		}
		if (devoluciones != null){
			Detalledevoluciones.setDevoluciones(devoluciones);;
		}
		if (productos != null){
			Detalledevoluciones.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			Detalledevoluciones.setCantidad(cantidadProducto);
		}
		if(precioProducto != null) {
			Detalledevoluciones.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			Detalledevoluciones.setValorDevoluciones(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if (TotalDevoluciones != null){
			devoluciones.setTotalDevoluciones(TotalDevoluciones);
			cartera.setSaldo(TotalDevoluciones);
		}
		if (TotalCartera != null){
			cartera.setSaldo(TotalCartera);
		}

		iDevoluciones.save(devoluciones);
		iProducto.save(productos);
        iDetalledevoluciones.save(Detalledevoluciones);
		iCartera.save(cartera);
    } 

	
	
	
	@Override
	public List<Detalledevoluciones> ListarDetalledevolucionessPorCodigo(Long Codigoventa)  {
		
		List<Detalledevoluciones> lista = new ArrayList<Detalledevoluciones>();
		
		lista = iDetalledevoluciones.buscarDetalledevolucionesPorCodigoVenta(Codigoventa);
		
		
		return (lista) ;
	}

	@Override
	public void eliminarDetalledevoluciones(Long codigoVenta, String nombreProdcuto) {
		
		Detalledevoluciones detalle = iDetalledevoluciones.buscarDetalledevolucionesPorCodigoyNombreProducto(codigoVenta, nombreProdcuto);
		volvervalor(detalle);
		volvervalorDevoluciones(codigoVenta, detalle);
		iDetalledevoluciones.delete(detalle);
		
	}
	
	private void volvervalor(Detalledevoluciones detalle){

		String nombreProducto = detalle.getNombreProducto();
		int cantidadProducto = detalle.getCantidad();
		Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Long inventario = productos.getCantidadProducto() + cantidadProducto;
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iProducto.save(productos);
	}
	private void volvervalorDevoluciones(Long CodigoVenta, Detalledevoluciones detalle){
		Double total = detalle.getValorDevoluciones();
		Devoluciones devoluciones = iDevoluciones.buscarDevolucionesPorCodigoVenta(CodigoVenta);
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Double totalDevoluciones = detalle.getDevoluciones().getTotalDevoluciones() - total;
		Double totalCartera = cartera.getSaldo() + total;
		if(totalDevoluciones != null){
			devoluciones.setTotalDevoluciones(totalDevoluciones);
		}
		if(totalCartera != null){
			cartera.setSaldo(totalCartera);
		}
		iCartera.save(cartera);
		iDevoluciones.save(devoluciones);
	}


	@Override
	public int contadorDetalledevoluciones(Long CodigoVenta, String nombreProducto) {
		int contador = iDetalledevoluciones.ContadorRepetidos(CodigoVenta, nombreProducto);
		return contador;
	}
	
}
