package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(ProductEntity entity) {
        em.persist(entity);
    }

    public ProductEntity findById(int id) {
        return em.find(ProductEntity.class, id);
    }

    public List<ProductEntity> findAll() {
        return em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class).getResultList();
    }

    @Transactional
    public void remove(ProductEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public ProductEntity update(ProductEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM ProductEntity p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, you can add more specific methods as needed:
    // e.g. findByDesignId, findByPrintSpecId, findByIsPublished, etc.
}
