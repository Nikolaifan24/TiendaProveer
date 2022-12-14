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
@Table(name = Detallecompra.TABLE_NAME)

public class Detallecompra {
    
    public static final String TABLE_NAME = "detalle_compra";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDCompra")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name="IDProducto")
    private Productos productos;
    
    private Double ValorUnitario;

    private int cantidadProducto;

    private Double ValorTotal;


    public Detallecompra() {
    }


    public Detallecompra(Long ID, Compras compras, Productos productos, Double ValorUnitario, int cantidadProducto, Double ValorTotal) {
        this.ID = ID;
        this.compras = compras;
        this.productos = productos;
        this.ValorUnitario = ValorUnitario;
        this.cantidadProducto = cantidadProducto;
        this.ValorTotal = ValorTotal;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Compras getCompras() {
        return this.compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Double getValorUnitario() {
        return this.ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public int getCantidadProducto() {
        return this.cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getValorTotal() {
        return this.ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
    

}
