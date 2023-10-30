package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlueprintPrintProviderColorDao {

    @PersistenceContext
    private EntityManager em;

    public BlueprintPrintProviderColorEntity persist(BlueprintPrintProviderColorEntity entity) {
        em.persist(entity);
        return entity;
    }

    public List<BlueprintPrintProviderColorEntity> persistAll(List<BlueprintPrintProviderColorEntity> entities) {
        entities.forEach(this::persist);
        return entities;
    }

    public BlueprintPrintProviderColorEntity findById(int id) {
        return em.find(BlueprintPrintProviderColorEntity.class, id);
    }

    public List<BlueprintPrintProviderColorEntity> findAll() {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderColorEntity e", BlueprintPrintProviderColorEntity.class).getResultList();
    }

    public BlueprintPrintProviderColorEntity update(BlueprintPrintProviderColorEntity entity) {
        return em.merge(entity);
    }

    public BlueprintPrintProviderColorEntity merge(BlueprintPrintProviderColorEntity entity) {
        if (exists(entity)) {
            return update(entity);
        } else {
            return persist(entity);
        }
    }

    public List<BlueprintPrintProviderColorEntity> mergeAll(List<BlueprintPrintProviderColorEntity> entities) {
        entities.forEach(this::merge);
        return entities;
    }

    public void removeById(int id) {
        BlueprintPrintProviderColorEntity entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public void remove(BlueprintPrintProviderColorEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderColorEntity e", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean exists(BlueprintPrintProviderColorEntity entity) {
        return em.contains(entity);
    }
}
