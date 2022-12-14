package com.mintic.tienda.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Compras;
public interface ICompra extends CrudRepository<Compras, Long>{
    
    @Query(value = "SELECT * from Compras p where p.FechaCompra= :FechaCompra and p.IDProveedor=:IDProveedor", nativeQuery = true)
	Compras buscarComprasPorFechayProveedor(@Param("FechaCompra") Date FechaCompra,
			@Param("IDProveedor") Long IDProveedor);
	
	@Query(value = "SELECT * FROM Compras p where p.FechaCompra=:FechaCompra", nativeQuery = true)
	Compras buscarComprasPorFecha(@Param("FechaCompra") Date FechaCompra);
}
