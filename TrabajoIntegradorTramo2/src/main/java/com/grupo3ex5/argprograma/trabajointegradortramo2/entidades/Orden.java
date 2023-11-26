package com.grupo3ex5.argprograma.trabajointegradortramo2.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private int id_orden;

    @Column(name = "descripcion_orden")
    private String descripcion_orden;

    @Column(name = "costo")
    private double costo;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_orden")
    private Date fecha_orden;

    @Column(name = "estado_orden")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_dni")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Orden() {
    }

    public Orden(String descripcion_orden, double costo, Date fecha_orden, String estado, Cliente cliente, Tecnico tecnico, Categoria categoria) {
        this.descripcion_orden = descripcion_orden;
        this.costo = costo;
        this.fecha_orden = fecha_orden;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.categoria = categoria;
    }

    public int getId_orden() {
        return id_orden;
    }

    public String getDescripcion_orden() {
        return descripcion_orden;
    }

    public void setDescripcion_orden(String descripcion_orden) {
        this.descripcion_orden = descripcion_orden;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Orden{" + "id_orden=" + id_orden + ", descripcion_orden=" + descripcion_orden + ", costo=" + costo + ", fecha_orden=" + fecha_orden + ", estado=" + estado + ", dni_cliente=" + cliente.getDni() + ", id_tecnico=" + tecnico.getId_tecnico() + ", id_categoria=" + categoria.getId_categoria() + '}';
    }

}
