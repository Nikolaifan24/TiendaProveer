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

	Long login(LoginDto usuarioDto);

	List<Usuario> listaUsuarios();
	
	UsuarioDto buscarUsuarioPorNombre(String nombreUsuario);

	Usuario loginUsuario(LoginDto usuario);

	void crearUsuario(UsuarioDto usuarioDto);

	void eliminarUsuario(String nombreUsuario);

	void actualizarUsuario(String nombreUsuario, UsuarioDto usuarioDto);

	

}
