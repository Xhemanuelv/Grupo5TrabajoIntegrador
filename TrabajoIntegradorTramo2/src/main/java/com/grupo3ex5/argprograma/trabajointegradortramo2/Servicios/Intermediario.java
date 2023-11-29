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

    private OrdenDAO ordenDAO = new OrdenDAO();
    private DAO<Cliente> clienteDao = new DAO<>(Cliente.class);
    private DAO<Tecnico> tecnicoDAO = new DAO<>(Tecnico.class);
    private DAO<Categoria> categoriaDAO = new DAO<>(Categoria.class);
    private DAO<Orden> ordenGenDAO = new DAO<>(Orden.class);

    /**
     * Verifica si las tablas existen o estan vacias, de ser asi añade algunos
     * valores
     */
    /**
     * Quitarle la logica de nueva orden para que salga desde menu ingreso
     */
    public void CargaInicial() {

        OrdenDAO daOrder = new OrdenDAO();

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
        }

        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodos();
        if (tecnicos.isEmpty()) {
            // Guardar técnicos
            tecnicoDAO.crear(tecnico1);
            tecnicoDAO.crear(tecnico2);
            tecnicoDAO.crear(tecnico3);
        }

        List<Categoria> categorias = categoriaDAO.obtenerTodos();
        if (categorias.isEmpty()) {
            // Guardar categorías
            categoriaDAO.crear(categoria1);
            categoriaDAO.crear(categoria2);
            categoriaDAO.crear(categoria3);
        }

        List<Orden> ordenes = ordenGenDAO.obtenerTodos();
        if (ordenes.isEmpty()) {
            // Guardar ordenes
            daOrder.crearOrden(ordenA);
            daOrder.crearOrden(ordenB);
            daOrder.crearOrden(ordenC);
        }
        /**
         * Limpiar listas para ahorrar memoria
         */
        ordenes = null;
        categorias = null;
        tecnicos = null;
        clientes = null;

    }

    /**
     * Muestra todos los datos guardados en BD
     */
    public void mostrarTablas() {
        mostrarClient();
        mostrarCat();
        mostrarTec();
        mostrarOrd();
    }

    /**
     * Muestra las ordenes registradas entre 2 fechas de muestra
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
        ordenesEnFecha = null;
    }

    /**
     * Mismo metodo mostrar entre fechas pero este recibe atributos
     *
     * @param fechaInicial
     * @param fechaReciente
     */
    public void mostrarOrdenesEntreFechas(Date fechaInicial, Date fechaReciente) {
        System.out.println("");
        List<Orden> ordenesEnFecha = llamarEntreFechas(fechaInicial, fechaReciente);

        if (ordenesEnFecha.isEmpty()) {
            System.out.println("Ocurrio un error al buscar las ordenes en la fecha deseada");
        } else {
            System.out.println("Ordenes entre " + fechaInicial + " y " + fechaReciente);
            for (Orden orden : ordenesEnFecha) {
                System.out.println(orden.getCliente().getNombre() + " " + orden.getTecnico().getNombreApellido() + " " + orden.getFecha_orden() + " " + orden.getCategoria().getDescripcion_categoria());
            }
        }
        ordenesEnFecha = null;

    }

    /**
     * Crea una lista de ordenes entre las fechas introducidas
     *
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    private List<Orden> llamarEntreFechas(Date fechaInicio, Date fechaFin) {
        try {
            return ordenDAO.listarOrdenesEntreFechas(fechaInicio, fechaFin);
        } catch (Exception e) {
            System.out.println("");
        }
        return new ArrayList<>();
    }

    public void nuevaOrdenClienteNuevo(Orden orden) {
        OrdenDAO ordDAO = new OrdenDAO();
        ordDAO.crearOrden(orden);
    }

    public void ingresarNuevaOrden(Orden orden) {
        ordenDAO.crearOrden(orden);
    }

    public void mostrarCat() {
        List<Categoria> categorias = categoriaDAO.obtenerTodos();
        System.out.println("\nCategorías:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        categorias = null;

    }

    public void mostrarTec() {
        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodos();
        System.out.println("\nTécnicos:");
        for (Tecnico tecnico : tecnicos) {
            System.out.println(tecnico);
        }
        tecnicos = null;

    }

    public void mostrarOrd() {
        DAO<Orden> genOrdDao = new DAO<>(Orden.class);
        List<Orden> ordenes = genOrdDao.obtenerTodos();
        System.out.println("\nOrdenes:");
        for (Orden orden : ordenes) {
            System.out.println(orden);
        }
        ordenes = null;

    }

    public void mostrarClient() {
        List<Cliente> clientes = clienteDao.obtenerTodos();
        System.out.println("\nClientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        clientes = null;

    }

    public Categoria buscarCatPorId(int id_cat) {
        return categoriaDAO.buscarPorId(id_cat);
    }

    public Tecnico buscarTecPorId(int id_tec) {
        return tecnicoDAO.buscarPorId(id_tec);
    }

}
