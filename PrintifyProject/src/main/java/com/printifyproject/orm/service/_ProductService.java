package com.printifyproject.orm.service;


import com.printifyproject.orm.dao._ProductDao;
import com.printifyproject.orm.model._Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class _ProductService {

    @Autowired
    private _ProductDao demoProductDao;

    @Transactional
    public void add(_Product product) {
        // Check if product with the same ID already exists
        if (demoProductDao.findById(product.getId()) == null) {
            demoProductDao.persist(product);
        } else {
            // Handle duplicate ID scenario (e.g., log the issue, throw an exception, etc.)
            System.err.println("Product with ID " + product.getId() + " already exists!");
        }
    }
    @Transactional
    public void addAll(Collection<_Product> products) {
        for (_Product product : products) {
            demoProductDao.persist(product);
        }
    }

    @Transactional(readOnly = true)
    public List<_Product> listAll() {
        return demoProductDao.findAll();

    }
}