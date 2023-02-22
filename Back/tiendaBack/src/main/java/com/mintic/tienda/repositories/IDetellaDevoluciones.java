package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Detalledevoluciones;

public interface IDetellaDevoluciones extends CrudRepository<Detalledevoluciones, Long>{

    @Query(value = "SELECT * FROM detalle_devoluciones d INNER JOIN devoluciones c ON d.IDDevoluciones = c.ID WHERE c.CodigoVenta = :CodigoVenta", nativeQuery = true)
	List<Detalledevoluciones> buscarDetalledevolucionesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM detalle_devoluciones d INNER JOIN devoluciones c ON d.IDDevoluciones = c.ID INNER JOIN productos p on d.IDProducto = p.IDProductos WHERE c.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto", nativeQuery = true)
	Detalledevoluciones buscarDetalledevolucionesPorCodigoyNombreProducto(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);

    @Query(value = "select count(*) from detalle_devoluciones d INNER JOIN productos p on d.IDProducto= p.IDProductos INNER JOIN devoluciones v on d.IDDevoluciones = v.ID WHERE v.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto ", nativeQuery = true)
    Integer ContadorRepetidos(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);
    
}
