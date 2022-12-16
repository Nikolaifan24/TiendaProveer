
package com.mintic.tienda.servicio;

// import java.util.HashMap;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.repositories.IUsuario;

@Service 
public class UsuarioImp implements IUsuarioService {

	
	@Autowired
	IUsuario iUsuario;
	
	@Override
	public Long login(LoginDto usuarioDto) {
		Usuario u = iUsuario.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return u != null ? u.getID() : 0;
	}
	
	@Override
	public Usuario loginUsuario(LoginDto usuarioDto) {
		//return iUsuario.findByNameAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return null;
	}

	@Override
	public List<Usuario> getUsuarios() {

		return (List<Usuario>) iUsuario.findAll();
	}



	@Override
	public void crearUsuario(UsuarioDto usuarioDto) {
		iUsuario.save(buildUsuario(usuarioDto));
		
	}

	private Usuario buildUsuario(UsuarioDto usuarioDto) {
		Usuario myusuario = new Usuario();
		
		Long id = usuarioDto.getID();
		String emailUsuario = usuarioDto.getCorreo();
		String nombreUsuario = usuarioDto.getNombre();
		String password = usuarioDto.getPassword();
		String usuario = usuarioDto.getUsuario();
		myusuario.setID(id);
		
		if(emailUsuario != null) {
			myusuario.setCorreo(emailUsuario);
		}
		if(nombreUsuario != null) {
			myusuario.setNombre(nombreUsuario);;
		}
		if(password != null) {
			myusuario.setPassword(password);
		}
		if(usuario != null) {
			myusuario.setUsuario(usuario);
		}
		return myusuario;
		
	}
	
	private void updateUsuario(UsuarioDto usuarioDto, Usuario myusuario) {
		
		Long id = usuarioDto.getID();
		String emailUsuario = usuarioDto.getCorreo();
		String nombreUsuario = usuarioDto.getNombre();
		String password = usuarioDto.getPassword();
		String usuario = usuarioDto.getUsuario();
		myusuario.setID(id);
		if(emailUsuario != null) {
			myusuario.setCorreo(emailUsuario);
		}
		if(nombreUsuario != null) {
			myusuario.setNombre(nombreUsuario);
		}
		if(password != null) {
			myusuario.setPassword(password);
		}
		if(usuario != null) {
			myusuario.setUsuario(usuario);
		}
		
		iUsuario.save(myusuario);
	}
	

	@Override
	public void eliminarUsuario(Long cedulaUsuario) {
		Usuario usuario = iUsuario.buscarUsuarioPorPerfil(cedulaUsuario);
		iUsuario.delete(usuario);
		
	}

	@Override
	public void actualizarUsuario(Long cedulaUsuario, UsuarioDto usuarioDto) {
		
		Usuario usuario = iUsuario.buscarUsuarioPorPerfil(cedulaUsuario);
		updateUsuario(usuarioDto, usuario);
		
	}

	@Override
	public UsuarioDto buscarUsuarioPorCedula(Long numeroCedula) {
		return null;
	}

	
	
	


}

