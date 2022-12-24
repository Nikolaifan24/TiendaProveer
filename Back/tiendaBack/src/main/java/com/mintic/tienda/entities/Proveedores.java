package com.mintic.tienda.entities;

import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = Proveedores.TABLE_NAME)
public class Proveedores {
	public static final String TABLE_NAME = "proveedores";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDProveedor;

	@JsonIgnore
	@OneToMany(mappedBy = "proveedores")
	private List<Compras> compras;

	@JsonIgnore
	@OneToMany(mappedBy = "proveedores")
	private List<Productos> productos;

	private String nombreProveedor;

	private Long nitProveedor;
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String telefonoProveedor;

	private String TipoProducto;


	public Proveedores() {
	}

	public Proveedores(Long IDProveedor, List<Compras> compras, List<Productos> productos, String nombreProveedor, Long nitProveedor, String ciudadProveedor, String direccionProveedor, String telefonoProveedor, String TipoProducto) {
		this.IDProveedor = IDProveedor;
		this.compras = compras;
		this.productos = productos;
		this.nombreProveedor = nombreProveedor;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.TipoProducto = TipoProducto;
	}


	public Long getIDProveedor() {
		return this.IDProveedor;
	}

	public void setIDProveedor(Long IDProveedor) {
		this.IDProveedor = IDProveedor;
	}

	public List<Compras> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}

	public List<Productos> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getTipoProducto() {
		return this.TipoProducto;
	}

	public void setTipoProducto(String TipoProducto) {
		this.TipoProducto = TipoProducto;
	}
	
}
