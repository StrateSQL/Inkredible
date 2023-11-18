package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ColorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ColorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ColorEntity insert(ColorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<ColorEntity> findById(int id) {
        return Optional.ofNullable(entityManager.find(ColorEntity.class, id));
    }

    public ColorEntity findByColor(String color) {
        try {
            return entityManager.createQuery("FROM ColorEntity WHERE color = :key", ColorEntity.class)
                    .setParameter("key", color)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    public List<ColorEntity> findAll() {
        return entityManager.createQuery(
                "SELECT c FROM ColorEntity c", ColorEntity.class
        ).getResultList();
    }

    public ColorEntity update(ColorEntity entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(int id) {
        findById(id).ifPresent(entityManager::remove);
    }

    public void delete(ColorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    public boolean exists(ColorEntity entity) {
        return entityManager.contains(entity) || existsById(entity.getId());
    }

    public long count() {
        return entityManager.createQuery(
                "SELECT COUNT(c) FROM ColorEntity c", Long.class
        ).getSingleResult();
    }

    public Set<String> findColorsByBlueprintPrintProviderId(int blueprintPrintProviderId) {
        return new HashSet<>(entityManager.createQuery(
                        "SELECT DISTINCT c.color " +
                                "FROM ColorEntity c " +
                                "JOIN c.blueprintPrintProviderVariants bpv " +
                                "WHERE bpv.blueprintPrintProvider.id = :providerId", String.class)
                .setParameter("providerId", blueprintPrintProviderId)
                .getResultList());
    }

    public Set<String> getColorsByPrintSpecId(int printSpecId) {
        return new HashSet<>(entityManager.createQuery(
                        "SELECT DISTINCT c.color " +
                                "FROM ColorEntity c " +
                                "JOIN c.printSpecColors psc " +
                                "WHERE psc.printSpec.id = :printSpecId", String.class)
                .setParameter("printSpecId", printSpecId)
                .getResultList());
    }

    public String findColorByBlueprintPrintProviderVariantId(int blueprintPrintProviderVariantId) {
        try {
            return entityManager.createQuery(
                            "SELECT DISTINCT c.color " +
                                    "FROM ColorEntity c " +
                                    "JOIN c.blueprintPrintProviderVariants bpv " +
                                    "WHERE bpv.id = :variantId", String.class)
                    .setParameter("variantId", blueprintPrintProviderVariantId)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null; // Handle the case where no result is found
        }
    }
    public Set<String> findColorsByPrintSpecId(int printSpecId) {
        return new HashSet<>(entityManager.createQuery(
                        "SELECT DISTINCT c.color " +
                                "FROM ColorEntity c " +
                                "JOIN c.printSpecColors psc " +
                                "WHERE psc.printSpec.id = :printSpecId", String.class)
                .setParameter("printSpecId", printSpecId)
                .getResultList());
    }

    public String findColorByPrintSpecId(int printSpecId) {
        try {
            return entityManager.createQuery(
                            "SELECT DISTINCT c.color " +
                                    "FROM ColorEntity c " +
                                    "JOIN c.printSpecColors bpv " +
                                    "WHERE bpv.id = :printSpecId", String.class)
                    .setParameter("printSpecId", printSpecId)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null; // Handle the case where no result is found
        }
    }
}
