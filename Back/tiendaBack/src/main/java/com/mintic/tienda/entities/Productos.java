package com.mintic.tienda.entities;

import java.util.List;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Productos.TABLE_NAME)
public class Productos {
	
	public static final String TABLE_NAME = "productos";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDProductos;
	
	@JsonIgnore
	@OneToMany(mappedBy="productos" )
  	private List<Detalleventa> detalleventas;

	@JsonIgnore
	@OneToMany(mappedBy="productos" )
  	private List<Detallecompra> detallecompras;

	@ManyToOne
	@JoinColumn(name="IDProveedor")
	private Proveedores proveedores;

	@ManyToOne
	@JoinColumn(name="IDCompra")
	private Compras compras;

	private Long IDCompras;

	private Long codigoProducto;

	private String nombreProducto;

	private String tipoProducto;
	
	private Double precioCompra;
	
	private Double precioVenta;

	private Long cantidadProducto;

	private Long unidadesVendidas;

	private Long unidadesCompradas;

	private Long devoluciones;


	public Productos() {
	}

	public Productos(Long IDProductos, List<Detalleventa> detalleventas, List<Detallecompra> detallecompras, Proveedores proveedores, Compras compras, Long IDCompras, Long codigoProducto, String nombreProducto, String tipoProducto, Double precioCompra, Double precioVenta, Long cantidadProducto, Long unidadesVendidas, Long unidadesCompradas, Long devoluciones) {
		this.IDProductos = IDProductos;
		this.detalleventas = detalleventas;
		this.detallecompras = detallecompras;
		this.proveedores = proveedores;
		this.compras = compras;
		this.IDCompras = IDCompras;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadProducto = cantidadProducto;
		this.unidadesVendidas = unidadesVendidas;
		this.unidadesCompradas = unidadesCompradas;
		this.devoluciones = devoluciones;
	}

	public Long getIDProductos() {
		return this.IDProductos;
	}

	public void setIDProductos(Long IDProductos) {
		this.IDProductos = IDProductos;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public List<Detallecompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<Detallecompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public Proveedores getProveedores() {
		return this.proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public Compras getCompras() {
		return this.compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	public Long getIDCompras() {
		return this.IDCompras;
	}

	public void setIDCompras(Long IDCompras) {
		this.IDCompras = IDCompras;
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

	public Long getUnidadesVendidas() {
		return this.unidadesVendidas;
	}

	public void setUnidadesVendidas(Long unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Long getUnidadesCompradas() {
		return this.unidadesCompradas;
	}

	public void setUnidadesCompradas(Long unidadesCompradas) {
		this.unidadesCompradas = unidadesCompradas;
	}

	public Long getDevoluciones() {
		return this.devoluciones;
	}

	public void setDevoluciones(Long devoluciones) {
		this.devoluciones = devoluciones;
	}


}
