package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ColorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ColorEntity insert(ColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<ColorEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(ColorEntity.class, id));
    }

    public ColorEntity findByColor(String color) {
        try {
            return entityManager.createQuery("FROM ColorEntity WHERE color = :key", ColorEntity.class)
                    .setParameter("key", color)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    public List<ColorEntity> findAll() {
        return entityManager.createQuery(
                "SELECT c FROM ColorEntity c", ColorEntity.class
        ).getResultList();
    }

    public ColorEntity update(ColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        findById(id).ifPresent(entityManager::remove);
    }

    public void delete(ColorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public boolean exists(ColorEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getId());
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(c) FROM ColorEntity c", Long.class
        ).getSingleResult();
    }
}
