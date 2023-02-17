package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mintic.tienda.dto.DetallefaltantesDto;
import com.mintic.tienda.entities.Cartera;
import com.mintic.tienda.entities.Detallefaltantes;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.ICartera;
import com.mintic.tienda.repositories.IDetalleFaltantes;
import com.mintic.tienda.repositories.IFaltantes;
import com.mintic.tienda.repositories.IProducto;

@Service
public class DetallefaltantesImp implements IDetalleFaltantesService {

    @Autowired
	IDetalleFaltantes iDetallefaltantes;

	@Autowired
	IProducto iProducto;

	@Autowired
	IFaltantes iFaltantes;

	@Autowired
	ICartera iCartera;


	@Override
	public List<Detallefaltantes> ListarDetallefaltantes()  {
		return (List<Detallefaltantes>) iDetallefaltantes.findAll();
	}

	
	@Override
	public DetallefaltantesDto buscarDetallefaltantesCodigoyNombre(Long codigoventa, String nombreProducto)  {
		Detallefaltantes Detallefaltantess = null;
		try {
			Detallefaltantess = iDetallefaltantes.buscarDetallefaltantesPorCodigoyNombreProducto(codigoventa, nombreProducto);
			DetallefaltantesDto DetallefaltantessDto = mapDetallefaltantessDto(Detallefaltantess);
			return DetallefaltantessDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetallefaltantesDto mapDetallefaltantessDto(Detallefaltantes Detallefaltantes) {
			return new DetallefaltantesDto(

					Detallefaltantes.getID(),
					Detallefaltantes.getFaltantes(),
					Detallefaltantes.getProductos(),
					Detallefaltantes.getNombreProducto(),
					Detallefaltantes.getPrecioProducto(),
					Detallefaltantes.getCantidad(),
					Detallefaltantes.getTotalDetalle()
											
			);		
				
	}

	@Override
	public void crearDetallefaltantess(Long CodigoVenta, DetallefaltantesDto DetallefaltantessDto){
		Detallefaltantes detalle = buildDetallefaltantess(CodigoVenta, DetallefaltantessDto);
		Faltantes Faltantes = detalle.getFaltantes();
		Productos productos = detalle.getProductos();
		String nombreProducto = detalle.getNombreProducto();
		int repetidos = iDetallefaltantes.ContadorRepetidos(CodigoVenta, nombreProducto);
		if (repetidos != 0){

		}

		else{
			iFaltantes.save(Faltantes);
			iDetallefaltantes.save(detalle);
			iProducto.save(productos);
			CreacionAlternativa(CodigoVenta);
			
		}
		
	}

	private void CreacionAlternativa(Long CodigoVenta){
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(CodigoVenta);
		Double Total= Faltantes.getTotalFaltanes();
		Double TotalCartera = cartera.getSaldo() - Total;

		if (TotalCartera!= null){
			cartera.setSaldo(TotalCartera);
		}
		iCartera.save(cartera);
	}

	private Detallefaltantes buildDetallefaltantess(Long CodigoVenta, DetallefaltantesDto DetallefaltantessDto) {
		Detallefaltantes Detallefaltantes = new Detallefaltantes();
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		String nombredelProducto = DetallefaltantessDto.getNombreProducto();
		Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = DetallefaltantessDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		Double TotalFaltantes = Faltantes.getTotalFaltanes() + totalDetalle;
		// Double TotalCartera = cartera.getSaldo() - TotalFaltantes;
		Long inventario = productos.getCantidadProducto()- cantidadProducto;


		if (nombredelProducto != null){
			Detallefaltantes.setNombreProducto(nombredelProducto);
		}
		if (Faltantes != null){
			Detallefaltantes.setFaltantes(Faltantes);;
		}
		if (productos != null){
			Detallefaltantes.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			Detallefaltantes.setCantidad(cantidadProducto);
		}
		if(precioProducto != null) {
			Detallefaltantes.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			Detallefaltantes.setTotalDetalle(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if (TotalFaltantes != null){
			Faltantes.setTotalFaltanes(TotalFaltantes);
		}
		// if (TotalCartera != null){
		// 	cartera.setSaldo(TotalCartera);
		// }


		return Detallefaltantes;
		
	}

	@Override
	public void actualizarDetallefaltantes(Long codigoventa, String nombreProducto, DetallefaltantesDto detalleDto) {
		// TODO Auto-generated method stub

		Detallefaltantes detalle = iDetallefaltantes.buscarDetallefaltantesPorCodigoyNombreProducto(codigoventa, nombreProducto);
		volvervalor(detalle);
		volvervalorFaltantes(codigoventa, detalle);
        updateDetallefaltantes(codigoventa, detalleDto, detalle);
	}

	private void updateDetallefaltantes (Long CodigoVenta, DetallefaltantesDto DetallefaltantessDto, Detallefaltantes Detallefaltantes){
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		String nombredelProducto = DetallefaltantessDto.getNombreProducto();
		Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = DetallefaltantessDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		Double TotalFaltantes = Faltantes.getTotalFaltanes() + totalDetalle;
		Double TotalCartera = cartera.getSaldo() - totalDetalle;
		Long inventario = productos.getCantidadProducto()- cantidadProducto;


		if (nombredelProducto != null){
			Detallefaltantes.setNombreProducto(nombredelProducto);
		}
		if (Faltantes != null){
			Detallefaltantes.setFaltantes(Faltantes);;
		}
		if (productos != null){
			Detallefaltantes.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			Detallefaltantes.setCantidad(cantidadProducto);
		}
		if(precioProducto != null) {
			Detallefaltantes.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			Detallefaltantes.setTotalDetalle(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if (TotalFaltantes != null){
			Faltantes.setTotalFaltanes(TotalFaltantes);
			cartera.setSaldo(TotalFaltantes);
		}
		if (TotalCartera != null){
			cartera.setSaldo(TotalCartera);
		}

		iFaltantes.save(Faltantes);
		iProducto.save(productos);
        iDetallefaltantes.save(Detallefaltantes);
		iCartera.save(cartera);
    } 

	
	
	
	@Override
	public List<Detallefaltantes> ListarDetallefaltantessPorCodigo(Long Codigoventa)  {
		
		List<Detallefaltantes> lista = new ArrayList<Detallefaltantes>();
		
		lista = iDetallefaltantes.buscarDetallefaltantesPorCodigoVenta(Codigoventa);
		
		
		return (lista) ;
	}

	@Override
	public void eliminarDetallefaltantes(Long codigoVenta, String nombreProdcuto) {
		
		Detallefaltantes detalle = iDetallefaltantes.buscarDetallefaltantesPorCodigoyNombreProducto(codigoVenta, nombreProdcuto);
		volvervalor(detalle);
		volvervalorFaltantes(codigoVenta, detalle);
		iDetallefaltantes.delete(detalle);
		
	}
	
	private void volvervalor(Detallefaltantes detalle){

		String nombreProducto = detalle.getNombreProducto();
		int cantidadProducto = detalle.getCantidad();
		Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Long inventario = productos.getCantidadProducto() + cantidadProducto;
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iProducto.save(productos);
	}
	private void volvervalorFaltantes(Long CodigoVenta, Detallefaltantes detalle){
		Double total = detalle.getTotalDetalle();
		Faltantes Faltantes = iFaltantes.buscarfaltantesPorCodigoVenta(CodigoVenta);
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Double totalFaltantes = detalle.getFaltantes().getTotalFaltanes() - total;
		Double totalCartera = cartera.getSaldo() + total;
		if(totalFaltantes != null){
			Faltantes.setTotalFaltanes(totalFaltantes);
		}
		if(totalCartera != null){
			cartera.setSaldo(totalCartera);
		}
		iCartera.save(cartera);
		iFaltantes.save(Faltantes);
	}


	@Override
	public int contadorDetallefaltantes(Long CodigoVenta, String nombreProducto) {
		int contador = iDetallefaltantes.ContadorRepetidos(CodigoVenta, nombreProducto);
		return contador;
	}
    
}
