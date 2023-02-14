package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DevolucionesDto;
import com.mintic.tienda.entities.Devoluciones;

public interface IDevolucionesService {
    
    void crearDevoluciones(DevolucionesDto DevolucionesDto); 

    List<Devoluciones> listaDevoluciones(); 
}
