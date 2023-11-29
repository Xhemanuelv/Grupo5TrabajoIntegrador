package com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia;

import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Cliente;
import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Orden;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
            //Cliente cliente = entityManager.find(Cliente.class, orden.getCliente().getDni());
            DAO<Cliente> clienteDao = new DAO(Cliente.class);
            List<Cliente> clientes = clienteDao.obtenerTodos();
            boolean clientePersistir = clientes.contains(orden.getCliente());
            boolean clienteExiste = entityManager.contains(orden.getCliente());
            if (clientePersistir) {
                System.out.println("Nueva orden para " + orden.getCliente().getNombre());
            } else {
                entityManager.persist(orden.getCliente());
            }
            //System.out.println(cliente);
//            if (cliente == null) {
//                entityManager.persist(orden.getCliente());
//            }

            /**
             * Se debe verificar si existen tecnico y categoria debido a que
             * utiliza sus id como llaves foraneas, en lugar de agregarlos a DB
             * se informa la ausencia del mismo y se cancela
             */
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
        List<Orden> ordenes = new ArrayList<>();

        try {
            /*Esto esta funcionando
             */
            TypedQuery<Orden> query = entityManager.createQuery(
                    "SELECT o FROM Orden o WHERE o.fecha_orden BETWEEN :fechaInicio AND :fechaFin",
                    Orden.class)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin);
            ordenes = query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error al obtener ordenes entre " + fechaInicio + " y " + fechaFin);
        } finally {
            entityManager.close();
        }

        return ordenes;
    }
}
