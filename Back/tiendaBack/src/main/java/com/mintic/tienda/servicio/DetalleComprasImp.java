package com.mintic.tienda.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Compras;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Detallecompra;
import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.repositories.IDetalleCompra;

@Service
public class DetalleComprasImp implements IDetalleComprasService {

    @Autowired
	IDetalleCompra iDetallecompras;

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
					Detallecompras.getValorUnitario(),
					Detallecompras.getCantidadProducto(),
					Detallecompras.getValorTotal()
										
			);		
				
	}

	@Override
	public void crearDetallecompras(DetallecompraDto DetallecomprasDto) {
		iDetallecompras.save(buildDetallecompras(DetallecomprasDto));
		
	}

	private Detallecompra buildDetallecompras(DetallecompraDto DetallecomprasDto) {
		Detallecompra Detallecompra = new Detallecompra();
		
		// Long id = DetallecomprasDto.getID();
		// Long idVenta = DetallecomprasDto.getIDVenta();
		// Long idProducto = DetallecomprasDto.getIDProducto();
        Compras compras = DetallecomprasDto.getCompras();
        Productos productos = DetallecomprasDto.getProductos();
        Double valorunitario = DetallecomprasDto.getValorUnitario();
		Integer cantidadProducto = DetallecomprasDto.getCantidadProducto();
		Double valortotal = DetallecomprasDto.getValorTotal();
	
			
		if(compras != null) {
			Detallecompra.setCompras(compras);
		}
		if(productos != null) {
			Detallecompra.getProductos();
        }
		if(valorunitario != null) {
			Detallecompra.getValorUnitario();
		}
		if(cantidadProducto != 0) {
			Detallecompra.setCantidadProducto(0); 
		}
		if(valortotal != null) {
			Detallecompra.setValorTotal(valortotal);
		}
		
		return Detallecompra;
		
	}

    private void updateDetalleCompra (DetallecompraDto detalleDto, Detallecompra detalle){
        Compras compras = detalleDto.getCompras();
        Productos productos = detalleDto.getProductos();
        Double valorunitario = detalleDto.getValorUnitario();
		Integer cantidadProducto = detalleDto.getCantidadProducto();
		Double valortotal = detalleDto.getValorTotal();
	
			
		if(compras != null) {
			detalle.setCompras(compras);
		}
		if(productos != null) {
			detalle.getProductos();
        }
		if(valorunitario != null) {
			detalle.getValorUnitario();
		}
		if(cantidadProducto != 0) {
			detalle.setCantidadProducto(0); 
		}
		if(valortotal != null) {
			detalle.setValorTotal(valortotal);
		}

        iDetallecompras.save(detalle);
    }
	
    @Override
    public void actualizarDetalleCompra(Long codigoCompra, String nombreProducto, DetallecompraDto detalleDto){

        Detallecompra detalle = iDetallecompras.buscarDetalleCompraPorCodigoyNombreProducto(codigoCompra, nombreProducto);
        updateDetalleCompra(detalleDto, detalle);
    }

	public List<Detallecompra> encontrarDetallecompraPorNombre(Long codigoCompra){

		List<Detallecompra> lista = new ArrayList<Detallecompra>();
		lista = iDetallecompras.buscarDetalleCompraPorCodigo(codigoCompra);
		return lista;

	}
}
