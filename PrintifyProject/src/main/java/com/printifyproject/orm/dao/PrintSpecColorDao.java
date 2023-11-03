package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.PrintSpecColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrintSpecColorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PrintSpecColorEntity insert(PrintSpecColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<PrintSpecColorEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(PrintSpecColorEntity.class, id));
    }

    public List<PrintSpecColorEntity> findByPrintSpecAndColor(int printSpecId, int colorId) {
        return entityManager.createQuery("SELECT psc FROM PrintSpecColorEntity psc " +
                        "WHERE psc.printSpec.printSpecId = :printSpecId AND psc.color.id = :colorId", PrintSpecColorEntity.class)
                .setParameter("printSpecId", printSpecId)
                .setParameter("colorId", colorId)
                .getResultList();
    }

    public List<PrintSpecColorEntity> findAll() {
        return entityManager.createQuery(
                "SELECT psc FROM PrintSpecColorEntity psc", PrintSpecColorEntity.class
        ).getResultList();
    }

    public PrintSpecColorEntity update(PrintSpecColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        Optional<PrintSpecColorEntity> entity = findById(id);
        entity.ifPresent(entityManager::remove);
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(psc) FROM PrintSpecColorEntity psc", Long.class
        ).getSingleResult();
    }
}
