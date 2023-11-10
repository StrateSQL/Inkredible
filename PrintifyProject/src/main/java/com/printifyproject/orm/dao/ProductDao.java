package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductEntity insert(ProductEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<ProductEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(ProductEntity.class, id));
    }

    public List<ProductEntity> findAll() {
        return entityManager.createQuery(
                "SELECT e FROM ProductEntity e", ProductEntity.class
        ).getResultList();
    }

    public ProductEntity update(ProductEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    public void deleteById(int id) {
        Optional<ProductEntity> entity = findById(id);
        entity.ifPresent(entityManager::remove);
    }

    public void delete(ProductEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void delete(List<ProductEntity> products) {
        entityManager.createQuery("DELETE FROM ProductEntity p WHERE p IN :products")
                .setParameter("products", products)
                .executeUpdate();
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public boolean exists(ProductEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getProductId());
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(e) FROM ProductEntity e", Long.class
        ).getSingleResult();
    }
}
