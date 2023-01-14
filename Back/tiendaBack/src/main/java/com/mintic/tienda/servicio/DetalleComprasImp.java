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
		iDetallecompras.save(buildDetallecompras(CodigoCompra, DetallecomprasDto));
		
	}

	private Detallecompra buildDetallecompras(Long CodigoCompra, DetallecompraDto DetallecomprasDto) {
		Detallecompra Detallecompra = new Detallecompra();
		
		// Long id = DetallecomprasDto.getID();
		// Long idVenta = DetallecomprasDto.getIDVenta();
		// Long idProducto = DetallecomprasDto.getIDProducto();
		String nombreProducto = DetallecomprasDto.getNombreProducto();
        Compras compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
        Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Double valorunitario = DetallecomprasDto.getValorUnitario();
		int cantidadProducto = DetallecomprasDto.getCantidadProducto();
		Double valortotal = DetallecomprasDto.getValorTotal();
		Long inventario = productos.getCantidadProducto()- cantidadProducto;

		
			
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
		iProducto.save(productos);
		return Detallecompra;
		
	}

    private void updateDetalleCompra (Long CodigoCompra, DetallecompraDto detalleDto, Detallecompra detalle){
        String nombreProducto = detalleDto.getNombreProducto();
        Compras compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
        Productos productos = iProducto.buscarProductoPorNombre(nombreProducto);
		Double valorunitario = detalleDto.getValorUnitario();
		int cantidadProducto = detalleDto.getCantidadProducto();
		Double valortotal = detalleDto.getValorTotal();
		Long inventario = productos.getCantidadProducto()- cantidadProducto;

		System.out.println("voy aca");
			
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

		iProducto.save(productos);
        iDetallecompras.save(detalle);
    }
	
    @Override
    public void actualizarDetalleCompra(Long codigoCompra, String nombreProducto, DetallecompraDto detalleDto){

        Detallecompra detalle = iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(codigoCompra, nombreProducto);
        updateDetalleCompra(codigoCompra,detalleDto, detalle);
    }

	public List<Detallecompra> encontrarDetallecompraPorNombre(Long codigoCompra){

		List<Detallecompra> lista = new ArrayList<Detallecompra>();
		lista = iDetallecompras.buscarDetalleCompraPorCodigo(codigoCompra);
		return lista;

	}
}
