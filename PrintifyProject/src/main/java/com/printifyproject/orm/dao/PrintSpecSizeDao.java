package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecSizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrintSpecSizeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintSpecSizeEntity create(PrintSpecSizeEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<PrintSpecSizeEntity> createAll(List<PrintSpecSizeEntity> entities) {
        for (PrintSpecSizeEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public PrintSpecSizeEntity findById(int id) {
        return entityManager.find(PrintSpecSizeEntity.class, id);
    }

    // There's no clear key attribute, so this method is not implemented.
    // If you have a specific attribute you consider a key, you can modify accordingly.

    @SuppressWarnings("unchecked")
    public List<PrintSpecSizeEntity> findAll() {
        return entityManager.createQuery("FROM PrintSpecSizeEntity").getResultList();
    }

    public PrintSpecSizeEntity update(PrintSpecSizeEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        PrintSpecSizeEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(PrintSpecSizeEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        PrintSpecSizeEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(PrintSpecSizeEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM PrintSpecSizeEntity e").getSingleResult();
    }
}
