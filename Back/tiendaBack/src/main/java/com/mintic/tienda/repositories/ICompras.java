package com.mintic.tienda.repositories;

// import java.util.String;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Compras;

public interface ICompras extends CrudRepository<Compras, Long> {

	@Query(value = "SELECT * from Compras p where p.FechaCompra= :FechaCompra and p.IDProveedor=:IDProveedor", nativeQuery = true)
	List<Compras> buscarComprasPorFechayProveedor(@Param("FechaCompra") String FechaCompra,
			@Param("IDProveedor") Long IDProveedor);

	@Query(value = "SELECT * FROM Compras p where p.CodigoCompra=:CodigoCompra", nativeQuery = true)
	Compras buscarComprasPorCodigo(@Param("CodigoCompra") Long CodigoCompra);

	@Query(value = "SELECT * FROM Compras p INNER JOIN Proveedores c ON c.IDProveedor = p.IDProveedor WHERE c.nombreProveedor= :nombreProveedor", nativeQuery = true)
	List<Compras> buscarCompraPorNombreProveedor(@Param("nombreProveedor") String nombreProveedor);

	@Query(value = "SELECT * FROM compras c INNER JOIN detalle_compra d ON c.IDCompras = d.IDCompra INNER JOIN productos p ON d.IDProducto = p.IDProductos WHERE p.nombreProducto = :nombreProducto", nativeQuery = true)
	List<Compras> buscarCompraPorProductos(@Param("nombreProducto") String nombreProducto);

	@Query(value = "SELECT SUM(d.ValorTotal) FROM detalle_compra d  INNER JOIN compras c on d.IDCompra = c.IDCompras WHERE c.CodigoCompra = :CodigoCompra", nativeQuery = true)
	Double TotaldelaCompra(@Param("CodigoCompra") Long CodigoCompra);

	@Query(value = "SELECT * from compras c ORDER BY c.FechaCompra DESC", nativeQuery = true)
	List<Compras> ListarComprasenOrden();

	@Query(value = "select count(*) from compras c WHERE c.CodigoCompra = :CodigoCompra", nativeQuery = true)
	Integer ContadorRepetidosdeunaCompra(@Param("CodigoCompra") Long CodigoCompra);

}
