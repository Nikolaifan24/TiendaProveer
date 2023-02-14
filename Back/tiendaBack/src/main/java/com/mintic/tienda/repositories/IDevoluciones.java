package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Devoluciones;

public interface IDevoluciones extends CrudRepository<Devoluciones, Long> {

    @Query(value = "SELECT * FROM devoluciones d INNER JOIN ventas v ON d.IDventa = v.IDventa WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Devoluciones buscarDevolucionesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM Devoluciones d INNER JOIN vendedor v ON d.IDVendedor = v.IDVendedor WHERE v.nombreVendedor = :nombreVendedor", nativeQuery = true)
	List<Devoluciones> buscarDevolucionesPorVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * from devoluciones d ORDER BY d.fechaVenta DESC", nativeQuery = true)
	List<Devoluciones> ListarDevolucionesenOrden();

    @Query(value = "select count(*) from devoluciones d INNER JOIN ventas v ON d.IDventa = v.IDventa WHERE v.CodigoVenta= :CodigoVenta", nativeQuery = true)
	Integer ContadorRepetidosDevoluciones(@Param("CodigoVenta") Long CodigoVenta);
    
}
