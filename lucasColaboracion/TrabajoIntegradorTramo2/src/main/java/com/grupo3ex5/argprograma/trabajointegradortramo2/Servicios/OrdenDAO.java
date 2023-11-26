package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Tecnico;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class OrdenDAO {

    private final EntityManagerFactory entityManagerFactory;

    public OrdenDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
    }

    public void crearOrden(Orden orden) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Validar cliente y dar de alta si no existe
            Cliente cliente = entityManager.find(Cliente.class, orden.getCliente().getDni());
            if (cliente == null) {
                entityManager.persist(orden.getCliente());
            }

            // Asignar técnico y categoría sin validar
            entityManager.persist(orden);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Ha ocurrido un error al crear la orden");
        } finally {
            entityManager.close();
        }
    }

    public List<Orden> listarOrdenesEntreFechas(Date fechaInicio, Date fechaFin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Orden> ordenes = null;

        try {
            TypedQuery<Orden> query = entityManager.createQuery(
                    "SELECT o FROM Orden o WHERE o.fechaOrden BETWEEN :fechaInicio AND :fechaFin",
                    Orden.class)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin);
            ordenes = query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error al obtener ordenes entre" + fechaInicio + " y " + fechaFin);
        } finally {
            entityManager.close();
        }

        return ordenes;
    }

    public void crearOrdenView(Cliente cliente, Tecnico tecnico, Categoria categoria) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Validar cliente y dar de alta si no existe en la base de datos
            
            cliente = entityManager.find(Cliente.class, cliente.getDni());
            if (cliente == null) {
                entityManager.persist(cliente);
                JOptionPane.showMessageDialog(null, "Alta a ciente : " + cliente.getNombre());
            }

            // Asignar técnico y categoría sin validar
            String descripcion_orden = JOptionPane.showInputDialog("Ingrese Descripcion para Orden");

            // genera la fecha actual
            LocalDate fechaActual = LocalDate.now();
            Date fecha_orden = java.sql.Date.valueOf(fechaActual);

            //mostrar la fecha que se genera la orden
            JOptionPane.showMessageDialog(null, "Fecha " + fechaActual, "Fecha Actual", JOptionPane.INFORMATION_MESSAGE);

            //generamos costo aleatorio
            Random random = new Random();
            double costoAleatorio = 10000 + (50000 - 10000) * random.nextDouble();

            JOptionPane.showMessageDialog(null, "Costo de la Orden: $" + String.format("%.2f", costoAleatorio));
            
            
            //se crea la orden
            Orden ordenACargar = new Orden(descripcion_orden, costoAleatorio, fecha_orden, "Pendiente", cliente, tecnico, categoria);

            entityManager.persist(ordenACargar);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Ha ocurrido un error al crear la orden");
        } finally {
            entityManager.close();
        }
    }

    public List<Cliente> obtenerTodosClientes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

}
