
package com.mintic.tienda.servicio;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.Usuarios;
import com.mintic.tienda.repositories.IUsuario;

@Service 
public class UsuarioImp implements IUsuarioService {

	
	@Autowired
	IUsuario iUsuario;
	
	@Override
	public Long login(LoginDto usuarioDto) {
		Usuarios u = iUsuario.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return u != null ? u.getID() : 0;
	}
	
	@Override
	public Usuarios loginUsuario(LoginDto usuarioDto) {
		//return iUsuario.findByNameAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return null;
	}

	@Override
	public List<Usuarios> getUsuarios() {

		return (List<Usuarios>) iUsuario.findAll();
	}



	@Override
	public void crearUsuario(UsuarioDto usuarioDto) {
		iUsuario.save(buildUsuario(usuarioDto));
		
	}

	private Usuarios buildUsuario(UsuarioDto usuarioDto) {
		Usuarios myusuario = new Usuarios();
		
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
	
	private void updateUsuario(UsuarioDto usuarioDto, Usuarios myusuario) {
		
		Long id = usuarioDto.getID();
		String emailUsuario = usuarioDto.getCorreo();
		String nombreUsuario = usuarioDto.getNombre();
		String password = usuarioDto.getPassword();
		String usuario = usuarioDto.getUsuario();
		myusuario.setID(id);
		if(emailUsuario != null) {
			myusuario.setCorreo(emailUsuario);;
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
		Usuarios usuario = iUsuario.buscarUsuarioPorPerfil(cedulaUsuario);
		iUsuario.delete(usuario);
		
	}

	@Override
	public void actualizarUsuario(Long cedulaUsuario, UsuarioDto usuarioDto) {
		
		Usuarios usuario = iUsuario.buscarUsuarioPorPerfil(cedulaUsuario);
		updateUsuario(usuarioDto, usuario);
		
	}

	@Override
	public UsuarioDto buscarUsuarioPorCedula(Long numeroCedula) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	


}

