package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BlueprintPrintProviderDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(BlueprintPrintProviderEntity entity) {
        em.persist(entity);
    }

    public BlueprintPrintProviderEntity findById(int id) {
        return em.find(BlueprintPrintProviderEntity.class, id);
    }

    public List<BlueprintPrintProviderEntity> findAll() {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderEntity e", BlueprintPrintProviderEntity.class).getResultList();
    }

    @Transactional
    public void remove(BlueprintPrintProviderEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderEntity e", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }
}
