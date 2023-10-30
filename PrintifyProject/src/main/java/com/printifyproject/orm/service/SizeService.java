package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.SizeDao;
import com.printifyproject.orm.model.SizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SizeService {

    @Autowired
    private SizeDao dao;

    public SizeEntity create(SizeEntity entity) {
        return dao.create(entity);
    }

    public List<SizeEntity> createAll(List<SizeEntity> entities) {
        return dao.createAll(entities);
    }

    public SizeEntity findById(int id) {
        return dao.findById(id);
    }

    public SizeEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<SizeEntity> findAll() {
        return dao.findAll();
    }

    public SizeEntity update(SizeEntity entity) {
        return dao.update(entity);
    }

    public SizeEntity merge(SizeEntity entity) {
        return dao.update(entity);
    }

    public List<SizeEntity> mergeAll(List<SizeEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(SizeEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(SizeEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
