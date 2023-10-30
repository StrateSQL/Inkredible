package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlueprintDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintEntity create(BlueprintEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<BlueprintEntity> createAll(List<BlueprintEntity> entities) {
        for (BlueprintEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public BlueprintEntity findById(int id) {
        return entityManager.find(BlueprintEntity.class, id);
    }

    public BlueprintEntity findByKey(Integer key) {
        return entityManager.createQuery("FROM BlueprintEntity WHERE blueprintKey = :key", BlueprintEntity.class)
                .setParameter("key", key)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<BlueprintEntity> findAll() {
        return entityManager.createQuery("FROM BlueprintEntity").getResultList();
    }

    public BlueprintEntity update(BlueprintEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        BlueprintEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(BlueprintEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        BlueprintEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(BlueprintEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM BlueprintEntity e").getSingleResult();
    }
}
