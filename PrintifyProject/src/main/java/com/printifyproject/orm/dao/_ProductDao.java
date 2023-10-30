package com.printifyproject.orm.dao;

import com.printifyproject.orm.model._Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class _ProductDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(_Product product) {
        em.persist(product);
    }

    public _Product findById(int id) {
        return em.find(_Product.class, id);
    }

    public List<_Product> findAll() {
        return em.createQuery("SELECT p FROM _Product p", _Product.class).getResultList();
    }

    public void remove(_Product product) {
        em.remove(em.contains(product) ? product : em.merge(product));
    }

    public void update(_Product product) {
        em.merge(product);
    }

    public long count() {
        return em.createQuery("SELECT COUNT(p) FROM _Product p", Long.class).getSingleResult();
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    // Assuming you're searching by a String field for simplicity. You can adjust as needed.
    public List<_Product> findByField(String fieldName, String value) {
        return em.createQuery("SELECT p FROM _Product p WHERE p." + fieldName + " = :value", _Product.class)
                .setParameter("value", value)
                .getResultList();
    }

    public _ProductDao() {
    }
}
