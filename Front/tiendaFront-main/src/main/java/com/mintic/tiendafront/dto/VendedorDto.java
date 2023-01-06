package com.mintic.tiendafront.dto;

public class VendedorDto {

    private Long IDVendedor;

    private UsuarioResponse usuario;
	
	 private Long documentoVendedor;
	
	private String nombreVendedor;
	
	private String direccionVendedor;
	
	private Double telefonoVendedor;
	
	private Float comisionVendedor;

	private String FechaIngreso;

	private Double Salario;


    public VendedorDto() {
    }


    public VendedorDto(Long IDVendedor, UsuarioResponse usuario, Long documentoVendedor, String nombreVendedor, String direccionVendedor, Double telefonoVendedor, Float comisionVendedor, String FechaIngreso, Double Salario) {
        this.IDVendedor = IDVendedor;
        this.usuario = usuario;
        this.documentoVendedor = documentoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.direccionVendedor = direccionVendedor;
        this.telefonoVendedor = telefonoVendedor;
        this.comisionVendedor = comisionVendedor;
        this.FechaIngreso = FechaIngreso;
        this.Salario = Salario;
    }

    public Long getIDVendedor() {
        return this.IDVendedor;
    }

    public void setIDVendedor(Long IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public UsuarioResponse getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioResponse usuario) {
        this.usuario = usuario;
    }

    public Long getDocumentoVendedor() {
        return this.documentoVendedor;
    }

    public void setDocumentoVendedor(Long documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDireccionVendedor() {
        return this.direccionVendedor;
    }

    public void setDireccionVendedor(String direccionVendedor) {
        this.direccionVendedor = direccionVendedor;
    }

    public Double getTelefonoVendedor() {
        return this.telefonoVendedor;
    }

    public void setTelefonoVendedor(Double telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }

    public Float getComisionVendedor() {
        return this.comisionVendedor;
    }

    public void setComisionVendedor(Float comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public String getFechaIngreso() {
        return this.FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public Double getSalario() {
        return this.Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }
    
}
