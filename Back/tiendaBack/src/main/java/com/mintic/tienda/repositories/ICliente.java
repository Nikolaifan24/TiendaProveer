package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Clientes;

public interface ICliente extends CrudRepository<Clientes, Long>{
	
	@Query(value = "SELECT * FROM Clientes c where c.cedulaCliente=:cedulaCliente", nativeQuery = true)
	Clientes buscarClientePorCedula(@Param("cedulaCliente") Long cedulaCliente);
}
