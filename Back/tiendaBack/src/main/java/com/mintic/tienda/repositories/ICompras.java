package com.mintic.tienda.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Compras;
public interface ICompras extends CrudRepository<Compras, Long>{
    
    @Query(value = "SELECT * from Compras p where p.FechaCompra= :FechaCompra and p.IDProveedor=:IDProveedor", nativeQuery = true)
	List<Compras> buscarComprasPorFechayProveedor(@Param("FechaCompra") Date FechaCompra,
			@Param("IDProveedor") Long IDProveedor);
	
	@Query(value = "SELECT * FROM Compras p where p.FechaCompra=:FechaCompra", nativeQuery = true)
	Compras buscarComprasPorFecha(@Param("FechaCompra") Date FechaCompra);

	@Query(value = "SELECT * FROM Compras p where p.IDProveedor=:IDProveedor", nativeQuery = true)
	List<Compras> buscarComprasPorProveedor(@Param("IDProveedor") Long IDProveedor);
}
