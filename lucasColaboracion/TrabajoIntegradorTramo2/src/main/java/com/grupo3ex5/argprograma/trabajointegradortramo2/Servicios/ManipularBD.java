package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.util.Date;
import java.util.List;

public class ManipularBD {

    public void CargaInicial() {

        OrdenDAO ordenDAO = new OrdenDAO();

        // Crear clientes
        Cliente cliente1 = new Cliente(111111, "Cliente 1", "Dirección 1", "cliente1@mail.com");
        Cliente cliente2 = new Cliente(222222, "Cliente 2", "Dirección 2", "cliente2@mail.com");

//        //Guardar clientes
//        DAO<Cliente> clienteDao = new DAO<>(Cliente.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
//
//        clienteDao.crear(cliente1);
//
//        clienteDao.crear(cliente2);
        // Crear técnicos
        Tecnico tecnico1 = new Tecnico("Técnico 1");
        Tecnico tecnico2 = new Tecnico("Técnico 2");
        Tecnico tecnico3 = new Tecnico("Técnico 3");

//        // Guardar técnicos
//        DAO<Tecnico> tecnicoDAO = new DAO<>(Tecnico.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
//
//        tecnicoDAO.crear(tecnico1);
//
//        tecnicoDAO.crear(tecnico2);
//
//        tecnicoDAO.crear(tecnico3);
        // Crear categorías
        Categoria categoria1 = new Categoria("Categoría 1");
        Categoria categoria2 = new Categoria("Categoría 2");
        Categoria categoria3 = new Categoria("Categoría 3");

//        // Guardar categorías
//        DAO<Categoria> categoriaDAO = new DAO<>(Categoria.class, "com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
//
//        categoriaDAO.crear(categoria1);
//
//        categoriaDAO.crear(categoria2);
//
//        categoriaDAO.crear(categoria3);
        // Crear órdenes
        Orden ordenA = new Orden("Descripcion orden A", 100.0, new Date(), "pendiente", cliente2, tecnico3, categoria3);
        Orden ordenB = new Orden("Descripcion orden B", 150.0, new Date(), "pendiente", cliente2, tecnico2, categoria1);
        Orden ordenC = new Orden("Descripcion orden C", 250.0, new Date(), "pendiente", cliente1, tecnico1, categoria2);

        // Guardar datos en la base de datos
//        ordenDAO.crearOrden(ordenA);
//
//        ordenDAO.crearOrden(ordenB);
//
//        ordenDAO.crearOrden(ordenC);
        Categoria jopCat = new Categoria(2, "Categoría 2");
        Tecnico jopTec = new Tecnico(1, "Técnico 1");
        Cliente nuevoCliente = new Cliente(123456789, "Abel", "direccion Abel", "abel@mail.com");
        ordenDAO.crearOrdenView(cliente1, jopTec, jopCat);

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
        clientes.forEach(cliente -> System.out.println(cliente));


        System.out.println("\nTécnicos:");
        tecnicos.forEach(tecnico -> System.out.println(tecnico));


        System.out.println("\nCategorías:");
        categorias.forEach(categoria -> System.out.println(categoria));


        System.out.println("\nÓrdenes:");
        Ordenes.forEach(orden -> System.out.println(orden));

        System.out.println("");
    }
}
