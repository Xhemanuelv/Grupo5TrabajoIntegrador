package com.grupo3ex5.argprograma.trabajointegradortramo2;

import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.DAO;
import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.ManipularBD;
import com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios.OrdenDAO;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class TrabajoIntegradorTramo2 {

    public static void main(String[] args) {
        OrdenDAO ordenDAO = new OrdenDAO();

        /*Cliente cliente1 = new Cliente(111111, "Cliente 1", "Dirección 1", "cliente1@mail.com");
        Tecnico tecnico1 = new Tecnico("Técnico 1");
        Categoria categoria2 = new Categoria("Categoría 2");
        ordenDAO.crearOrdenView(cliente1, tecnico1, categoria2);
         */
 /*   
        ManipularBD modTablas = new ManipularBD();

        modTablas.mostrarTablas();

        modTablas.CargaInicial();
        
        modTablas.mostrarTablas();
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse("2023-10-22", formatter);
        LocalDate localDate2 = LocalDate.parse("2023-11-22", formatter);
        
         // Convertir LocalDate a Date
        Date date1 = java.sql.Date.valueOf(localDate1);
        Date date2 = java.sql.Date.valueOf(localDate2);
        
        List<Orden>listado=ordenDAO.listarOrdenesEntreFechas(date1, date2);
        listado.stream().forEach(X->JOptionPane.showMessageDialog(null, X));
    }

}
