package com.mintic.tienda.dto;

import java.sql.Date;

public class PagosDto {

    private Long id;

    private Long idClientes;

    private Long idVenta;

	private Date FechaVenta;

	private Date FechaPago;

	private String TipoPago;

	private Double Abono;

	private Double PagoTotal;


	public PagosDto() {
	}


	public PagosDto(Long id, Long idClientes, Long idVenta, Date FechaVenta, Date FechaPago, String TipoPago, Double Abono, Double PagoTotal) {
		this.id = id;
		this.idClientes = idClientes;
		this.idVenta = idVenta;
		this.FechaVenta = FechaVenta;
		this.FechaPago = FechaPago;
		this.TipoPago = TipoPago;
		this.Abono = Abono;
		this.PagoTotal = PagoTotal;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClientes() {
		return this.idClientes;
	}

	public void setIdClientes(Long idClientes) {
		this.idClientes = idClientes;
	}

	public Long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(Date FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public Date getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(Date FechaPago) {
		this.FechaPago = FechaPago;
	}

	public String getTipoPago() {
		return this.TipoPago;
	}

	public void setTipoPago(String TipoPago) {
		this.TipoPago = TipoPago;
	}

	public Double getAbono() {
		return this.Abono;
	}

	public void setAbono(Double Abono) {
		this.Abono = Abono;
	}

	public Double getPagoTotal() {
		return this.PagoTotal;
	}

	public void setPagoTotal(Double PagoTotal) {
		this.PagoTotal = PagoTotal;
	}


}
