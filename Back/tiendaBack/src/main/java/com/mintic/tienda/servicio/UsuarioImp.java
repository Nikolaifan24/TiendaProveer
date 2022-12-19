
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
	public int login(LoginDto usuarioDto) {
		int u = iUsuario.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return u;
	}
	
	// @Override
	// public Usuario loginUsuario(LoginDto usuarioDto) {
	// 	//return iUsuario.findByNameAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
	// 	return null;
	// }

	@Override
	public List<Usuario> listarUsuarios() {
		return (List<Usuario>) iUsuario.findAll();
	}



	@Override
	public void crearUsuario(UsuarioDto usuarioDto) {
		iUsuario.save(buildUsuario(usuarioDto));
		
	}

	private Usuario buildUsuario(UsuarioDto usuarioDto) {
		Usuario myusuario = new Usuario();
		
		// Long id = usuarioDto.getID();
		String usuario = usuarioDto.getUsuario();
		String nombreUsuario = usuarioDto.getNombreUsuario();
		String emailUsuario = usuarioDto.getCorreo();
		String password = usuarioDto.getPassword();
		String perfil = usuarioDto.getPerfil();
		// myusuario.setID(id);
		
		if(usuario != null) {
			myusuario.setUsuario(usuario);
		}
		if(nombreUsuario != null) {
			myusuario.setNombreUsuario(nombreUsuario);
		}
		if(emailUsuario != null) {
			myusuario.setCorreo(emailUsuario);
		}
		if(password != null) {
			myusuario.setPassword(password);
		}
		if(perfil != null) {
			myusuario.setPerfil(password);
		}
		
		return myusuario;
		
	}
	
	private void updateUsuario(UsuarioDto usuarioDto, Usuario myusuario) {
		
		Long id = usuarioDto.getID();
		String usuario = usuarioDto.getUsuario();
		String nombreUsuario = usuarioDto.getNombreUsuario();
		String emailUsuario = usuarioDto.getCorreo();
		String password = usuarioDto.getPassword();
		String perfil = usuarioDto.getPerfil();
		// myusuario.setIDUsuario(id);
		
		if (id != null) {
			myusuario.setIDUsuario(id);
		}
		if(usuario != null) {
			myusuario.setUsuario(usuario);
		}
		if(nombreUsuario != null) {
			myusuario.setNombreUsuario(nombreUsuario);
		}
		if(emailUsuario != null) {
			myusuario.setCorreo(emailUsuario);
		}
		if(password != null) {
			myusuario.setPassword(password);
		}
		if(perfil != null) {
			myusuario.setPerfil(password);
		}
		iUsuario.save(myusuario);
	}
	

	@Override
	public void eliminarUsuario(String nombreUsuario) {
		Usuario usuario = iUsuario.buscarUsuarioPorNombre(nombreUsuario);
		iUsuario.delete(usuario);
		
	}

	@Override
	public void actualizarUsuario(String nombreUsuario, UsuarioDto usuarioDto) {
		
		Usuario usuario = iUsuario.buscarUsuarioPorNombre(nombreUsuario);
		updateUsuario(usuarioDto, usuario);
		
	}

	@Override
	public UsuarioDto buscarUsuarioPorNombre(String nombreUsuario) {
		Usuario Usuario = null;
		try {
			Usuario = iUsuario.buscarUsuarioPorNombre(nombreUsuario);
			UsuarioDto  UsuarioDto = mapUsuarioDto(Usuario);
			return UsuarioDto;
		} catch (Exception e) {
			return null;
		}
		
	}

	private UsuarioDto mapUsuarioDto(Usuario usuario) {
		return new UsuarioDto(
				usuario.getIDUsuario(),
				usuario.getUsuario(),
				usuario.getNombreUsuario(),
				usuario.getCorreo(),
				usuario.getPassword(),
				usuario.getPerfil()
		);		
	}



	@Override
	public UsuarioDto buscarUsuarioPorPerfil(String perfil) {
		Usuario Usuario = null;
		try {
			Usuario = iUsuario.buscarUsuarioPorPerfil(perfil);
			UsuarioDto  UsuarioDto = mapUsuarioDto(Usuario);
			return UsuarioDto;
		} catch (Exception e) {
			return null;
		}
		
	}



	@Override
	public Usuario loginUsuario(LoginDto usuario) {
		// TODO Auto-generated method stub
		return null;
	}


	
	


}

