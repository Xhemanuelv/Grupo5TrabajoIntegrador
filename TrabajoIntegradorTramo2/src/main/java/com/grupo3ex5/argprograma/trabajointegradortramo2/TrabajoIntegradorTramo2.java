package com.grupo3ex5.argprograma.trabajointegradortramo2;

import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.Intermediario;

/**
 *
 * @author Grupo 3 - 5
 */
public class TrabajoIntegradorTramo2 {

    public static void main(String[] args) {
        Intermediario inter = new Intermediario();
        inter.CargaInicial();
        inter.mostrarOrdenesEntreFechas();
    }
}
