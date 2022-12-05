package com.mintic.tienda.entities;



import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Ventas.TABLE_NAME)
public class Ventas {
	
	public static final String TABLE_NAME = "ventas";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDVenta;

	@OneToMany(mappedBy="persona" )
  	private List<Ventas> ventas;
	
	@ManyToOne
    @JoinColumn(name="IIVendedor")
    private Long IDVendedor;
	
	@ManyToOne
    @JoinColumn(name="IIDCliente")
    private Long IDCliente;

	@ManyToOne
    @JoinColumn(name="IIProducto")
    private Long IDProductos;

	private Date FechaVenta;

	private String nombreProducto;
		
	private int Cantidad;
	
	private Double totalVenta;

	private Double ivaVenta;

	private Double valorPago;

	private Double saldo;

	private String formaPago;

	private Date FechaPago;
	

	public Ventas() {
	}

	public Ventas(Long IDVenta, List<Ventas> ventas, Long IDVendedor, Long IDCliente, Long IDProductos, Date FechaVenta, String nombreProducto, int Cantidad, Double totalVenta, Double ivaVenta, Double valorPago, Double saldo, String formaPago, Date FechaPago) {
		this.IDVenta = IDVenta;
		this.ventas = ventas;
		this.IDVendedor = IDVendedor;
		this.IDCliente = IDCliente;
		this.IDProductos = IDProductos;
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

	public Long getIDVenta() {
		return this.IDVenta;
	}

	public void setIDVenta(Long IDVenta) {
		this.IDVenta = IDVenta;
	}

	public List<Ventas> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}

	public Long getIDVendedor() {
		return this.IDVendedor;
	}

	public void setIDVendedor(Long IDVendedor) {
		this.IDVendedor = IDVendedor;
	}

	public Long getIDCliente() {
		return this.IDCliente;
	}

	public void setIDCliente(Long IDCliente) {
		this.IDCliente = IDCliente;
	}

	public Long getIDProductos() {
		return this.IDProductos;
	}

	public void setIDProductos(Long IDProductos) {
		this.IDProductos = IDProductos;
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
