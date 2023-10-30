package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PrintSpecDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(PrintSpecEntity entity) {
        em.persist(entity);
    }

    public PrintSpecEntity findById(int id) {
        return em.find(PrintSpecEntity.class, id);
    }

    public List<PrintSpecEntity> findAll() {
        return em.createQuery("SELECT p FROM PrintSpecEntity p", PrintSpecEntity.class).getResultList();
    }

    @Transactional
    public void remove(PrintSpecEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public PrintSpecEntity update(PrintSpecEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM PrintSpecEntity p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, you can add more specific methods as needed:
    // e.g. findByBlueprintPrintProviderId, findByGossMargin, etc.
}
