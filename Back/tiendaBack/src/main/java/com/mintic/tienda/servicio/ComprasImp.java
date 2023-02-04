package com.mintic.tienda.servicio;

import java.util.ArrayList;
// import java.util.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.ComprasDto;
import com.mintic.tienda.dto.DetallecompraDto;
// import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Detallecompra;
import com.mintic.tienda.entities.Proveedores;
import com.mintic.tienda.repositories.ICompras;
import com.mintic.tienda.repositories.IDetalleCompra;
import com.mintic.tienda.repositories.IProveedor;

@Service
public class ComprasImp implements IComprasService {
	@Autowired
	public ICompras iCompras;
	IDetalleCompra idetallecompra;
	@Autowired
	IProveedor iProveedor;

	@Override
	public void crearCompras(ComprasDto ComprasDto) {

		Compras compras = buildCompras(ComprasDto);
		Long Codigo = compras.getCodigoCompra();
		int repetidos = iCompras.ContadorRepetidosdeunaCompra(Codigo);
		System.out.println("este es el total de repetidos" + repetidos);
		if (repetidos != 0) {
			System.out.println("esta repetido un detalle por favor rectificar");
			// return 0;
		}
		// while(Detallecompra.getCompras() != detallecompra2.getCompras()) {
		else {
			iCompras.save(buildCompras(ComprasDto));
			// return 1;
		}

	}

