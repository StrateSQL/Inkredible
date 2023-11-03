package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.DesignEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DesignDao {

    @PersistenceContext
    private EntityManager entityManager;

    public DesignEntity insert(DesignEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<DesignEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(DesignEntity.class, id));
    }

    public List<DesignEntity> findAll() {
        return entityManager.createQuery(
                "SELECT d FROM DesignEntity d", DesignEntity.class
        ).getResultList();
    }

    public DesignEntity update(DesignEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        Optional<DesignEntity> entity = findById(id);
        entity.ifPresent(entityManager::remove);
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(d) FROM DesignEntity d", Long.class
        ).getSingleResult();
    }
}
