package com.grupo3ex5.argprograma.trabajointegradortramo2.Servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO<T> {

    private final Class<T> clazz;
    private final EntityManagerFactory entityManagerFactory;

    /**
     * 
     * 
     * @param clazz
     * @param persistenceUnitName = com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU 
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
            System.out.println("Error al crear entidad " + entity);
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
