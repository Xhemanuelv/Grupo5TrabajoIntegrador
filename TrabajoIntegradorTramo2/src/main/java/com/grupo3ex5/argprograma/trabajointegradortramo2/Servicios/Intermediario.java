package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia.DAO;
import com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia.OrdenDAO;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Intermediario {

    /**
     * Verifica si las tablas existen o estan vacias, de ser asi añade algunos
     * valores
     */
    public void CargaInicial() {

        OrdenDAO ordenDAO = new OrdenDAO();
        DAO<Cliente> clienteDao = new DAO<>(Cliente.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Tecnico> tecnicoDAO = new DAO<>(Tecnico.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Categoria> categoriaDAO = new DAO<>(Categoria.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Orden> ordenGenDAO = new DAO<>(Orden.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");

        // Crear clientes
        Cliente cliente1 = new Cliente(111111, "Cliente 1", "Dirección 1", "cliente1@mail.com");
        Cliente cliente2 = new Cliente(222222, "Cliente 2", "Dirección 2", "cliente2@mail.com");

        // Crear técnicos
        Tecnico tecnico1 = new Tecnico("Técnico 1");
        Tecnico tecnico2 = new Tecnico("Técnico 2");
        Tecnico tecnico3 = new Tecnico("Técnico 3");

        // Crear categorías
        Categoria categoria1 = new Categoria("Categoría 1");
        Categoria categoria2 = new Categoria("Categoría 2");
        Categoria categoria3 = new Categoria("Categoría 3");

        // Crear órdenes
        Orden ordenA = new Orden("Descripcion orden A", 100.0, new Date(), "pendiente", cliente2, tecnico3, categoria3);
        Orden ordenB = new Orden("Descripcion orden B", 150.0, new Date(), "pendiente", cliente2, tecnico2, categoria1);
        Orden ordenC = new Orden("Descripcion orden C", 250.0, new Date(), "pendiente", cliente1, tecnico1, categoria2);

        List<Cliente> clientes = clienteDao.obtenerTodos();
        if (clientes.isEmpty()) {
            //Guardar clientes
            clienteDao.crear(cliente1);
            clienteDao.crear(cliente2);
        } else {
            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }

        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodos();
        if (tecnicos.isEmpty()) {
            // Guardar técnicos
            tecnicoDAO.crear(tecnico1);
            tecnicoDAO.crear(tecnico2);
            tecnicoDAO.crear(tecnico3);
        } else {
            System.out.println("\nTecnicos:");
            for (Tecnico tecnico : tecnicos) {
                System.out.println(tecnico);
            }
        }

        List<Categoria> categorias = categoriaDAO.obtenerTodos();
        if (categorias.isEmpty()) {
            // Guardar categorías
            categoriaDAO.crear(categoria1);
            categoriaDAO.crear(categoria2);
            categoriaDAO.crear(categoria3);
        } else {
            System.out.println("\nCategorias:");
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
        }

        List<Orden> ordenes = ordenGenDAO.obtenerTodos();
        if (ordenes.isEmpty()) {
            // Guardar ordenes
            ordenDAO.crearOrden(ordenA);
            ordenDAO.crearOrden(ordenB);
            ordenDAO.crearOrden(ordenC);
        } else {
            System.out.println("\nOrdenes:");
            for (Orden orden : ordenes) {
                System.out.println(orden);
            }
        }

    }

    /**
     * Muestra todos los datos guardados en BD
     */
    public void mostrarTablas() {
        DAO<Cliente> clienteDAO = new DAO<>(Cliente.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Tecnico> tecnicoDAO = new DAO<>(Tecnico.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Categoria> categoriaDAO = new DAO<>(Categoria.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
        DAO<Orden> genOrdDao = new DAO<>(Orden.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");

        List<Cliente> clientes = clienteDAO.obtenerTodos();
        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodos();
        List<Categoria> categorias = categoriaDAO.obtenerTodos();
        List<Orden> Ordenes = genOrdDao.obtenerTodos();

        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        System.out.println("\nTécnicos:");
        for (Tecnico tecnico : tecnicos) {
            System.out.println(tecnico);
        }
        System.out.println("\nCategorías:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        System.out.println("\nOrdenes:");
        for (Orden orden : Ordenes) {
            System.out.println(orden);
        }
    }

    /**
     * Muestra las ordenes registradas entre 2 fechas, hay que reemplazar los
     * valores harcoded por pedido de ingreso de fechas a usuario
     */
    public void mostrarOrdenesEntreFechas() {
        System.out.println("");
        Date fechaInicial = new Date(123, 10, 24);
        Date fechaLimite = new Date(123, 10, 26);
        List<Orden> ordenesEnFecha = llamarEntreFechas(fechaInicial, fechaLimite);

        if (ordenesEnFecha.isEmpty()) {
            System.out.println("Ocurrio un error al buscar las ordenes en la fecha deseada");
        } else {
            System.out.println("Ordenes entre " + fechaInicial + " y " + fechaLimite);
            for (Orden orden : ordenesEnFecha) {
                System.out.println(orden.getCliente().getNombre() + " " + orden.getTecnico().getNombreApellido() + " " + orden.getFecha_orden() + " " + orden.getCategoria().getDescripcion_categoria());
            }
        }

    }

    /**
     * Funciona el error estaba al formular query
     *
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    private List<Orden> llamarEntreFechas(Date fechaInicio, Date fechaFin) {
        OrdenDAO ordenDAO = new OrdenDAO();
        try {
            return ordenDAO.listarOrdenesEntreFechas(fechaInicio, fechaFin);
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
}
