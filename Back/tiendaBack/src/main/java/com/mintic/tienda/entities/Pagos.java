package com.mintic.tienda.entities;

import java.util.Date;
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
@Table(name = Pagos.TABLE_NAME)

public class Pagos {

	public static final String TABLE_NAME = "pagos";
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDPagos;

    @OneToMany(mappedBy = "pagos")
    private List<Pagos> pagos;
	
	@ManyToOne
    @JoinColumn(name="IDCliente")
    private Long IDClientes;

    
	@ManyToOne
    @JoinColumn(name="IDIVenta")
    private Long IDVenta;

	private Date FechaVenta;

	private Date FechaPago;

	private String TipoPago;

	private String MedioPago;

	private Double ValorPago;


    public Pagos() {
    }

    public Pagos(Long IDPagos, List<Pagos> pagos, Long IDClientes, Long IDVenta, Date FechaVenta, Date FechaPago, String TipoPago, String MedioPago, Double ValorPago) {
        this.IDPagos = IDPagos;
        this.pagos = pagos;
        this.IDClientes = IDClientes;
        this.IDVenta = IDVenta;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.TipoPago = TipoPago;
        this.MedioPago = MedioPago;
        this.ValorPago = ValorPago;
    }

    public Long getIDPagos() {
        return this.IDPagos;
    }

    public void setIDPagos(Long IDPagos) {
        this.IDPagos = IDPagos;
    }

    public List<Pagos> getPagos() {
        return this.pagos;
    }

    public void setPagos(List<Pagos> pagos) {
        this.pagos = pagos;
    }

    public Long getIDClientes() {
        return this.IDClientes;
    }

    public void setIDClientes(Long IDClientes) {
        this.IDClientes = IDClientes;
    }

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
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

    public String getMedioPago() {
        return this.MedioPago;
    }

    public void setMedioPago(String MedioPago) {
        this.MedioPago = MedioPago;
    }

    public Double getValorPago() {
        return this.ValorPago;
    }

    public void setValorPago(Double ValorPago) {
        this.ValorPago = ValorPago;
    }

        
}
