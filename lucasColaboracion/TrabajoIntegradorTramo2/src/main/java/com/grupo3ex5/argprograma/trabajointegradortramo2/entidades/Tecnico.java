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
