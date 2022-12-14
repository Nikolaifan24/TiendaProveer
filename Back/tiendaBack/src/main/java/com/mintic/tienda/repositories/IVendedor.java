package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Vendedor;

public interface IVendedor extends CrudRepository<Vendedor, Long>{
    @Query(value = "SELECT * FROM Vendedor  where nombreV=:nombreVendedor", nativeQuery = true)
	Vendedor buscarVendedorPorNombre(@Param("nombreVendedor") String NombreProducto);    
}

