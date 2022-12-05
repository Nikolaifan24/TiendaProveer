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
	private Long IDProveedor;
	
	@OneToMany(mappedBy = "proveedor")
	private List<Productos> productos;
	
	private Long nitProveedor;
	
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String nombreProveedor;
	
	private String telefonoProveedor;


	public Proveedores() {
	}

	public Proveedores(Long IDProveedor, List<Productos> productos, Long nitProveedor, String ciudadProveedor, String direccionProveedor, String nombreProveedor, String telefonoProveedor) {
		this.IDProveedor = IDProveedor;
		this.productos = productos;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	public Long getIDProveedor() {
		return this.IDProveedor;
	}

	public void setIDProveedor(Long IDProveedor) {
		this.IDProveedor = IDProveedor;
	}

	public List<Productos> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public Long getNitProveedor() {
		return this.nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudadProveedor() {
		return this.ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
	

}
