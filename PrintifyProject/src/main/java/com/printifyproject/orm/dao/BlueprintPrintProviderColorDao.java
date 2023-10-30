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

    public void persist(BlueprintPrintProviderColorEntity entity) {
        em.persist(entity);
    }

    public BlueprintPrintProviderColorEntity findById(int id) {
        return em.find(BlueprintPrintProviderColorEntity.class, id);
    }

    public List<BlueprintPrintProviderColorEntity> findAll() {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderColorEntity e", BlueprintPrintProviderColorEntity.class).getResultList();
    }

    public void remove(BlueprintPrintProviderColorEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void update(BlueprintPrintProviderColorEntity entity) {
        em.merge(entity);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderColorEntity e", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Assuming you're searching by a String field for simplicity. Adjust as needed.
    public List<BlueprintPrintProviderColorEntity> findByField(String fieldName, String value) {
        return em.createQuery("SELECT e FROM BlueprintPrintProviderColorEntity e WHERE e." + fieldName + " = :value", BlueprintPrintProviderColorEntity.class)
                .setParameter("value", value)
                .getResultList();
    }

    public BlueprintPrintProviderColorDao() {
    }
}
