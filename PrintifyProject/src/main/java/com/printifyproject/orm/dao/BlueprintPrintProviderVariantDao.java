package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintPrintProviderVariantEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlueprintPrintProviderVariantDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BlueprintPrintProviderVariantEntity insert(BlueprintPrintProviderVariantEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<BlueprintPrintProviderVariantEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(BlueprintPrintProviderVariantEntity.class, id));
    }

    public List<BlueprintPrintProviderVariantEntity> findByBlueprintPrintProvider(int blueprintPrintProviderId) {
        return entityManager.createQuery(
                        "SELECT b " +
                                "FROM BlueprintPrintProviderVariantEntity b " +
                                "WHERE b.blueprintPrintProvider.id = :blueprintPrintProviderId",
                        BlueprintPrintProviderVariantEntity.class)
                .setParameter("blueprintPrintProviderId", blueprintPrintProviderId)
                .getResultList();
    }


    public List<BlueprintPrintProviderVariantEntity> findAll() {
        return entityManager.createQuery(
                "SELECT bpv FROM BlueprintPrintProviderVariantEntity bpv", BlueprintPrintProviderVariantEntity.class
        ).getResultList();
    }

    public BlueprintPrintProviderVariantEntity update(BlueprintPrintProviderVariantEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        findById(id).ifPresent(entityManager::remove);
    }

    public void delete(BlueprintPrintProviderVariantEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(bpv) FROM BlueprintPrintProviderVariantEntity bpv", Long.class
        ).getSingleResult();
    }
}
