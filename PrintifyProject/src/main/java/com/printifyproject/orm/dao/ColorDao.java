package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ColorDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public ColorEntity persist(ColorEntity entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    public List<ColorEntity> persistAll(List<ColorEntity> entities) {
        for (ColorEntity entity : entities) {
            em.persist(entity);
        }
        return entities;
    }

    public ColorEntity findById(int id) {
        return em.find(ColorEntity.class, id);
    }

    public ColorEntity findByKey(String key) {
        // Assuming ColorEntity has an attribute "key"
        // Adjust the query accordingly if the name is different
        return em.createQuery("SELECT c FROM ColorEntity c WHERE c.key = :key", ColorEntity.class)
                .setParameter("key", key)
                .getSingleResult();
    }

    public List<ColorEntity> findAll() {
        return em.createQuery("SELECT c FROM ColorEntity c", ColorEntity.class).getResultList();
    }

    @Transactional
    public void removeById(int id) {
        ColorEntity entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Transactional
    public void remove(ColorEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    public ColorEntity update(ColorEntity entity) {
        return em.merge(entity);
    }

    @Transactional
    public ColorEntity merge(ColorEntity entity) {
        if (exists(entity)) {
            return update(entity);
        } else {
            return persist(entity);
        }
    }

    @Transactional
    public List<ColorEntity> mergeAll(List<ColorEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, merge(entities.get(i)));
        }
        return entities;
    }

    public long count() {
        return em.createQuery("SELECT COUNT(c) FROM ColorEntity c", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean exists(ColorEntity entity) {
        if (entity == null) {
            return false;
        }
        return em.contains(entity);
    }

    // Optionally, add more specific methods as needed:
    // e.g. findColorsByHex, findByColorName, etc.
}
