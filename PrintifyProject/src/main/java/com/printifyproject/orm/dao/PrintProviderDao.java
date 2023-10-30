package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PrintProviderDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(PrintProviderEntity entity) {
        em.persist(entity);
    }

    public PrintProviderEntity findById(int id) {
        return em.find(PrintProviderEntity.class, id);
    }

    public List<PrintProviderEntity> findAll() {
        return em.createQuery("SELECT p FROM PrintProviderEntity p", PrintProviderEntity.class).getResultList();
    }

    @Transactional
    public void remove(PrintProviderEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public PrintProviderEntity update(PrintProviderEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM PrintProviderEntity p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, add more specific methods as needed:
    // e.g. findByName, findByRegion, findByCountry, etc.
}
