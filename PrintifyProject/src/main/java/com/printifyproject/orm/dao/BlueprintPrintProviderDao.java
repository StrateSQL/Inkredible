package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlueprintPrintProviderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintPrintProviderEntity insert(BlueprintPrintProviderEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public BlueprintPrintProviderEntity findById(int id) {
        return entityManager.find(BlueprintPrintProviderEntity.class, id);
    }

    public List<BlueprintPrintProviderEntity> findByKeys(
            BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        return entityManager.createQuery("SELECT bpp FROM BlueprintPrintProviderEntity bpp " +
                        "WHERE bpp.blueprint = :blueprint AND bpp.printProvider = :printProvider", BlueprintPrintProviderEntity.class)
                .setParameter("blueprint", blueprint)
                .setParameter("printProvider", printProvider)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<BlueprintPrintProviderEntity> findAll() {
        return entityManager.createQuery("FROM BlueprintPrintProviderEntity").getResultList();
    }

    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        BlueprintPrintProviderEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void delete(BlueprintPrintProviderEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        BlueprintPrintProviderEntity entity = findById(id);
        return entity != null;
    }

    public boolean exists(BlueprintPrintProviderEntity entity) {
        return entityManager.contains(entity);
    }

    public long count() {
        return (long) entityManager.createQuery("SELECT COUNT(e) FROM BlueprintPrintProviderEntity e").getSingleResult();
    }
}
