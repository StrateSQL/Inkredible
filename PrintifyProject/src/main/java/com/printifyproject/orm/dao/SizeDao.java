package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.SizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SizeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public SizeEntity insert(SizeEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<SizeEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(SizeEntity.class, id));
    }

    public List<SizeEntity> findAll() {
        return entityManager.createQuery("SELECT s FROM SizeEntity s", SizeEntity.class).getResultList();
    }

    public SizeEntity findBySize(String size) {
        try {
            return entityManager.createQuery("FROM SizeEntity WHERE size = :key", SizeEntity.class)
                    .setParameter("key", size)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public SizeEntity update(SizeEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        findById(id).ifPresent(entityManager::remove);
    }

    public void delete(SizeEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }
    public boolean exists(SizeEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getId());
    }
    public long count() {
        return entityManager.createQuery("SELECT COUNT(s) FROM SizeEntity s", Long.class).getSingleResult();
    }
}
