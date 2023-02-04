package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetallecompraDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Compras;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detallecompra;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.ICompras;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleCompra;
import com.mintic.tienda.repositories.IProducto;

@Service
public class DetalleComprasImp implements IDetalleComprasService {

    @Autowired
	IDetalleCompra iDetallecompras;

    @Autowired
	IProducto iProducto;

	@Autowired
	ICompras iCompras;

	@Override
	public List<Detallecompra> ListarDetalleCompras() {
		return (List<Detallecompra>) iDetallecompras.findAll();
	}

	@Override
	public DetallecompraDto buscarDetallecompraCodigoyNombre(Long codigoCompra, String nombreProducto) {
		Detallecompra Detallecompras = null;
		try {
			Detallecompras = iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(codigoCompra, nombreProducto);
			DetallecompraDto DetallecomprasDto = mapDetallecomprasDto(Detallecompras);
			return DetallecomprasDto;
		} catch (Exception e) {
			throw e;
			
		}
	}

	private DetallecompraDto mapDetallecomprasDto(Detallecompra Detallecompras) {
			return new DetallecompraDto(
					Detallecompras.getIDDetalleCompra(),
					Detallecompras.getCompras(),
					Detallecompras.getProductos(),
					Detallecompras.getNombreProducto(),
					Detallecompras.getValorUnitario(),
					Detallecompras.getCantidadProducto(),
					Detallecompras.getValorTotal()
										
			);		
				
	}

	@Override
	public void crearDetallecompras(Long CodigoCompra,DetallecompraDto DetallecomprasDto) {
		// Detallecompra Detallecompra = new Detallecompra();
		Detallecompra Detallecompra = buildDetallecompras(CodigoCompra, DetallecomprasDto);
		Compras compras = Detallecompra.getCompras();
		Productos productos =Detallecompra.getProductos();
		String nombredelProducto = Detallecompra.getNombreProducto();
		int repetidos = iDetallecompras.ContadorRepetidosCompra(CodigoCompra, nombredelProducto);
		System.out.println("este es el total de repetidos"+ repetidos);
		if (repetidos != 0){
			System.out.println("esta repetido un detalle por favor rectificar");
		}
		// while(Detallecompra.getCompras() != detallecompra2.getCompras()) {
			else{
				iCompras.save(compras);
				iProducto.save(productos);
				iDetallecompras.save(Detallecompra);
			}
			
		
	}

	private Detallecompra buildDetallecompras(Long CodigoCompra, DetallecompraDto DetallecomprasDto) {
		Detallecompra Detallecompra = new Detallecompra();
		
		// Long id = DetallecomprasDto.getID();
		// Long idVenta = DetallecomprasDto.getIDVenta();
		// Long idProducto = DetallecomprasDto.getIDProducto();
		String nombreProducto = DetallecomprasDto.getNombreProducto();
        Compras compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
        Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Double valorunitario = productos.getPrecioCompra();
		int cantidadProducto = DetallecomprasDto.getCantidadProducto();
		Double valortotal = valorunitario * cantidadProducto;
		Long inventario = productos.getCantidadProducto()+ cantidadProducto;
		Double TotalCompra = compras.getTotalCompra() + valortotal;
		// Detallecompra detallerepetido= iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(CodigoCompra, nombreProducto);
		// int repetidos = iDetallecompras.ContadorRepetidosCompra(CodigoCompra, nombreProducto);
		// System.out.println("este es el total de repetidos"+ repetidos);
			

		if(compras != null) {
			Detallecompra.setCompras(compras);
		}
		if(productos != null) {
			Detallecompra.setProductos(productos);
		}
		if(nombreProducto != null) {
			Detallecompra.setNombreProducto(nombreProducto);
		}
		if(valorunitario != null) {
			Detallecompra.setValorUnitario(valorunitario);
		}
		if(cantidadProducto != 0) {
			Detallecompra.setCantidadProducto(cantidadProducto);
		}
		if(valortotal != null) {
			Detallecompra.setValorTotal(valortotal);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		if(TotalCompra != null) {
			compras.setTotalCompra(TotalCompra);
		}	

		// if(detallerepetido == Detallecompra){

		// 	System.out.println("El detalle ya fue creado");
		// }
		
				
		return Detallecompra;
		
	}

    private void updateDetalleCompra (Long CodigoCompra, DetallecompraDto detalleDto, Detallecompra detalle){
        String nombreProducto = detalleDto.getNombreProducto();
        Compras compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
        Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Double valorunitario = productos.getPrecioCompra();
		int cantidadProducto = detalleDto.getCantidadProducto();
		Double valortotal = valorunitario * cantidadProducto;
		Long inventario = productos.getCantidadProducto()+ cantidadProducto;
		Double TotalCompra = compras.getTotalCompra() + valortotal;

		// System.out.println("voy aca");
			
		if(compras != null) {
			detalle.setCompras(compras);
		}
		if(productos != null) {
			detalle.setProductos(productos);
        }
		if(nombreProducto != null) {
			detalle.setNombreProducto(nombreProducto);
		}
		if(valorunitario != null) {
			detalle.setValorUnitario(valorunitario);
		}
		if(cantidadProducto != 0) {
			detalle.setCantidadProducto(cantidadProducto);
		}
		if(valortotal != null) {
			detalle.setValorTotal(valortotal);
		}
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
			
        }
		if(TotalCompra != null) {
			compras.setTotalCompra(TotalCompra);
		}	
		iCompras.save(compras);
		iProducto.save(productos);
        iDetallecompras.save(detalle);
    }
	
    @Override
    public void actualizarDetalleCompra(Long codigoCompra, String nombreProducto, DetallecompraDto detalleDto){

        Detallecompra detalle = iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(codigoCompra, nombreProducto);
		volvervalor(detalle);
		volvervalorCompra(codigoCompra, detalle);
        updateDetalleCompra(codigoCompra,detalleDto, detalle);
    }

	public List<Detallecompra> encontrarDetallecompraPorNombre(Long codigoCompra){

		List<Detallecompra> lista = new ArrayList<Detallecompra>();
		lista = iDetallecompras.buscarDetalleCompraPorCodigo(codigoCompra);
		return lista;

	}

	@Override
	public void eliminarDetalleCompra(Long codigoCompra, String nombreProdcuto) {
		
		Detallecompra detalle = iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(codigoCompra, nombreProdcuto);
		volvervalor(detalle);
		volvervalorCompra(codigoCompra, detalle);
		iDetallecompras.delete(detalle);
		
	}
	private void volvervalor(Detallecompra detalle){

		String nombreProducto = detalle.getNombreProducto();
		int cantidadProducto = detalle.getCantidadProducto();
		Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Long inventario = productos.getCantidadProducto()- cantidadProducto;
		if(inventario != null) {
			productos.setCantidadProducto(inventario);
		}
		iProducto.save(productos);
	}
	private void volvervalorCompra(Long CodigoCompra, Detallecompra detalle){
		Double total = detalle.getValorTotal();
		Compras compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
		Double totalCompra = detalle.getCompras().getTotalCompra() - total;
		if(totalCompra != null){
			compras.setTotalCompra(totalCompra);
		}
		iCompras.save(compras);
	}
}
