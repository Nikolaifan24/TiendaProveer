
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
import com.mintic.tiendafront.dto.UsuarioDto;
import com.mintic.tiendafront.dto.UsuarioResponse;

@Controller
public class Controlador {

	@Autowired
	IClientTienda UsuarioTienda;

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
		Long validLogin = UsuarioTienda.login(loginDto);
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

		
		model.addAttribute("usuarios", UsuarioTienda.getUsuarios());
		if(model.getAttribute("usuarios") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}
		return "usuario";
	}

	@PostMapping("/usuario")
	public String crearUsuario(Model model, UsuarioDto usuario) {

		UsuarioTienda.nuevoUsuario(usuario);
		
		model.addAttribute("usuarios", UsuarioTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/usuario/{nombreUsuario}")
	public String actualizarUsuario(Model model, @PathVariable(name = "nombreUsuario") String nombreUsuario) {

		UsuarioResponse usuarioEditar = UsuarioTienda.buscarUsuario(nombreUsuario);

		
		model.addAttribute("usuarioEditar", usuarioEditar);
		model.addAttribute("usuarios", UsuarioTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/eliminarusuario/{nombreUsuario}")
	public String eliminarUsuario(Model model, @PathVariable(name = "nombreUsuario") String nombreUsuario) {

		UsuarioTienda.borrarUsuario(nombreUsuario);
		model.addAttribute("usuarios", UsuarioTienda.getUsuarios());
			
		return "usuario";
	}
	
	/*
	@GetMapping("/reporte")
	public String reportes() {
		return "reporte";
	}
	*/

	@GetMapping("/BuscarUsuario/{nombreUsuario}")
	public String BuscarUsuario(Model model, @PathVariable(name = "nombreUsuario") String nombreUsuario)
	{		
		
		if(ValidacionPorNombre(model, nombreUsuario))
		{	
			UsuarioResponse usuarioEditar = UsuarioTienda.buscarUsuario(nombreUsuario);
			
			if(usuarioEditar == null) {
				model.addAttribute("mensaje", "Usuario Inexistente");
			}
			else {
				model.addAttribute("usuarioEditar", usuarioEditar);
				model.addAttribute("usuarios", UsuarioTienda.getUsuarios());


			}	
		}

		return "usuario";
	}
	
	private boolean ValidacionPorNombre(Model model, String nombreUsuario) 
	{		
		if(nombreUsuario == " ") 
		{
			model.addAttribute("mensaje", "Ingrese el usuario para la busqueda");
			return false;
		}		
		
		return true;
	}

	
	@GetMapping("/reporteUsuario")
	public String reportesUsuario(Model model) {
		model.addAttribute("usuarios", UsuarioTienda.getUsuarios());
		
		if(model.getAttribute("usuarios") == null) 
		{
			model.addAttribute("mensaje", "No hay datos para mostrar");
		}	
		
		return "reporteUsuario";
	}
	
	
	
	
}
