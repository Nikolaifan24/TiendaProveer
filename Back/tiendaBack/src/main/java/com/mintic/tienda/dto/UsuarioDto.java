package com.mintic.tienda.dto;

public class UsuarioDto {
	
	private Long ID;

	private String usuario;

	private String nombre;

	private String correo;

	private String password;

	private String perfil;
	

	public UsuarioDto() {
	}
	

	public UsuarioDto(Long ID, String usuario, String nombre, String correo, String password, String perfil) {
		this.ID = ID;
		this.usuario = usuario;
		this.nombre = nombre;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
