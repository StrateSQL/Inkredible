package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderSizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BlueprintPrintProviderSizeDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(BlueprintPrintProviderSizeEntity entity) {
        em.persist(entity);
    }

    public BlueprintPrintProviderSizeEntity findById(int id) {
        return em.find(BlueprintPrintProviderSizeEntity.class, id);
    }

    public List<BlueprintPrintProviderSizeEntity> findAll() {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderSizeEntity e", BlueprintPrintProviderSizeEntity.class).getResultList();
    }

    @Transactional
    public void remove(BlueprintPrintProviderSizeEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public BlueprintPrintProviderSizeEntity update(BlueprintPrintProviderSizeEntity entity) {
        return em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderSizeEntity e", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }
}
