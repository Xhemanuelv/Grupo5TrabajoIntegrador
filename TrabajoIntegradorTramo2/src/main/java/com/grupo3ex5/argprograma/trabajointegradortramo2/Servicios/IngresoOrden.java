package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.awt.HeadlessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class IngresoOrden {

    private Intermediario intmdr = new Intermediario();

    public void ingresarNuevaOrden() {
        JOptionPane.showMessageDialog(null, "Registrando nueva orden:\n~~~~~~~~~~~~~~~~~~~~~~~~");

        String descrOrden = descripcionOrden();
        double costOrd = costoOrden();
        Date fecha = obtenerFecha();
        Cliente clientOrd = ingresoCliente();
        Categoria catOrd = ingresarCategoria();
        Tecnico tecOrd = ingresarTecnico();

        JOptionPane.showMessageDialog(null, "~~~~~~~~~~~~~~~~~~~~~~~~");

        Orden ordenNueva = new Orden(descrOrden, costOrd, fecha, "pendiente", clientOrd, tecOrd, catOrd);
        intmdr.ingresarNuevaOrden(ordenNueva);
    }

    private Cliente ingresoCliente() {
        int id = 0;
        boolean idVal = false;
        JOptionPane.showMessageDialog(null, "Ingreso Cliente:");
        while (!idVal) {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "DNI"));
                idVal = true;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Documento invalido");

            }
        }

        String name = JOptionPane.showInputDialog(null, "Nombre");
        String address = JOptionPane.showInputDialog(null, "Dirección");
        String eAddress = JOptionPane.showInputDialog(null, "E-mail");

        return new Cliente(id, name, address, eAddress);
    }

    private Categoria ingresarCategoria() {
        int id = 0;
        Categoria caOrd = null;
        boolean idVal = false;
        while (!idVal) {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de categoria"));

                caOrd = intmdr.buscarCatPorId(id);
                if (caOrd != null) {
                    idVal = true;
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Id invalido");
                intmdr.mostrarCat();
            }
        }
        return caOrd;
    }

    private Tecnico ingresarTecnico() {
        int id = 0;
        Tecnico tecOrd = null;
        boolean idVal = false;
        while (!idVal) {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de tecnico"));

                tecOrd = intmdr.buscarTecPorId(id);
                if (tecOrd != null) {
                    idVal = true;
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Id invalido");
                intmdr.mostrarCat();
            }
        }
        return tecOrd;

    }

    private Date obtenerFecha() {
        Date fecha = null;
        boolean fechaValida = false;

        while (!fechaValida) {
            String fechaString = JOptionPane.showInputDialog(null, "Ingrese la fecha (dd/MM/yyyy) :");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);

                fecha = sdf.parse(fechaString);
                fechaValida = true; // Si se parsea correctamente, se marca como fecha válida
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato o fecha inválida. Intente de nuevo (Formato: dd/MM/yyyy)");
            }
        }
        return fecha;
    }

    /**
     *
     * @return
     */
    private double costoOrden() {
        double numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            String input = JOptionPane.showInputDialog(null, "Costo de la orden:");

            if (input != null) {
                try {
                    numero = Double.parseDouble(input);
//                    numero = Double.parseDouble(String.format("%.2f", Double.parseDouble(input)));
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número decimal válido.");
                }
            } else {
                // Si se cancela la ventana, se detiene la ejecución del programa
                System.exit(0);
            }
        }

        return numero;
    }

    private String descripcionOrden() {
        String descr = null;
        while (descr == null || descr.isEmpty()) {
            descr = JOptionPane.showInputDialog(null, "Descripcion de la orden:");
            if (descr == null || descr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una descripcion.");
            }
        }

        return descr;
    }
}
