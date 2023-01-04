package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.UsuarioDto;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.TipoDocumento;

public interface IClientTienda {

	public Long login(LoginDto loginDto);

	public List<UsuarioResponse> getUsuarios();

	public UsuarioResponse nuevoUsuario(UsuarioDto usuarioDto);

	public UsuarioResponse buscarUsuario(Long cedulaUsuario);

	public void borrarUsuario(Long cedulaUsuario);

	
}
