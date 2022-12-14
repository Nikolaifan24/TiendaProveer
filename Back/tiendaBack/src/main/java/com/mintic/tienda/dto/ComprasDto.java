package com.mintic.tienda.dto;

import java.util.Date;

public class ComprasDto {
    
    private Long ID;

	private Long IDProveedor;
	
	private Date FechaCompra;

	private Double totalCompra;

    private Double ivaCompra;


    public ComprasDto() {
    }

    public ComprasDto(Long ID, Long IDProveedor, Date FechaCompra, Double totalCompra, Double ivaCompra) {
        this.ID = ID;
        this.IDProveedor = IDProveedor;
        this.FechaCompra = FechaCompra;
        this.totalCompra = totalCompra;
        this.ivaCompra = ivaCompra;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIDProveedor() {
        return this.IDProveedor;
    }

    public void setIDProveedor(Long IDProveedor) {
        this.IDProveedor = IDProveedor;
    }

    public Date getFechaCompra() {
        return this.FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
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
