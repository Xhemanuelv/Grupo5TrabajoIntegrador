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

    public long getId_tecnico() {
        return id_tecnico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id_tecnico;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tecnico other = (Tecnico) obj;
        return this.id_tecnico == other.id_tecnico;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "id_tecnico=" + id_tecnico + ", nombreApellido=" + nombreApellido + '}';
    }

}
