package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ProductDao;
import com.printifyproject.orm.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductDao dao;

    @Autowired
    public ProductService(ProductDao dao) {
        this.dao = dao;
    }

    public ProductEntity add(ProductEntity entity) {
        return dao.insert(entity);
    }

    public List<ProductEntity> add(List<ProductEntity> entities) {
        for (ProductEntity entity : entities) {
            dao.insert(entity);
        }
        return entities;
    }

    public Optional<ProductEntity> findById(int id) {
        return dao.findById(id);
    }

    public List<ProductEntity> findAll() {
        return dao.findAll();
    }

    public ProductEntity update(ProductEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(ProductEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(ProductEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
