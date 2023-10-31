package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintSpecDao;
import com.printifyproject.orm.model.PrintSpecEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrintSpecService {

    @Autowired
    private PrintSpecDao dao;

    public PrintSpecEntity add(PrintSpecEntity entity) {
        return dao.create(entity);
    }


    public PrintSpecEntity findById(int id) {
        return dao.findById(id);
    }

    public PrintSpecEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<PrintSpecEntity> findAll() {
        return dao.findAll();
    }

    public PrintSpecEntity update(PrintSpecEntity entity) {
        return dao.update(entity);
    }

    public PrintSpecEntity merge(PrintSpecEntity entity) {
        return dao.update(entity);
    }

    public List<PrintSpecEntity> mergeAll(List<PrintSpecEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintSpecEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintSpecEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
