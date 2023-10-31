package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintSpecColorDao;
import com.printifyproject.orm.model.PrintSpecColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrintSpecColorService {

    @Autowired
    private PrintSpecColorDao dao;

    public PrintSpecColorEntity add(PrintSpecColorEntity entity) {
        return dao.create(entity);
    }


    public PrintSpecColorEntity findById(int id) {
        return dao.findById(id);
    }

    public PrintSpecColorEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<PrintSpecColorEntity> findAll() {
        return dao.findAll();
    }

    public PrintSpecColorEntity update(PrintSpecColorEntity entity) {
        return dao.update(entity);
    }

    public PrintSpecColorEntity merge(PrintSpecColorEntity entity) {
        return dao.update(entity);
    }

    public List<PrintSpecColorEntity> mergeAll(List<PrintSpecColorEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintSpecColorEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintSpecColorEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
