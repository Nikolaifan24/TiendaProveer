package com.mintic.tiendafront.dto;

public class ResultadoVentaDto {
	private Long id;
	private Long codigoVenta;
	private Long idCliente;
	private Long idUsuario;
	private Double ivaVenta;
	private Double totalVenta;
	private Double valorVenta;
	public ResultadoVentaDto() {
		
	}
	public ResultadoVentaDto(Long id, Long codigoVenta, Long idCliente, Long idUsuario, Double ivaVenta,
			Double totalVenta, Double valorVenta) {
		this.id = id;
		this.codigoVenta = codigoVenta;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Double getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(Double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public Double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public Double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(Double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
}
