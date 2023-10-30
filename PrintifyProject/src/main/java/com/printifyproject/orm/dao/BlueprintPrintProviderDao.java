package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlueprintPrintProviderDao {

    @PersistenceContext
    private EntityManager em;

    public BlueprintPrintProviderEntity persist(BlueprintPrintProviderEntity entity) {
        em.persist(entity);
        return entity;
    }

    public List<BlueprintPrintProviderEntity> persistAll(List<BlueprintPrintProviderEntity> entities) {
        entities.forEach(this::persist);
        return entities;
    }

    public BlueprintPrintProviderEntity findById(int id) {
        return em.find(BlueprintPrintProviderEntity.class, id);
    }

    // Note: Since there's no key column specified, we will skip the findByKey method

    public List<BlueprintPrintProviderEntity> findAll() {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderEntity e", BlueprintPrintProviderEntity.class).getResultList();
    }

    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return em.merge(entity);
    }

    public BlueprintPrintProviderEntity merge(BlueprintPrintProviderEntity entity) {
        if (existsById(entity.getBlueprintPrintProviderId())) {
            return update(entity);
        } else {
            return persist(entity);
        }
    }

    public List<BlueprintPrintProviderEntity> mergeAll(List<BlueprintPrintProviderEntity> entities) {
        entities.forEach(this::merge);
        return entities;
    }

    public void removeById(int id) {
        BlueprintPrintProviderEntity entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public void remove(BlueprintPrintProviderEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderEntity e", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean exists(BlueprintPrintProviderEntity entity) {
        return em.contains(entity);
    }
}
