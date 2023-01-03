package com.mintic.tienda.repositories;


// import java.util.String;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Compras;
public interface ICompras extends CrudRepository<Compras, Long>{
    
    @Query(value = "SELECT * from Compras p where p.FechaCompra= :FechaCompra and p.IDProveedor=:IDProveedor", nativeQuery = true)
	List<Compras> buscarComprasPorFechayProveedor(@Param("FechaCompra") String FechaCompra,
			@Param("IDProveedor") Long IDProveedor);
	
	@Query(value = "SELECT * FROM Compras p where p.FechaCompra=:FechaCompra", nativeQuery = true)
	Compras buscarComprasPorFecha(@Param("FechaCompra") String FechaCompra);

	@Query(value = "SELECT * FROM Compras p INNER JOIN Proveedor c ON c.IDProveedor = p.IDProveedor WHERE c.nombreProveedor= :nombreProveedor", nativeQuery = true)
	List<Compras> buscarCompraPorNombreProveedor(@Param("nombreProveedor") String nombreProveedor);

	@Query(value = "SELECT * FROM compras c INNER JOIN detalle_compra d ON c.IDCompras = d.IDCompra INNER JOIN productos p ON d.IDProducto = p.IDProductos WHERE p.nombreProducto = :nombreProducto", nativeQuery = true)
	List<Compras> buscarCompraPorProductos(@Param("nombreProducto") String nombreProducto);
}
