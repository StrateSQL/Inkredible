package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlueprintDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(BlueprintEntity blueprint) {
        em.persist(blueprint);
    }

    public BlueprintEntity findById(int id) {
        return em.find(BlueprintEntity.class, id);
    }

    public List<BlueprintEntity> findAll() {
        return em.createQuery("SELECT b FROM BlueprintEntity b", BlueprintEntity.class).getResultList();
    }

    public void remove(BlueprintEntity blueprint) {
        em.remove(em.contains(blueprint) ? blueprint : em.merge(blueprint));
    }

    public void update(BlueprintEntity blueprint) {
        em.merge(blueprint);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(b) FROM BlueprintEntity b", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Assuming you're searching by a String field for simplicity. You can adjust as needed.
    public List<BlueprintEntity> findByField(String fieldName, String value) {
        return em.createQuery("SELECT b FROM BlueprintEntity b WHERE b." + fieldName + " = :value", BlueprintEntity.class)
                .setParameter("value", value)
                .getResultList();
    }

    public BlueprintDao() {
    }
}
