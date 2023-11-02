package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlueprintPrintProviderColorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintPrintProviderColorEntity insert(BlueprintPrintProviderColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public BlueprintPrintProviderColorEntity findById(int id) {
        return entityManager.find(BlueprintPrintProviderColorEntity.class, id);
    }

    // Assuming BlueprintPrintProviderId or ColorId can act as a "key" for search.
    // You would replace "keyFieldName" with the actual field name.
    public BlueprintPrintProviderColorEntity findByKey(int key) {
        // Implementation here
        return null; // Placeholder
    }

    public List<BlueprintPrintProviderColorEntity> findAll() {
        return entityManager.createQuery("SELECT e FROM BlueprintPrintProviderColorEntity e", BlueprintPrintProviderColorEntity.class).getResultList();
    }

    public BlueprintPrintProviderColorEntity update(BlueprintPrintProviderColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        BlueprintPrintProviderColorEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(BlueprintPrintProviderColorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean exists(BlueprintPrintProviderColorEntity entity) {
        return entityManager.contains(entity) || findById(entity.getBlueprintPrintProviderColorId()) != null;
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderColorEntity e", Long.class).getSingleResult();
    }
}
