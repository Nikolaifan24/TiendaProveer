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

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.LoginDto;
// import com.mintic.tienda.dto.ProveedoresDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuario;
// import com.mintic.tienda.servicio.IClienteService;
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
	public Usuario loginusuario(@RequestBody LoginDto usuario) {
		Usuario responseLogin = iUsuario.loginUsuario(usuario);
		return responseLogin;
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return iUsuario.getUsuarios();
	}
	
	@CrossOrigin(origins = "http://localhost:8091")
	@GetMapping("/usuario/{documentoUsuario}")
	public UsuarioDto buscarUsuarioByNumeroDocumento(@PathVariable Long documentoUsuario) {
		return iUsuario.buscarUsuarioPorCedula(documentoUsuario);
	}
	
	@PostMapping("/usuario")
	public void crearUsuario(@RequestBody UsuarioDto usuarioDto) {
		iUsuario.crearUsuario(usuarioDto);
	}
	
	@DeleteMapping("/usuario/{documentoUsuario}")
	public void eliminarUsuario(@PathVariable Long documentoUsuario) {
		iUsuario.eliminarUsuario(documentoUsuario);
	}
	
	@PatchMapping("/usuario/{documentoUsuario}")
	public void actualizarUsuario(@PathVariable Long documentoUsuario, @RequestBody UsuarioDto usuarioDto) {
		iUsuario.actualizarUsuario(documentoUsuario, usuarioDto);
	}
}
