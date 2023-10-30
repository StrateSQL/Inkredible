package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductEntity create(ProductEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<ProductEntity> createAll(List<ProductEntity> entities) {
        for (ProductEntity entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    public ProductEntity findById(int id) {
        return entityManager.find(ProductEntity.class, id);
    }

    public ProductEntity findByKey(String key) {
        TypedQuery<ProductEntity> query = entityManager.createQuery(
                "SELECT p FROM ProductEntity p WHERE p.productKey = :key",
                ProductEntity.class);
        query.setParameter("key", key);
        return query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<ProductEntity> findAll() {
        return entityManager.createQuery("FROM ProductEntity").getResultList();
    }

    public ProductEntity update(ProductEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        ProductEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(ProductEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        ProductEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(ProductEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(p) FROM ProductEntity p").getSingleResult();
    }
}
