package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.DesignEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesignDao {

    @PersistenceContext
    private EntityManager entityManager;

    public DesignEntity create(DesignEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<DesignEntity> createAll(List<DesignEntity> entities) {
        for (DesignEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public DesignEntity findById(int id) {
        return entityManager.find(DesignEntity.class, id);
    }

    public DesignEntity findByKey(String key) {
        return entityManager.createQuery("FROM DesignEntity WHERE title = :key", DesignEntity.class)
                .setParameter("key", key)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<DesignEntity> findAll() {
        return entityManager.createQuery("FROM DesignEntity").getResultList();
    }

    public DesignEntity update(DesignEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        DesignEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(DesignEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        DesignEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(DesignEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM DesignEntity e").getSingleResult();
    }
}
