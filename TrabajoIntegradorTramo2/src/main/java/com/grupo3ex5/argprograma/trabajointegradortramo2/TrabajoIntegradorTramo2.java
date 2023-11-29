package com.grupo3ex5.argprograma.trabajointegradortramo2;

import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.IngresoOrden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.Intermediario;
import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.MenuIngreso;

/**
 *
 * @author Grupo 3 - 5
 */
public class TrabajoIntegradorTramo2 {

    public static void main(String[] args) {
        Intermediario inter = new Intermediario();
        //inter.mostrarOrdenesEntreFechas();

//        inter.CargaInicial();
//        MenuIngreso mn=new MenuIngreso();
//        mn.ingresarOrden();
        IngresoOrden ingresarOrden = new IngresoOrden();
        ingresarOrden.ingresarNuevaOrden();
    }
}
