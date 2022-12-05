package com.mintic.tienda.entities;

import java.util.Date;
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
	
	@ManyToOne
    @JoinColumn(name="IIDCliente")
    private Long IDClientes;

    
	@ManyToOne
    @JoinColumn(name="IIVenta")
    private Long IDVenta;

    private Date FechaVenta;

	private Date FechaPago;

	private String TipoPago;

	private Double Abono;

	private Double PagoTotal;


    public Pagos() {
    }

    public Pagos(Long IDPagos, Long IDClientes, Long IDVenta, Date FechaVenta, Date FechaPago, String TipoPago, Double Abono, Double PagoTotal) {
        this.IDPagos = IDPagos;
        this.IDClientes = IDClientes;
        this.IDVenta = IDVenta;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.TipoPago = TipoPago;
        this.Abono = Abono;
        this.PagoTotal = PagoTotal;
    }

    public Long getIDPagos() {
        return this.IDPagos;
    }

    public void setIDPagos(Long IDPagos) {
        this.IDPagos = IDPagos;
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
