
package com.mintic.tiendafront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;

@Controller
public class Controlador {

	@Autowired
	IClientTienda clienteTienda;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@PostMapping("/login")
	public String login(Model model, LoginDto loginDto) {
		Long validLogin = clienteTienda.login(loginDto);
		System.out.println("El id del usuario es: " + validLogin);
		if (validLogin != 0) {
			return "menu";
		} else {
			model.addAttribute("error", "Usuario o constraseña invalidos.");
			return "index";
		}

	}

	@GetMapping("/usuario")
	public String usuario(Model model) {

		
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuario";
	}

	@PostMapping("/usuario")
	public String crearUsuario(Model model, Usuario usuario) {

		clienteTienda.nuevoUsuario(usuario);
		
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/usuario/{cedulaUsuario}")
	public String actualizarUsuario(Model model, @PathVariable(name = "cedulaUsuario") Long cedulaUsuario) {

		UsuarioResponse usuarioEditar = clienteTienda.buscarUsuario(cedulaUsuario);

		
		model.addAttribute("usuarioEditar", usuarioEditar);
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/eliminarusuario/{cedulaUsuario}")
	public String eliminarUsuario(Model model, @PathVariable(name = "cedulaUsuario") Long cedulaUsuario) {

		clienteTienda.borrarUsuario(cedulaUsuario);
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
			
		return "usuario";
	}
	
	/*
	@GetMapping("/reporte")
	public String reportes() {
		return "reporte";
	}
	*/
	
	
	@GetMapping("/reporteUsuario")
	public String reportesUsuario(Model model) {
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		
		if(model.getAttribute("usuarios") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteUsuario";
	}
	
	
	
	
}
