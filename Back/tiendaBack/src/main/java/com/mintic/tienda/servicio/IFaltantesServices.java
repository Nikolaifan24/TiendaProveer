package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Faltantes;

public interface IFaltantesServices {

    void crearFaltantes(FaltantesDto FaltantesDto); 
    
    List<Faltantes> listaFaltantes() ;
}
