package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrintSpecColorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintSpecColorEntity create(PrintSpecColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<PrintSpecColorEntity> createAll(List<PrintSpecColorEntity> entities) {
        for (PrintSpecColorEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public PrintSpecColorEntity findById(int id) {
        return entityManager.find(PrintSpecColorEntity.class, id);
    }

    // Assuming the key attribute here refers to `printSpecId`.
    public PrintSpecColorEntity findByKey(String key) {
        try {
            return entityManager.createQuery("FROM PrintSpecColorEntity WHERE printSpecId = :key", PrintSpecColorEntity.class)
                    .setParameter("key", Integer.valueOf(key))
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<PrintSpecColorEntity> findAll() {
        return entityManager.createQuery("FROM PrintSpecColorEntity").getResultList();
    }

    public PrintSpecColorEntity update(PrintSpecColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        PrintSpecColorEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(PrintSpecColorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        PrintSpecColorEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(PrintSpecColorEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM PrintSpecColorEntity e").getSingleResult();
    }
}
