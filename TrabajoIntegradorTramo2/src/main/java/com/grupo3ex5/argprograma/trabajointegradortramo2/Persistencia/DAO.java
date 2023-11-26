package com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Comunicacion entre objetos y base de datos
 * persistenceUnitName = com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU
 * @param <T> 
 */
public class DAO<T> {

    private final Class<T> clazz;
    private final EntityManagerFactory entityManagerFactory;

    /**
     * Objeto de acceso a Datos generico para evitar codigo redundante usado
     * para cliente, categoria y tecnico
     *
     * @param clazz
     * @param persistenceUnitName 
     */
    public DAO(Class<T> clazz, String persistenceUnitName) {
        this.clazz = clazz;
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void crear(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(entity);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al registrar en la base de datos, no se harán cambios");
        } finally {
            entityManager.close();
        }
    }

    public List<T> obtenerTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> entities = null;

        try {
            entities = entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
        } catch (Exception ex) {
            System.out.println("Error al obtener datos");
        } finally {
            entityManager.close();
        }

        return entities;
    }
}
