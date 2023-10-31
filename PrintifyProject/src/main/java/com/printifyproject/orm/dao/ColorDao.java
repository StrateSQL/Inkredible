package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ColorEntity create(ColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public ColorEntity findById(int id) {
        return entityManager.find(ColorEntity.class, id);
    }

    public ColorEntity findByKey(String key) {
        return entityManager.createQuery("FROM ColorEntity WHERE color = :key", ColorEntity.class)
                .setParameter("key", key)
                .getSingleResult();
    }

    public List<ColorEntity> findAll() {
        return entityManager.createQuery("FROM ColorEntity").getResultList();
    }

    public ColorEntity update(ColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        ColorEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(ColorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        ColorEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(ColorEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM ColorEntity e").getSingleResult();
    }
}
