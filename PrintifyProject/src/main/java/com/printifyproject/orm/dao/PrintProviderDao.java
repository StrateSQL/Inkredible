package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrintProviderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintProviderEntity insert(PrintProviderEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public PrintProviderEntity findById(int id) {
        return entityManager.find(PrintProviderEntity.class, id);
    }

    public PrintProviderEntity findByKey(Integer key) {
        try {
            return entityManager.createQuery("FROM PrintProviderEntity WHERE printProviderKey = :key", PrintProviderEntity.class)
                    .setParameter("key", key)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<PrintProviderEntity> findAll() {
        return entityManager.createQuery("FROM PrintProviderEntity").getResultList();
    }

    public PrintProviderEntity update(PrintProviderEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        PrintProviderEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(PrintProviderEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        PrintProviderEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(PrintProviderEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM PrintProviderEntity e").getSingleResult();
    }
}
