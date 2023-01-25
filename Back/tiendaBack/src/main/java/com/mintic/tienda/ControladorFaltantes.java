package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.servicio.IFaltantesServices;

@RestController
public class ControladorFaltantes {
    
    @Autowired
	IFaltantesServices iFaltantes;

	@CrossOrigin(origins = "http://localhost:8091")


    @PostMapping("/crearFaltantes")
	public void crearFaltantes(@RequestBody FaltantesDto FaltantesDto) {
		System.out.println("esta es mi faltante");
		iFaltantes.crearFaltantes(FaltantesDto);
	}
    @GetMapping("/Faltanteslistar")
	public List<Faltantes> listaFaltantes() {
		return iFaltantes.listaFaltantes();
	}

}
