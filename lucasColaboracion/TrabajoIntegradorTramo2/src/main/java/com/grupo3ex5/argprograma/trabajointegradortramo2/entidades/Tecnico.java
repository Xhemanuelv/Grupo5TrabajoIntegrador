package com.grupo3ex5.argprograma.trabajointegradortramo2.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tecnico_id")
    private int id_tecnico;

    @Column(name = "nombre_apellido")
    private String nombreApellido;

    public Tecnico() {
    }

    /**
     * Solamente usado para poder hacer referencia a un id existente en DB
     * reemplazar con modificacion de DAO para buscar por nombre de tecnico o
     * categoria
     *
     * @param id_tecnico
     * @param nombreApellido
     */
    public Tecnico(int id_tecnico, String nombreApellido) {
        this.id_tecnico = id_tecnico;
        this.nombreApellido = nombreApellido;
    }

    public Tecnico(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

}
