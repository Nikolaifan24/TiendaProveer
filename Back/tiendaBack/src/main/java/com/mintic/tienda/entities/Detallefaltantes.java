package com.mintic.tienda.entities;

// import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Detallefaltantes.TABLE_NAME)
public class Detallefaltantes {
    public static final String TABLE_NAME ="detalle_faltantes";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDFaltantes")
	private Faltantes faltantes;

    @ManyToOne
    @JoinColumn(name="IDProducto")
	private Productos productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double totalDetalle;


    public Detallefaltantes() {
    }

    public Detallefaltantes(Long ID, Faltantes faltantes, Productos productos, String nombreProducto, Double precioProducto, int Cantidad, Double totalDetalle) {
        this.ID = ID;
        this.faltantes = faltantes;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.Cantidad = Cantidad;
        this.totalDetalle = totalDetalle;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Faltantes getFaltantes() {
        return this.faltantes;
    }

    public void setFaltantes(Faltantes faltantes) {
        this.faltantes = faltantes;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }


    }
