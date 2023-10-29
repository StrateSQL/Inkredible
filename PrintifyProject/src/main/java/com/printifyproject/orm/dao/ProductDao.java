package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Product product) {
        em.persist(product);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p").getResultList();
    }

    public ProductDao() {
    }

}