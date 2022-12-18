package com.mintic.tienda.entities;


import java.util.List;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * aquie se mapea la bd  las tablas de la base de datos son las entidades
 *la entidad se utiliza en los repositorios 
 * */
@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
	public static final String TABLE_NAME = "usuario";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Vendedor> vendedor;

	
    private String usuario;

	private String nombre;

	private String correo;

	private String password;

	private String perfil;


	public Usuario() {
	}


	public Usuario(Long ID, List<Vendedor> vendedor, String usuario, String nombre, String correo, String password, String perfil) {
		this.ID = ID;
		this.vendedor = vendedor;
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

	public List<Vendedor> getvendedor() {
		return this.vendedor;
	}

	public void setvendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
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
