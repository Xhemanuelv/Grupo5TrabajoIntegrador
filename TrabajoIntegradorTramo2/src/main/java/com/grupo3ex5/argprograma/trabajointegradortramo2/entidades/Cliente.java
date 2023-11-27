package com.grupo3ex5.argprograma.trabajointegradortramo2.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "cliente_dni")
    private int dni;

    @Column(name = "nombre_cliente")
    private String nombre;

    @Column(name = "domicilio")
    private String direccion;

    @Column(name = "correo_electronico")
    private String email;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String direccion, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.dni;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.direccion);
        hash = 71 * hash + Objects.hashCode(this.email);
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
        final Cliente other = (Cliente) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + '}';
    }

}
