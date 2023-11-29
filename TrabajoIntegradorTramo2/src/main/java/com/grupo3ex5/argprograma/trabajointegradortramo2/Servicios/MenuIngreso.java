package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia.DAO;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class MenuIngreso {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menu() {
        System.out.println("hola");
        System.out.println("");
        System.out.println("nuevaorden");
        System.out.println("");
        System.out.println("");
    }

    public void ingresarOrden() {
        Intermediario inter = new Intermediario();
        inter.nuevaOrdenClienteNuevo(ingresoDatoOrden());
    }
    
    public void mostrarOrdenesFechas(){
        
    }

    /*Reemplazado por clase separada*/
    private Orden ingresoDatoOrden() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        DAO<Categoria> categoriaDAO = new DAO<>(Categoria.class);
        Date fecha = new Date();
        String descr = leer.nextLine();
        double costo = leer.nextDouble();
        String estado = "pendiente";
        System.out.println("Ingrese la Fecha yyyy-MM-dd");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = leer.next();
        try {
            fecha = formato.parse(fechaString);
        } catch (Exception e) {
            System.out.println("Fecha ingresada invalida");
            System.out.println("Ingrese la Fecha yyyy-MM-dd");
            fechaString = leer.next();

        }
        /**
         * Realiza busqueda de categoria/tecnico por id si no pida nuevamente
         * los datos
         */
//        System.out.println("Ingrese la id categoria deseada");
//        int id_cat;
//        List<Categoria> categorias = categoriaDAO.obtenerTodos();
        Categoria jopCat = new Categoria(2, "Categoría 2");
        Tecnico jopTec = new Tecnico(1, "Técnico 1");
        //Categoria catEx = categoriaDAO.obtenerTodos().equals(tec);
        // LocalDate date = LocalDate.parse(userInput, dateFormat);

        //Cliente nuevo
        System.out.println("Ingrese los datos del cliente ");
        System.out.println("Ingrese DNI");
        int dni = leer.nextInt();
        System.out.println("Ingrese Domicilio");
        String dom = leer.next();
        System.out.println("Ingrese Correo");
        String email = leer.next();
        System.out.println("Ingrese Nombre");
        String nombre = leer.next();

        Cliente clien = new Cliente(dni, nombre, dom, email);
        return new Orden(descr, costo, fecha, estado, clien, jopTec, jopCat);
    }
}
