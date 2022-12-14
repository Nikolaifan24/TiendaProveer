package com.mintic.tienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Detalleventa.TABLE_NAME)

public class Detalleventa {

    
    public static final String TABLE_NAME = "detalle_venta";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDVenta")
    private Long IDVenta;


    @ManyToOne
    @JoinColumn(name="IDProducto")
    private Long IDProducto;

	private int cantidadProducto;

	private Double precioProducto;

	private Double totalDetalle;


    public Detalleventa() {
    }

    public Detalleventa(Long ID, Long IDVenta, Long IDProducto, int cantidadProducto, Double precioProducto, Double totalDetalle) {
        this.ID = ID;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.totalDetalle = totalDetalle;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Long getIDProducto() {
        return this.IDProducto;
    }

    public void setIDProducto(Long IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidadProducto() {
        return this.cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }
    
}
