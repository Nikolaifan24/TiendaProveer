package com.mintic.tienda.dto;

// import java.util.String;

import com.mintic.tienda.entities.Proveedores;

public class ComprasDto {
    
    private Long IDCompras;

	private Proveedores proveedores;

    private Long CodigoCompra;
	
	private String FechaCompra;

    private Long nitProveedor;

	private Double totalCompra;

    private Double ivaCompra;


    public ComprasDto() {
    }


    public ComprasDto(Long IDCompras, Proveedores proveedores, Long CodigoCompra, String FechaCompra, Long nitProveedor, Double totalCompra, Double ivaCompra) {
        this.IDCompras = IDCompras;
        this.proveedores = proveedores;
        this.CodigoCompra = CodigoCompra;
        this.FechaCompra = FechaCompra;
        this.nitProveedor = nitProveedor;
        this.totalCompra = totalCompra;
        this.ivaCompra = ivaCompra;
    }

    public Long getIDCompras() {
        return this.IDCompras;
    }

    public void setIDCompras(Long IDCompras) {
        this.IDCompras = IDCompras;
    }

    public Proveedores getProveedores() {
        return this.proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Long getCodigoCompra() {
        return this.CodigoCompra;
    }

    public void setCodigoCompra(Long CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
    }

    public String getFechaCompra() {
        return this.FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public Long getNitProveedor() {
        return this.nitProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Double getTotalCompra() {
        return this.totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Double getIvaCompra() {
        return this.ivaCompra;
    }

    public void setIvaCompra(Double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }
    
    }
