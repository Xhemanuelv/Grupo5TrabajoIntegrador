package com.grupo3ex5.argprograma.trabajointegradortramo2.Persistencia;

import com.grupo3ex5.argprograma.trabajointegradortramo2.entidades.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuel Villarin
 */
public class CategoriaDao {

    private final EntityManagerFactory entityManagerFactory;

    public CategoriaDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("com.grupo3ex5.argprograma_TrabajoIntegradorTramo2_jar_1.0-SNAPSHOTPU");
    }

//    public Categoria buscarCatPorId(int id_Cat) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        Categoria = em.find(Categoria.class, em)
//        return Categoria;
//    }
}
