package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuarios;
import com.mintic.tienda.servicio.IClienteService;
import com.mintic.tienda.servicio.IUsuarioService;

@RestController
public class ControladorUsuarios {
	
	@Autowired
	IUsuarioService iUsuario;
	
	UsuarioDto usuarioDto;
	
	@CrossOrigin(origins = "http://localhost:8091")
	@PostMapping("/loginclient")
	public Long login(@RequestBody LoginDto usuario) {
		Long responseLogin = iUsuario.login(usuario);
		return responseLogin;
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@PostMapping("/loginusuario")
	public Usuarios loginusuario(@RequestBody LoginDto usuario) {
		Usuarios responseLogin = iUsuario.loginUsuario(usuario);
		return responseLogin;
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/usuarios")
	public List<Usuarios> listarUsuarios() {
		return iUsuario.getUsuarios();
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/usuario/{cedulaUsuario}")
	public UsuarioDto buscarUsuarioByNumeroDocumento(@PathVariable Long cedulaUsuario) {
		return iUsuario.buscarUsuarioPorCedula(cedulaUsuario);
	}
	
	@PostMapping("/usuario")
	public void crearUsuario(@RequestBody UsuarioDto usuarioDto) {
		iUsuario.crearUsuario(usuarioDto);
	}
	
	@DeleteMapping("/usuario/{cedulaUsuario}")
	public void eliminarUsuario(@PathVariable Long cedulaUsuario) {
		iUsuario.eliminarUsuario(cedulaUsuario);
	}
	
	@PatchMapping("/usuario/{cedulaUsuario}")
	public void actualizarUsuario(@PathVariable Long cedulaUsuario, @RequestBody UsuarioDto usuarioDto) {
		iUsuario.actualizarUsuario(cedulaUsuario, usuarioDto);
	}
}
