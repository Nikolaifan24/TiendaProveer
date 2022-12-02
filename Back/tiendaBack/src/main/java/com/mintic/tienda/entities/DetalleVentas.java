package com.mintic.tienda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = DetalleVentas.TABLE_NAME)
public class DetalleVentas {
	
	public static final String TABLE_NAME = "detalle_ventas";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long codigoDetalleVenta;
	
	private Integer cantidadProducto;
	
	//@ManyToOne
	private Long idProducto;
	
	//@ManyToOne
	private Long idVenta;
	
	private Double valorTotal;
	
	private Double valorVenta;
	
	private Double valorIva;

	public DetalleVentas() {
		
	}

	public DetalleVentas(Long id, Long codigoDetalleVenta, Integer cantidadProducto, Long idProducto, Long idVenta,
			Double valorTotal, Double valorVenta, Double valorIva) {
		this.id = id;
		this.codigoDetalleVenta = codigoDetalleVenta;
		this.cantidadProducto = cantidadProducto;
		this.idProducto = idProducto;
		this.idVenta = idVenta;
		this.valorTotal = valorTotal;
		this.valorVenta = valorVenta;
		this.valorIva = valorIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	
	

	

}
