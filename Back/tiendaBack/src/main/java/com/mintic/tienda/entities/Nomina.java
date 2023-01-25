package com.mintic.tienda.entities;

// import java.util.String;
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
@Table(name = Nomina.TABLE_NAME)
public class Nomina {
    public static final String TABLE_NAME ="nomina";
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDVentas")
	private Ventas ventas;

    @ManyToOne
    @JoinColumn(name="IDVendedor")
	private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name="IDDevoluciones")
	private Devoluciones devoluciones;

    @ManyToOne
    @JoinColumn(name="IDFaltantes")
	private Faltantes faltantes;

    private String fechaInicio;

    private String fechaFinal;

    private Double TotalDevoluciones;

    private Double TotalFaltantes;

    private Double TotalVentas;

    private Double TotalReal;


    public Nomina() {
    }

    public Nomina(Long ID, Ventas ventas, Vendedor vendedor, Devoluciones devoluciones, Faltantes faltantes, String fechaInicio, String fechaFinal, Double TotalDevoluciones, Double TotalFaltantes, Double TotalVentas, Double TotalReal) {
        this.ID = ID;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.devoluciones = devoluciones;
        this.faltantes = faltantes;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.TotalDevoluciones = TotalDevoluciones;
        this.TotalFaltantes = TotalFaltantes;
        this.TotalVentas = TotalVentas;
        this.TotalReal = TotalReal;
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

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Devoluciones getDevoluciones() {
        return this.devoluciones;
    }

    public void setDevoluciones(Devoluciones devoluciones) {
        this.devoluciones = devoluciones;
    }

    public Faltantes getFaltantes() {
        return this.faltantes;
    }

    public void setFaltantes(Faltantes faltantes) {
        this.faltantes = faltantes;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getTotalDevoluciones() {
        return this.TotalDevoluciones;
    }

    public void setTotalDevoluciones(Double TotalDevoluciones) {
        this.TotalDevoluciones = TotalDevoluciones;
    }

    public Double getTotalFaltantes() {
        return this.TotalFaltantes;
    }

    public void setTotalFaltantes(Double TotalFaltantes) {
        this.TotalFaltantes = TotalFaltantes;
    }

    public Double getTotalVentas() {
        return this.TotalVentas;
    }

    public void setTotalVentas(Double TotalVentas) {
        this.TotalVentas = TotalVentas;
    }

    public Double getTotalReal() {
        return this.TotalReal;
    }

    public void setTotalReal(Double TotalReal) {
        this.TotalReal = TotalReal;
    }

    
}
