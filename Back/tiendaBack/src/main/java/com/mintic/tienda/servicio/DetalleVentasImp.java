package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.entities.Cartera;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detalleventa;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;
import com.mintic.tienda.repositories.ICartera;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleVenta;
import com.mintic.tienda.repositories.IProducto;
import com.mintic.tienda.repositories.IVenta;

@Service
public class DetalleVentasImp implements IDetalleVentasService{

	@Autowired
	IDetalleVenta iDetalleVentas;

	@Autowired
	IProducto iProducto;

	@Autowired
	IVenta iVenta;

	@Autowired
	ICartera iCartera;


	@Override
	public List<Detalleventa> ListarDetalleventas()  {
		return (List<Detalleventa>) iDetalleVentas.findAll();
	}

	
	@Override
	public DetalleventaDto buscarDetalleventaCodigoyNombre(Long codigoventa, String nombreProducto)  {
		Detalleventa detalleVentas = null;
		try {
			detalleVentas = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoventa, nombreProducto);
			DetalleventaDto detalleVentasDto = mapDetalleVentasDto(detalleVentas);
			return detalleVentasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetalleventaDto mapDetalleVentasDto(Detalleventa detalleVentas) {
			return new DetalleventaDto(
					detalleVentas.getIDDetalle(),
					detalleVentas.getVentas(),
					detalleVentas.getProductos(),
					detalleVentas.getNombreProducto(),
					detalleVentas.getCantidadProducto(),
					detalleVentas.getPrecioProducto(),
					detalleVentas.getTotalDetalle()
										
			);		
				
	}

	@Override
	public void crearDetalleventas(Long CodigoVenta, DetalleventaDto DetalleventasDto){
		Detalleventa detalle = buildDetalleVentas(CodigoVenta, DetalleventasDto);
		Ventas ventas = detalle.getVentas();
		Productos productos = detalle.getProductos();
		String nombreProducto = detalle.getNombreProducto();
		int repetidos = iDetalleVentas.ContadorRepetidosventa(CodigoVenta, nombreProducto);
		if (repetidos != 0){

		}

		else{
			iVenta.save(ventas);
			CreacionAlternativa(CodigoVenta);
			iDetalleVentas.save(detalle);
			iProducto.save(productos);
			
		}
		
	}

	private void CreacionAlternativa(Long CodigoVenta){
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Ventas ventas = iVenta.buscarVentasPorCodigo(CodigoVenta);
		Double TotalVenta = ventas.getTotalVenta();
		if (TotalVenta != null){
			cartera.setSaldo(TotalVenta);
		}
		iCartera.save(cartera);
	}

	private Detalleventa buildDetalleVentas(Long CodigoVenta, DetalleventaDto detalleVentasDto) {
		Detalleventa detalleVenta = new Detalleventa();
		Cartera cartera = new Cartera();
		String nombredelProducto = detalleVentasDto.getNombreProducto();
		Ventas ventas = iVenta.buscarVentasPorCodigo(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = detalleVentasDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		Double TotalVenta = ventas.getTotalVenta() + totalDetalle;
		Long inventario = productos.getCantidadProducto()- cantidadProducto;


		if (nombredelProducto != null){
			detalleVenta.setNombreProducto(nombredelProducto);
		}
		if (ventas != null){
			detalleVenta.setVentas(ventas);
		}
		if (productos != null){
			detalleVenta.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			detalleVenta.setCantidadProducto(cantidadProducto);;
		}
		if(precioProducto != null) {
			detalleVenta.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			detalleVenta.setTotalDetalle(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if (TotalVenta != null){
			ventas.setTotalVenta(TotalVenta);
			cartera.setSaldo(TotalVenta);
		}
		


		return detalleVenta;
		
	}

	@Override
	public void actualizarDetalleventa(Long codigoventa, String nombreProducto, DetalleventaDto detalleDto) {
		// TODO Auto-generated method stub

		Detalleventa detalle = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoventa, nombreProducto);
		volvervalor(detalle);
		volvervalorVenta(codigoventa, detalle);
        updateDetalleventa(codigoventa, detalleDto, detalle);
	}

	private void updateDetalleventa (Long CodigoVenta, DetalleventaDto detalleVentasDto, Detalleventa detalleVenta){
        String nombredelProducto = detalleVentasDto.getNombreProducto();
		Ventas ventas = iVenta.buscarVentasPorCodigo(CodigoVenta);
		Productos productos = iProducto.buscarProductoPorNombre(nombredelProducto);
		int cantidadProducto = detalleVentasDto.getCantidad();
		Double precioProducto = productos.getPrecioVenta();
		Double totalDetalle = cantidadProducto*precioProducto;
		System.out.println("el total de mi detalle es:  "+totalDetalle);
		Long inventario = productos.getCantidadProducto()- cantidadProducto;
		if (nombredelProducto != null){
			detalleVenta.setNombreProducto(nombredelProducto);
		}
		if (ventas != null){
			detalleVenta.setVentas(ventas);
		}
		if (productos != null){
			detalleVenta.setProductos(productos);
		}
		if(cantidadProducto != 0) {
			detalleVenta.setCantidadProducto(cantidadProducto);;
		}
		if(precioProducto != null) {
			detalleVenta.setPrecioProducto(precioProducto);
		}
		if(totalDetalle != null) {
			detalleVenta.setTotalDetalle(totalDetalle);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iVenta.save(ventas);
		iProducto.save(productos);
        iDetalleVentas.save(detalleVenta);
    }

	
	
	
	@Override
	public List<Detalleventa> ListarDetalleventasPorCodigo(Long Codigoventa)  {
		
		List<Detalleventa> lista = new ArrayList<Detalleventa>();
		
		lista = iDetalleVentas.buscarDetalleVentaPorCodigoVenta(Codigoventa);
		
		
		return (lista) ;
	}

	@Override
	public void eliminarDetalleVenta(Long codigoVenta, String nombreProdcuto) {
		
		Detalleventa detalle = iDetalleVentas.buscarDetalleventaPorCodigoyNombreProducto(codigoVenta, nombreProdcuto);
		volvervalor(detalle);
		volvervalorVenta(codigoVenta, detalle);
		iDetalleVentas.delete(detalle);
		
	}
	
	private void volvervalor(Detalleventa detalle){

		String nombreProducto = detalle.getNombreProducto();
		int cantidadProducto = detalle.getCantidadProducto();
		Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Long inventario = productos.getCantidadProducto()- cantidadProducto;
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iProducto.save(productos);
	}
	private void volvervalorVenta(Long CodigoVenta, Detalleventa detalle){
		Double total = detalle.getTotalDetalle();
		Ventas ventas = iVenta.buscarVentasPorCodigo(CodigoVenta);
		Cartera cartera = iCartera.buscarCarteraPorCodigoVenta(CodigoVenta);
		Double totalVenta = detalle.getVentas().getTotalVenta() - total;
		if(totalVenta != null){
			ventas.setTotalVenta(totalVenta);
			cartera.setSaldo(totalVenta);
		}
		iCartera.save(cartera);
		iVenta.save(ventas);
	}
	
	
}