	private Compras buildCompras(ComprasDto ComprasDto) {
		Compras Compras = new Compras();
		// Long id = ComprasDto.getID();
		// realizarCalculoCompra(detallecompraDto);
		// ProveedoresDto proveedoresdto = new ProveedoresDto();
		// Long nitProveedor = proveedoresdto.getNitProveedor();
		// Long nit = ComprasDto.getProveedores().getNitProveedor();
		Long nitProveedor = ComprasDto.getNitProveedor();
		Proveedores proveedores = iProveedor.buscarProveedorPorNit(nitProveedor);
		// System.out.println("este es el proveedor " + proveedores);
		Long codigo = ComprasDto.getCodigoCompra();
		String FechaCompra = ComprasDto.getFechaCompra();
		Double totalCompra = cargarCalculosdeCompras(codigo);
		Double ivaCompra = 0.19 * totalCompra;
		// Proveedores proveedores = iProveedor.buscarProveedorPorNit(nitProveedor);
		// System.out.println("el Proveedor es aca" +ivaCompra);
		if (nitProveedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setNitProveedor(nitProveedor);
		}
		if (proveedores != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setProveedores(proveedores);
		}
		if (codigo != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setCodigoCompra(codigo);
		}
		if (FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if (totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if (ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}

		return Compras;
	}

	private void upStringCompras(ComprasDto ComprasDto, Compras Compras) {

		// Compras Compras = new Compras();

		// Proveedores proveedores = ComprasDto.getProveedores();
		Long codigo = ComprasDto.getCodigoCompra();
		String FechaCompra = ComprasDto.getFechaCompra();
		Long nitProveedor = ComprasDto.getNitProveedor();
		Proveedores proveedores = iProveedor.buscarProveedorPorNit(nitProveedor);
		System.out.println("este es el proveedor " + proveedores);
		Double totalCompra = cargarCalculosdeCompras(codigo);
		// System.out.println("El total actualizado es" +totalCompra);
		Double ivaCompra = ComprasDto.getIvaCompra() * totalCompra;

		// if(proveedores != null) {
		// Compras.setProveedores(proveedores);
		// }
		if (nitProveedor != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setNitProveedor(nitProveedor);
		}
		if (codigo != null) {
			// System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
			Compras.setCodigoCompra(codigo);
		}
		if (FechaCompra != null) {
			Compras.setFechaCompra(FechaCompra);
		}
		if (totalCompra != null) {
			Compras.setTotalCompra(totalCompra);
		}
		if (ivaCompra != null) {
			Compras.setIvaCompra(ivaCompra);
		}

		iCompras.save(Compras);
	}

	@Override
	public ComprasDto buscarComprasPorCodigoCompra(Long CodigoCompra) {
		Compras Compras = null;
		try {
			Compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
			ComprasDto ComprasDto = mapComprasDto(Compras);
			return ComprasDto;
		} catch (Exception e) {
			return null;
		}
	}

	private ComprasDto mapComprasDto(Compras Compras) {
		return new ComprasDto(
				Compras.getIDCompras(),
				Compras.getProveedores(),
				Compras.getCodigoCompra(),
				Compras.getFechaCompra(),
				Compras.getNitProveedor(),
				Compras.getTotalCompra(),
				Compras.getIvaCompra()

		);
	}

	@Override
	public void eliminarCompras(Long CodigoCompra) {

		Compras Compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
		iCompras.delete(Compras);

	}

	@Override
	public void actualizarCompras(Long CodigoCompra, ComprasDto ComprasDto) {
		Compras Compras = iCompras.buscarComprasPorCodigo(CodigoCompra);
		upStringCompras(ComprasDto, Compras);

	}

	@Override
	public List<Compras> listaCompras() {
		return (List<Compras>) iCompras.ListarComprasenOrden();
	}

	@Override
	public List<Compras> listaComprasProveedor(String nombreProveedor) {
		// TODO Auto-generated method stub

		List<Compras> lista = new ArrayList<Compras>();

		lista = iCompras.buscarCompraPorNombreProveedor(nombreProveedor);

		return (lista);
	}

	@Override
	public List<Compras> listaComprasPorProductos(String nombreProducto) {
		// TODO Auto-generated method stub

		List<Compras> lista = new ArrayList<Compras>();

		lista = iCompras.buscarCompraPorProductos(nombreProducto);

		return (lista);
	}

	@Override
	public List<Detallecompra> listaComprasPordetalles(Long CodigoCompra) {
		// TODO Auto-generated method stub

		List<Detallecompra> lista = new ArrayList<Detallecompra>();

		lista = idetallecompra.buscarDetalleCompraPorCodigo(CodigoCompra);

		return (lista);
	}

	@Override
	public List<Compras> listarComprasPorProveedor(String nombreProveedor) {
		// TODO Auto-generated method stub

		List<Compras> lista = new ArrayList<Compras>();

		lista = iCompras.buscarCompraPorNombreProveedor(nombreProveedor);

		return (lista);
	}

	@Override
	public DetallecompraDto realizarCalculoCompra(DetallecompraDto detallecompraDto) {

		Double valorunitario = detallecompraDto.getValorUnitario();
		Integer cantidadProducto = detallecompraDto.getCantidadProducto();
		Double valorProductos = valorunitario * cantidadProducto;

		if (cantidadProducto != null) {
			detallecompraDto.setCantidadProducto(cantidadProducto);
		}
		if (valorunitario != null) {
			detallecompraDto.setValorUnitario(valorunitario);
		}
		if (valorProductos != null) {
			detallecompraDto.setValorTotal(valorProductos);
		}

		return detallecompraDto;
	}

	// private void CargarCalculos(ComprasDto ComprasDto, Compras Compras) {

	// // Compras Compras = new Compras();

	// // Proveedores proveedores = ComprasDto.getProveedores();
	// Long codigo = ComprasDto.getCodigoCompra();
	// // String FechaCompra = ComprasDto.getFechaCompra();
	// Double totalCompra = iCompras.TotaldelaCompra(codigo);
	// System.out.println("El total actualizado es" +totalCompra);
	// Double ivaCompra = totalCompra*0.16;

	// // if(proveedores != null) {
	// // Compras.setProveedores(proveedores);
	// // }
	// if(codigo != null) {
	// // System.out.println("voy de nuevo" + proveedores.getCiudadProveedor() );
	// Compras.setCodigoCompra(codigo);
	// }
	// // if(FechaCompra != null) {
	// // Compras.setFechaCompra(FechaCompra);
	// // }
	// if(totalCompra != null) {
	// Compras.setTotalCompra(totalCompra);
	// }
	// if(ivaCompra != null) {
	// Compras.setIvaCompra(ivaCompra);
	// }

	// iCompras.save(Compras);
	// }

	@Override
	public Double cargarCalculosdeCompras(Long CodigoCompra) {
		Double total = iCompras.TotaldelaCompra(CodigoCompra);
		if (total == null) {
			total = 0.0;
		}
		return total;
	}

	@Override
	public int contadordeCompras(Long CodigoCompra) {
		int conteo = iCompras.ContadorRepetidosdeunaCompra(CodigoCompra);
		return conteo;
	}
}
