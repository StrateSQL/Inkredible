package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PrintSpecColorDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(PrintSpecColorEntity entity) {
        em.persist(entity);
    }

    public PrintSpecColorEntity findById(int id) {
        return em.find(PrintSpecColorEntity.class, id);
    }

    public List<PrintSpecColorEntity> findAll() {
        return em.createQuery("SELECT p FROM PrintSpecColorEntity p", PrintSpecColorEntity.class).getResultList();
    }

    @Transactional
    public void remove(PrintSpecColorEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public PrintSpecColorEntity update(PrintSpecColorEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM PrintSpecColorEntity p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, you can add more specific methods as needed:
    // e.g. findByPrintSpecId, findByColorId, etc.
}
