package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrintSpecDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintSpecEntity create(PrintSpecEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<PrintSpecEntity> createAll(List<PrintSpecEntity> entities) {
        for (PrintSpecEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public PrintSpecEntity findById(int id) {
        return entityManager.find(PrintSpecEntity.class, id);
    }

    // Assuming the key attribute here refers to `name`.
    public PrintSpecEntity findByKey(String key) {
        try {
            return entityManager.createQuery("FROM PrintSpecEntity WHERE name = :key", PrintSpecEntity.class)
                    .setParameter("key", key)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<PrintSpecEntity> findAll() {
        return entityManager.createQuery("FROM PrintSpecEntity").getResultList();
    }

    public PrintSpecEntity update(PrintSpecEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        PrintSpecEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(PrintSpecEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        PrintSpecEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(PrintSpecEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM PrintSpecEntity e").getSingleResult();
    }
}
