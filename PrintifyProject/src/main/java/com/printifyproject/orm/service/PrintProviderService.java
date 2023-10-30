package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintProviderDao;
import com.printifyproject.orm.model.PrintProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrintProviderService {

    @Autowired
    private PrintProviderDao dao;

    public PrintProviderEntity create(PrintProviderEntity entity) {
        return dao.create(entity);
    }

    public List<PrintProviderEntity> createAll(List<PrintProviderEntity> entities) {
        return dao.createAll(entities);
    }

    public PrintProviderEntity findById(int id) {
        return dao.findById(id);
    }

    public PrintProviderEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<PrintProviderEntity> findAll() {
        return dao.findAll();
    }

    public PrintProviderEntity update(PrintProviderEntity entity) {
        return dao.update(entity);
    }

    public PrintProviderEntity merge(PrintProviderEntity entity) {
        return dao.update(entity);
    }

    public List<PrintProviderEntity> mergeAll(List<PrintProviderEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintProviderEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintProviderEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
