package com.mintic.tiendafront.dto;

public class DetalleCompraDto {
    private Long ID;

    private ComprasResponse compras;
    
    private ProductoResponse productos;

    private String nombreProducto;
 
    private Double ValorUnitario;
 
    private int cantidadProducto;
 
    private Double ValorTotal;


    public DetalleCompraDto() {
    }

    public DetalleCompraDto(Long ID, ComprasResponse compras, ProductoResponse productos, String nombreProducto, Double ValorUnitario, int cantidadProducto, Double ValorTotal) {
        this.ID = ID;
        this.compras = compras;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
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

    public ComprasResponse getCompras() {
        return this.compras;
    }

    public void setCompras(ComprasResponse compras) {
        this.compras = compras;
    }

    public ProductoResponse getProductos() {
        return this.productos;
    }

    public void setProductos(ProductoResponse productos) {
        this.productos = productos;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
