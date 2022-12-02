package com.mintic.tienda.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Proveedores.TABLE_NAME)
public class Proveedores {
	public static final String TABLE_NAME = "proveedores";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@OneToMany
	//@JoinColumn(name = "nitProveedor")
	private Long nitProveedor;
	//private List<Productos> productos;
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String nombreProveedor;
	
	private String telefonoProveedor;

	public Proveedores() {
		
	}

	public Proveedores(Long id, Long nitProveedor, String ciudadProveedor, String direccionProveedor,
			String nombreProveedor, String telefonoProveedor) {
		this.id = id;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	
	
	

}
