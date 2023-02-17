package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;

public interface IFaltantes  extends CrudRepository<Faltantes, Long> {
    
    @Query(value = "SELECT * FROM faltantes f INNER JOIN ventas v ON f.IDventas = v.IDventa WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Faltantes buscarfaltantesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM faltantes f INNER JOIN vendedor v ON f.IDVendedor = v.IDVendedor WHERE v.nombreVendedor = :nombreVendedor", nativeQuery = true)
	List<Faltantes> buscarFaltantesPorVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * FROM faltantes f INNER JOIN detalle_faltantes d ON d.IDfaltantes = f.IDFaltantes INNER JOIN productos p ON d.IDProducto = p.IDProductos WHERE p.nombreProducto = :nombreProducto", nativeQuery = true)
	List<Productos> buscarfaltantesPornombreProducto(@Param("nombreProducto") String nombreProducto);

    @Query(value = "SELECT * from faltantes f ORDER BY f.fechaVenta DESC", nativeQuery = true)
	List<Faltantes> ListarFaltantesenOrden();

    @Query(value = "select count(*) from faltantes f INNER JOIN ventas v ON f.IDventa = v.IDventa WHERE v.CodigoVenta= :CodigoVenta", nativeQuery = true)
	Integer ContadorRepetidosFaltantes(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT SUM(d.totalfaltantes) FROM detalle_faltantes d  INNER JOIN faltantes f on d.IDfaltantes = f.IDFaltantes WHERE c.codigoVenta = :CodigoVenta", nativeQuery = true)
	Double TotaldeunFaltante(@Param("CodigoVenta") Long CodigoVenta);

}
