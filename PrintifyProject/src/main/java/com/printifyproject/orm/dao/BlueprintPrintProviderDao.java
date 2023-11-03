package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlueprintPrintProviderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintPrintProviderEntity insert(BlueprintPrintProviderEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<BlueprintPrintProviderEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(BlueprintPrintProviderEntity.class, id));
    }

    public Optional<BlueprintPrintProviderEntity> findByKeys(
            BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        try {
            return Optional.of(entityManager.createQuery(
                            "SELECT bpp FROM BlueprintPrintProviderEntity bpp " +
                                    "WHERE bpp.blueprint = :blueprint AND bpp.printProvider = :printProvider",
                            BlueprintPrintProviderEntity.class)
                    .setParameter("blueprint", blueprint)
                    .setParameter("printProvider", printProvider)
                    .getSingleResult());
        } catch (jakarta.persistence.NoResultException e) {
            return Optional.empty();
        }
    }

    public List<BlueprintPrintProviderEntity> findAll() {
        return entityManager.createQuery(
                "SELECT e FROM BlueprintPrintProviderEntity e", BlueprintPrintProviderEntity.class
        ).getResultList();
    }

    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    public void deleteById(int id) {
        Optional<BlueprintPrintProviderEntity> entity = findById(id);
        if (entity.isPresent()) {
            entityManager.remove(entity);
        }
    }

    public void delete(BlueprintPrintProviderEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public boolean exists(BlueprintPrintProviderEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getId());
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(e) FROM BlueprintPrintProviderEntity e", Long.class
        ).getSingleResult();
    }
}
