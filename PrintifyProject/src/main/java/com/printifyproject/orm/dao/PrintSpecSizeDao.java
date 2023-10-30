package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecSizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PrintSpecSizeDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(PrintSpecSizeEntity entity) {
        em.persist(entity);
    }

    public PrintSpecSizeEntity findById(int id) {
        return em.find(PrintSpecSizeEntity.class, id);
    }

    public List<PrintSpecSizeEntity> findAll() {
        return em.createQuery("SELECT p FROM PrintSpecSizeEntity p", PrintSpecSizeEntity.class).getResultList();
    }

    @Transactional
    public void remove(PrintSpecSizeEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public PrintSpecSizeEntity update(PrintSpecSizeEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM PrintSpecSizeEntity p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, you can add more specific methods as needed:
    // e.g. findByPrintSpecId, findBySizeId, etc.
}
