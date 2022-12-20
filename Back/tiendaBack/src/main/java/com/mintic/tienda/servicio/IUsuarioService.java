package com.mintic.tienda.servicio;

import java.util.List;

// import org.springframework.http.ResponseEntity;

// import com.mintic.tienda.dto.ClienteDto;
import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuario;


/*
 * Aqui se definen los metodos que se van a utilizar (el contrato)
 * */
public interface IUsuarioService {

	int login(LoginDto usuarioDto);

	List<Usuario> listarUsuarios();
	
	// UsuarioDto buscarUsuarioPorNombre(String nombreUsuario);

	// UsuarioDto buscarUsuarioPorPerfil(String perfil);

	// Usuario loginUsuario(LoginDto usuario);
	UsuarioDto buscarUsuarioPorNombre(String nombreUsuario);

	List<Usuario> listarUsuarioporPerfil(String perfil); 

	void crearUsuario(UsuarioDto usuarioDto);

	void eliminarUsuario(String nombreUsuario);

	void actualizarUsuario(String nombreUsuario, UsuarioDto usuarioDto);

	List<Usuario> encontrarUsuarioPorNombre(String nombreUsuario);

	// void actualizarUsuario(Long nombreUsuario, UsuarioDto usuarioDto);	
	

}
