package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.SizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SizeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public SizeEntity create(SizeEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<SizeEntity> createAll(List<SizeEntity> entities) {
        for (SizeEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public SizeEntity findById(int id) {
        return entityManager.find(SizeEntity.class, id);
    }

    public SizeEntity findByKey(String key) {
        TypedQuery<SizeEntity> query = entityManager.createQuery(
                "SELECT s FROM SizeEntity s WHERE s.size = :key",
                SizeEntity.class);
        query.setParameter("key", key);
        return query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<SizeEntity> findAll() {
        return entityManager.createQuery("FROM SizeEntity").getResultList();
    }

    public SizeEntity update(SizeEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        SizeEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(SizeEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        SizeEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(SizeEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(s) FROM SizeEntity s").getSingleResult();
    }
}
