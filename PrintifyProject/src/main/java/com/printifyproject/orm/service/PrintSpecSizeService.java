package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintSpecSizeDao;
import com.printifyproject.orm.model.PrintSpecSizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrintSpecSizeService {

    @Autowired
    private PrintSpecSizeDao dao;

    public PrintSpecSizeEntity add(PrintSpecSizeEntity entity) {
        return dao.create(entity);
    }


    public PrintSpecSizeEntity findById(int id) {
        return dao.findById(id);
    }

    public List<PrintSpecSizeEntity> findAll() {
        return dao.findAll();
    }

    public PrintSpecSizeEntity update(PrintSpecSizeEntity entity) {
        return dao.update(entity);
    }

    public PrintSpecSizeEntity merge(PrintSpecSizeEntity entity) {
        return dao.update(entity);
    }

    public List<PrintSpecSizeEntity> mergeAll(List<PrintSpecSizeEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintSpecSizeEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintSpecSizeEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
