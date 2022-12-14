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
    private Ventas  ventas;

    @ManyToOne
    @JoinColumn(name="IDProducto")
    private Productos productos;

	private int cantidadProducto;

	private Double precioProducto;

	private Double totalDetalle;


    public Detalleventa() {
    }

    public Detalleventa(Long ID, Ventas ventas, Productos productos, int cantidadProducto, Double precioProducto, Double totalDetalle) {
        this.ID = ID;
        this.ventas = ventas;
        this.productos = productos;
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

    public Ventas getVentas() {
        return this.ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
