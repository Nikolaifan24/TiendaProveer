package com.mintic.tienda.dto;


public class CarteraDto {
    
    private Long id;

    private Long idClientes;

    private Long idVenta;

	private Double Saldo;


    public CarteraDto() {
    }


    public CarteraDto(Long id, Long idClientes, Long idVenta, Double Saldo) {
        this.id = id;
        this.idClientes = idClientes;
        this.idVenta = idVenta;
        this.Saldo = Saldo;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClientes() {
        return this.idClientes;
    }

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public Long getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }


}
