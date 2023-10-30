package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderSizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlueprintPrintProviderSizeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintPrintProviderSizeEntity create(BlueprintPrintProviderSizeEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<BlueprintPrintProviderSizeEntity> createAll(List<BlueprintPrintProviderSizeEntity> entities) {
        for (BlueprintPrintProviderSizeEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public BlueprintPrintProviderSizeEntity findById(Integer id) {
        return entityManager.find(BlueprintPrintProviderSizeEntity.class, id);
    }

    public BlueprintPrintProviderSizeEntity findByKey(String key) {
        // As there's no "key" column in the entity, this method is left unimplemented.
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<BlueprintPrintProviderSizeEntity> findAll() {
        return entityManager.createQuery("FROM BlueprintPrintProviderSizeEntity").getResultList();
    }

    public BlueprintPrintProviderSizeEntity update(BlueprintPrintProviderSizeEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(Integer id) {
        BlueprintPrintProviderSizeEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(BlueprintPrintProviderSizeEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(Integer id) {
        BlueprintPrintProviderSizeEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(BlueprintPrintProviderSizeEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderSizeEntity e").getSingleResult();
    }
}
