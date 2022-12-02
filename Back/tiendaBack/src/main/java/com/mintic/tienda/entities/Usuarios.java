package com.mintic.tienda.entities;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*
 * aquie se mapea la bd  las tablas de la base de datos son las entidades
 *la entidad se utiliza en los repositorios 
 * */
@Entity
@Table(name = Usuarios.TABLE_NAME)
public class Usuarios {
	public static final String TABLE_NAME = "usuarios";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@OneToMany
	//@JoinColumn(name = "cedulaUusario")
	//private List<Ventas> ventas;
	
	private Long cedulaUsuario;
	
	private String emailUsuario;

	private String nombreUsuario;

	private String password;

	private String usuario;
	
	public Usuarios() {
		
	}
	

	public Usuarios(Long id, Long cedulaUsuario, String emailUsuario, String nombreUsuario, String password,
			String usuario) {
		this.id = id;
		this.cedulaUsuario = cedulaUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCedulaUsuario() {
		return cedulaUsuario;
	}


	public void setCedulaUsuario(Long cedulaUusario) {
		this.cedulaUsuario = cedulaUusario;
	}


	public String getEmailUsuario() {
		return emailUsuario;
	}


	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
}
