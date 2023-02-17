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
@Table(name = Detalledevoluciones.TABLE_NAME)
public class Detalledevoluciones {

    public static final String TABLE_NAME ="detalle_devoluciones";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	// @OneToMany(mappedBy = "compras")
    // private List<Productos> productos;
    @ManyToOne
    @JoinColumn(name="IDDevoluciones")
	private Devoluciones devoluciones;

    @ManyToOne
    @JoinColumn(name="IDProducto")
	private Productos productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double ValorDevoluciones;


    public Detalledevoluciones() {
    }

    public Detalledevoluciones(Long ID, Devoluciones devoluciones, Productos productos, String nombreProducto, Double precioProducto, int Cantidad, Double ValorDevoluciones) {
        this.ID = ID;
        this.devoluciones = devoluciones;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.Cantidad = Cantidad;
        this.ValorDevoluciones = ValorDevoluciones;
    }


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Devoluciones getDevoluciones() {
        return this.devoluciones;
    }

    public void setDevoluciones(Devoluciones devoluciones) {
        this.devoluciones = devoluciones;
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

    public Double getValorDevoluciones() {
        return this.ValorDevoluciones;
    }

    public void setValorDevoluciones(Double ValorDevoluciones) {
        this.ValorDevoluciones = ValorDevoluciones;
    }



   }
