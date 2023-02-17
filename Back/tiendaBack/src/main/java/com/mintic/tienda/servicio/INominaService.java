package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.NominaDto;
import com.mintic.tienda.entities.Nomina;

public interface INominaService {

    void crearNomina(NominaDto NominaDto) ;

    List<Nomina> listarNomina(); 

    NominaDto buscarNomina(String nombreVendedor, String FechaInicio, String FechaFinal) ;

    void eliminarNomina(String nombreVendedor, String FechaInicio, String FechaFinal ) ;
    
    void actualizarNomina(String nombreVendedor, String FechaInicio, String FechaFinal, NominaDto NominaDto) ;
}
