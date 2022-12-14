package com.mintic.tienda.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Cartera;

public interface ICartera extends CrudRepository<Cartera, Long> {
    @Query(value = "SELECT * from Cartera p where p.FechaVenta= :FechaVenta and p.FechaPago=:FechaPago", nativeQuery = true)
	Cartera buscarCarteraporFechapagoyVenta(@Param("FechaVenta") Date FechaVenta,
			@Param("FechaPago") Date FechaPago);

    @Query(value = "SELECT * from Cartera p where p.FechaPago=:FechaPago", nativeQuery = true)
    Cartera buscarCarteraporFechapago(@Param("FechaPago") Date FechaPago);
	
	@Query(value = "SELECT * FROM Cartera p where p.FechaVenta=:FechaVenta", nativeQuery = true)
	Cartera buscarCarteraPorFechaVenta(@Param("FechaVenta") Date FechaVenta);

    @Query(value = "SELECT * FROM Cartera p where p.IDCliente=:IDCliente", nativeQuery = true)
	Cartera buscarCarteraPorCliente(@Param("IDCliente") Long IDCliente);


    
}
