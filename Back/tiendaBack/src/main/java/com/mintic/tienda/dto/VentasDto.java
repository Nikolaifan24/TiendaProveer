package com.mintic.tienda.dto;

import java.util.Date;

public class VentasDto {
	
	private Long ID;

	private Long IDCliente;
	
	private Long IDVendedor;

	private Long IDProducto;

	private Date FechaVenta;

	private String nombreProducto;
		
	private int Cantidad;
	
	private Double totalVenta;

	private Double ivaVenta;

	private Double valorPago;

	private Double saldo;

	private String formaPago;

	private Date FechaPago;


	public VentasDto() {
	}


	public VentasDto(Long ID, Long IDCliente, Long IDVendedor, Long IDProducto, Date FechaVenta, String nombreProducto, int Cantidad, Double totalVenta, Double ivaVenta, Double valorPago, Double saldo, String formaPago, Date FechaPago) {
		this.ID = ID;
		this.IDCliente = IDCliente;
		this.IDVendedor = IDVendedor;
		this.IDProducto = IDProducto;
		this.FechaVenta = FechaVenta;
		this.nombreProducto = nombreProducto;
		this.Cantidad = Cantidad;
		this.totalVenta = totalVenta;
		this.ivaVenta = ivaVenta;
		this.valorPago = valorPago;
		this.saldo = saldo;
		this.formaPago = formaPago;
		this.FechaPago = FechaPago;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getIDCliente() {
		return this.IDCliente;
	}

	public void setIDCliente(Long IDCliente) {
		this.IDCliente = IDCliente;
	}

	public Long getIDVendedor() {
		return this.IDVendedor;
	}

	public void setIDVendedor(Long IDVendedor) {
		this.IDVendedor = IDVendedor;
	}

	public Long getIDProducto() {
		return this.IDProducto;
	}

	public void setIDProducto(Long IDProducto) {
		this.IDProducto = IDProducto;
	}

	public Date getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(Date FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return this.Cantidad;
	}

	public void setCantidad(int Cantidad) {
		this.Cantidad = Cantidad;
	}

	public Double getTotalVenta() {
		return this.totalVenta;
	}

	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Double getIvaVenta() {
		return this.ivaVenta;
	}

	public void setIvaVenta(Double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public Double getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Date getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(Date FechaPago) {
		this.FechaPago = FechaPago;
	}

	
		
}
