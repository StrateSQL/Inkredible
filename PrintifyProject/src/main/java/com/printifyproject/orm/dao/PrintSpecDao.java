package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrintSpecDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintSpecEntity insert(PrintSpecEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<PrintSpecEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(PrintSpecEntity.class, id));
    }

    public List<PrintSpecEntity> findAll() {
        return entityManager.createQuery(
                "SELECT e FROM PrintSpecEntity e", PrintSpecEntity.class
        ).getResultList();
    }

    public PrintSpecEntity update(PrintSpecEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    public void deleteById(int id) {
        Optional<PrintSpecEntity> entity = findById(id);
        entity.ifPresent(entityManager::remove);
    }

    public void delete(PrintSpecEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }


    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public boolean exists(PrintSpecEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getPrintSpecId());
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(e) FROM PrintSpecEntity e", Long.class
        ).getSingleResult();
    }

    public Optional<PrintSpecEntity> findByName(String name) {
        TypedQuery<PrintSpecEntity> query = entityManager.createQuery(
                "SELECT e FROM PrintSpecEntity e WHERE e.name = :name",
                PrintSpecEntity.class
        );
        query.setParameter("name", name);

        try {
            PrintSpecEntity result = query.getSingleResult();
            return Optional.of(result);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
