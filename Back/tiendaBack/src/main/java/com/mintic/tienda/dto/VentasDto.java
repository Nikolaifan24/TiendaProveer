package com.mintic.tienda.dto;

import java.util.Date;

import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Vendedor;

public class VentasDto {
	
	private Long IDVenta;

	private Clientes clientes;
	
	private Vendedor vendedor;

	private Date FechaVenta;

	private Date FechaEntrega;
	
	private Double totalVenta;

	private Double IvaVenta;

	private Double ValorPago;

	private Double Saldo;

	private String FormaPago;
	
	private Date FechaPago;

	private String zonaventa;



	
	public VentasDto() {
	}


	public VentasDto(Long IDVenta, Clientes clientes, Vendedor vendedor, Date FechaVenta, Date FechaEntrega, Double totalVenta, Double IvaVenta, Double ValorPago, Double Saldo, String FormaPago, Date FechaPago, String zonaventa) {
		this.IDVenta = IDVenta;
		this.clientes = clientes;
		this.vendedor = vendedor;
		this.FechaVenta = FechaVenta;
		this.FechaEntrega = FechaEntrega;
		this.totalVenta = totalVenta;
		this.IvaVenta = IvaVenta;
		this.ValorPago = ValorPago;
		this.Saldo = Saldo;
		this.FormaPago = FormaPago;
		this.FechaPago = FechaPago;
		this.zonaventa = zonaventa;
	}

	public Long getIDVenta() {
		return this.IDVenta;
	}

	public void setIDVenta(Long IDVenta) {
		this.IDVenta = IDVenta;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Date getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(Date FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public Date getFechaEntrega() {
		return this.FechaEntrega;
	}

	public void setFechaEntrega(Date FechaEntrega) {
		this.FechaEntrega = FechaEntrega;
	}

	public Double getTotalVenta() {
		return this.totalVenta;
	}

	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Double getIvaVenta() {
		return this.IvaVenta;
	}

	public void setIvaVenta(Double IvaVenta) {
		this.IvaVenta = IvaVenta;
	}

	public Double getValorPago() {
		return this.ValorPago;
	}

	public void setValorPago(Double ValorPago) {
		this.ValorPago = ValorPago;
	}

	public Double getSaldo() {
		return this.Saldo;
	}

	public void setSaldo(Double Saldo) {
		this.Saldo = Saldo;
	}

	public String getFormaPago() {
		return this.FormaPago;
	}

	public void setFormaPago(String FormaPago) {
		this.FormaPago = FormaPago;
	}

	public Date getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(Date FechaPago) {
		this.FechaPago = FechaPago;
	}

	public String getZonaventa() {
		return this.zonaventa;
	}

	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}
	
}
