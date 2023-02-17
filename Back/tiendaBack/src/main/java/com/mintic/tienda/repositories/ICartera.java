package com.mintic.tienda.repositories;



// import java.util.String;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Cartera;

public interface ICartera extends CrudRepository<Cartera, Long> {
    @Query(value = "SELECT * from Cartera p where p.FechaVenta= :FechaVenta and p.FechaPago=:FechaPago", nativeQuery = true)
	List<Cartera> buscarCarteraporFechapagoyVenta(@Param("FechaVenta") String FechaVenta, 	@Param("FechaPago") String FechaPago);

    @Query(value = "SELECT * from Cartera p where p.FechaPago=:FechaPago", nativeQuery = true)
    Cartera buscarCarteraporFechapago(@Param("FechaPago") String FechaPago);
	
	@Query(value = "SELECT * FROM Cartera p where p.FechaVenta=:FechaVenta", nativeQuery = true)
	List<Cartera> buscarCarteraPorFechaVenta(@Param("FechaVenta") String FechaVenta);

    @Query(value = "SELECT * FROM Cartera p where p.IDCliente=:IDCliente", nativeQuery = true)
	List<Cartera> buscarCarteraPorCliente(@Param("IDCliente") Long IDCliente);

	@Query(value = "SELECT * FROM Cartera c INNER JOIN ventas v on c.IDVenta = v.IDVenta WHERE v.CodigoVenta = :codigoventa", nativeQuery = true)
	Cartera buscarCarteraPorCodigoVenta(@Param("codigoventa") Long CodigoVenta);
    
}
