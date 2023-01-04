package com.mintic.tiendafront.dto;

public class UsuarioResponse {	
	
	private Long ID;

	private String usuario;

	private String nombreUsuario;

	private String correo;

	private String password;

	private String perfil;


	public UsuarioResponse() {
	}

	public UsuarioResponse(Long ID, String usuario, String nombreUsuario, String correo, String password, String perfil) {
		this.ID = ID;
		this.usuario = usuario;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.password = password;
		this.perfil = perfil;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
