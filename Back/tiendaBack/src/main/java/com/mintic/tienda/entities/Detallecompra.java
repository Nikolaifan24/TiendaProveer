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
	private Long IDDetalleCompra;
	
    @ManyToOne
    @JoinColumn(name="IDCompra")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name="IDProducto")
    private Productos productos;
    
    private Double ValorUnitario;

    private int CantidadProducto;

    private Double ValorTotal;


    public Detallecompra() {
    }


    public Detallecompra(Long IDDetalleCompra, Compras compras, Productos productos, Double ValorUnitario, int CantidadProducto, Double ValorTotal) {
        this.IDDetalleCompra = IDDetalleCompra;
        this.compras = compras;
        this.productos = productos;
        this.ValorUnitario = ValorUnitario;
        this.CantidadProducto = CantidadProducto;
        this.ValorTotal = ValorTotal;
    }

    public Long getIDDetalleCompra() {
        return this.IDDetalleCompra;
    }

    public void setIDDetalleCompra(Long IDDetalleCompra) {
        this.IDDetalleCompra = IDDetalleCompra;
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
        return this.CantidadProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public Double getValorTotal() {
        return this.ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    
}
