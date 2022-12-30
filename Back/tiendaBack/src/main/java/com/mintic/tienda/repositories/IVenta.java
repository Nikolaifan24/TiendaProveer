package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Ventas;

public interface IVenta extends CrudRepository<Ventas, Long>{

    @Query(value = "SELECT * FROM Ventas c where c.FechaVenta=:FechaVenta", nativeQuery = true)
	Ventas buscarVentaPorfecha(@Param("FechaVenta") String FechaVenta);    

    
}