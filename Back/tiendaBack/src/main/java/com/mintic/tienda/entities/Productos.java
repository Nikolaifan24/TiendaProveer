package com.mintic.tienda.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Productos.TABLE_NAME)
public class Productos {
	
	public static final String TABLE_NAME = "productos";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDProductos;
	
	@OneToMany(mappedBy="NombreProducto" )
  	private List<Productos> productos;

	@ManyToOne
	@JoinColumn(name="IDProveedor")
	private Long IDProveedor;

	private Long codigoProducto;

	private String nombreProducto;

	private String tipoProducto;
	
	private Double precioCompra;
	
	private Double precioVenta;

	private Long cantidadProducto;


	public Productos() {
	}
	

	public Productos(Long IDProductos, List<Productos> productos, Long IDProveedor, Long codigoProducto, String nombreProducto, String tipoProducto, Double precioCompra, Double precioVenta, Long cantidadProducto) {
		this.IDProductos = IDProductos;
		this.productos = productos;
		this.IDProveedor = IDProveedor;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadProducto = cantidadProducto;
	}

	public Long getIDProductos() {
		return this.IDProductos;
	}

	public void setIDProductos(Long IDProductos) {
		this.IDProductos = IDProductos;
	}

	public List<Productos> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public Long getIDProveedor() {
		return this.IDProveedor;
	}

	public void setIDProveedor(Long IDProveedor) {
		this.IDProveedor = IDProveedor;
	}

	public Long getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Double getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Long getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(Long cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	
}
