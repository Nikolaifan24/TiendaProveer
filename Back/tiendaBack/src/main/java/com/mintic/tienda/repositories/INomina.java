package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Nomina;

import java.util.List;

public interface INomina extends CrudRepository<Nomina, Long>{
    
    @Query(value = "SELECT SUM(v.TotalVenta) * From ventas v WHERE v.FechaVenta BETWEEN fechaInicio AND fechaFinal", nativeQuery = true)
    Double SumarVentasenunPeriodoTiempo(@Param("fechaInicio") String FechaInicio,   @Param("fechaFinal") String FechaFinal);

    @Query(value = "SELECT SUM(d.TotalDevoluciones) * From devoluciones d INNER JOIN ventas v ON d.IDVenta = v.IDVenta WHERE v.FechaVenta BETWEEN fechaInicio AND fechaFinal", nativeQuery = true)
    Double SumarDevolucionessenunPeriodoTiempo(@Param("fechaInicio") String FechaInicio,   @Param("fechaFinal") String FechaFinal);

    @Query(value = "SELECT SUM(v.totalFaltantes) * From faltantes f INNER JOIN ventas v ON f.IDVenta = v.IDVenta WHERE v.FechaVenta BETWEEN fechaInicio AND fechaFinal", nativeQuery = true)
    Double SumarFaltantessenunPeriodoTiempo(@Param("fechaInicio") String FechaInicio,   @Param("fechaFinal") String FechaFinal);

    @Query(value = "SELECT * From nomina n WHERE n.nombreVendedor = :nombreVendedor AND n.fechaInicio = :fechaInicio AND n.fechaFinal = :fechaFinal", nativeQuery = true)
    Nomina BuscarunaNomina(@Param("nombreVendedor") String nombreVendedor, @Param("fechaInicio") String FechaInicio,   @Param("fechaFinal") String FechaFinal);

    @Query(value = "SELECT count(*) From nomina n WHERE n.nombreVendedor = :nombreVendedor AND n.fechaInicio = :fechaInicio AND n.fechaFinal = :fechaFinal", nativeQuery = true)
    Integer contadorNomina(@Param("nombreVendedor") String nombreVendedor, @Param("fechaInicio") String FechaInicio,   @Param("fechaFinal") String FechaFinal);

    @Query(value = "SELECT * From nomina n WHERE n.nombreVendedor = :nombreVendedor", nativeQuery = true)
    List<Nomina> ListarNominaPorVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * from nomina n ORDER BY n.fechaFinal DESC", nativeQuery = true)
	List<Nomina> ListarNominasenOrden();

}
