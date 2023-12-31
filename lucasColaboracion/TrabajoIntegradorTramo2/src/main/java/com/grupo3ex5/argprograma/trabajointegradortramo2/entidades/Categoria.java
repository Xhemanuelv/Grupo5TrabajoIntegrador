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
    
    /**
     * Solamente usado para poder hacer referencia a un id existente en DB
     * reemplazar con modificacion de DAO para buscar por nombre de tecnico o
     * categoria
     *
     * @param id_categoria
     * @param descripcion_categoria
     */
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
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion_categoria=" + descripcion_categoria + '}';
    }

}
