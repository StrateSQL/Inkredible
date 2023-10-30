package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.DesignDao;
import com.printifyproject.orm.model.DesignEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DesignService {

    @Autowired
    private DesignDao dao;

    public DesignEntity create(DesignEntity entity) {
        return dao.create(entity);
    }

    public List<DesignEntity> createAll(List<DesignEntity> entities) {
        return dao.createAll(entities);
    }

    public DesignEntity findById(int id) {
        return dao.findById(id);
    }

    public DesignEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<DesignEntity> findAll() {
        return dao.findAll();
    }

    public DesignEntity update(DesignEntity entity) {
        return dao.update(entity);
    }

    public DesignEntity merge(DesignEntity entity) {
        return dao.update(entity);
    }

    public List<DesignEntity> mergeAll(List<DesignEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(DesignEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(DesignEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
