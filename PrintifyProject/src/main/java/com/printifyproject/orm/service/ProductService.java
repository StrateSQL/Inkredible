package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ProductDao;
import com.printifyproject.orm.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao dao;

    public ProductEntity create(ProductEntity entity) {
        return dao.create(entity);
    }

    public List<ProductEntity> createAll(List<ProductEntity> entities) {
        return dao.createAll(entities);
    }

    public ProductEntity findById(int id) {
        return dao.findById(id);
    }

    public ProductEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<ProductEntity> findAll() {
        return dao.findAll();
    }

    public ProductEntity update(ProductEntity entity) {
        return dao.update(entity);
    }

    public ProductEntity merge(ProductEntity entity) {
        return dao.update(entity);
    }

    public List<ProductEntity> mergeAll(List<ProductEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(ProductEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(ProductEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
