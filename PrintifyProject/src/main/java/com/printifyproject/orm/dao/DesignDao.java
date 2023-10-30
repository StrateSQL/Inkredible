package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.DesignEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DesignDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(DesignEntity entity) {
        em.persist(entity);
    }

    public DesignEntity findById(int id) {
        return em.find(DesignEntity.class, id);
    }

    public List<DesignEntity> findAll() {
        return em.createQuery("SELECT d FROM DesignEntity d", DesignEntity.class).getResultList();
    }

    @Transactional
    public void remove(DesignEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public DesignEntity update(DesignEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(d) FROM DesignEntity d", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Optionally, add more specific methods as needed:
    // e.g. findByDesignTitle, findDesignsByDescription, etc.
}
