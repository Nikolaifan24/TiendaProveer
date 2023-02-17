package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;

public interface IDevoluciones extends CrudRepository<Devoluciones, Long> {

    @Query(value = "SELECT * FROM devoluciones d INNER JOIN ventas v ON d.IDventa = v.IDventa WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Devoluciones buscarDevolucionesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM Devoluciones d INNER JOIN vendedor v ON d.IDVendedor = v.IDVendedor WHERE v.nombreVendedor = :nombreVendedor", nativeQuery = true)
	List<Devoluciones> buscarDevolucionesPorVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * FROM Devoluciones c INNER JOIN detalle_devoluciones d ON d.IDDevoluciones = c.ID INNER JOIN productos p ON d.IDProducto = p.IDProductos WHERE p.nombreProducto = :nombreProducto", nativeQuery = true)
	List<Productos> buscarDevolucionesPornombreProducto(@Param("nombreProducto") String nombreProducto);

    @Query(value = "SELECT * from devoluciones d ORDER BY d.fechaVenta DESC", nativeQuery = true)
	List<Devoluciones> ListarDevolucionesenOrden();

    @Query(value = "select count(*) from devoluciones d INNER JOIN ventas v ON d.IDventa = v.IDventa WHERE v.CodigoVenta= :CodigoVenta", nativeQuery = true)
	Integer ContadorRepetidosDevoluciones(@Param("CodigoVenta") Long CodigoVenta);
    
    @Query(value = "SELECT SUM(d.valorDevoluciones) FROM detalle_devoluciones d  INNER JOIN devoluciones c on d.IDDevoluciones = c.ID WHERE c.codigoVenta = :CodigoVenta", nativeQuery = true)
	Double TotaldeunaDevolucion(@Param("CodigoVenta") Long CodigoVenta);


}
