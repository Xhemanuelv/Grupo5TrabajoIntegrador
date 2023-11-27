package com.grupo3ex5.argprograma.trabajointegradortramo2.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private int id_categoria;

    @Column(name = "descripcion_categoria")
    private String descripcion_categoria;

    public Categoria() {
    }

    public Categoria(int id_categoria, String descripcion_categoria) {
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }

    public Categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_categoria;
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
        final Categoria other = (Categoria) obj;
        return this.id_categoria == other.id_categoria;
    }
    

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion_categoria=" + descripcion_categoria + '}';
    }

}
