package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintDao;
import com.printifyproject.orm.model.BlueprintEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlueprintService {

    @Autowired
    private BlueprintDao dao;

    public BlueprintEntity create(BlueprintEntity entity) {
        return dao.create(entity);
    }

    public List<BlueprintEntity> createAll(List<BlueprintEntity> entities) {
        return dao.createAll(entities);
    }

    public BlueprintEntity findById(int id) {
        return dao.findById(id);
    }

    public BlueprintEntity findByKey(Integer key) {
        return dao.findByKey(key);
    }

    public List<BlueprintEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintEntity update(BlueprintEntity entity) {
        return dao.update(entity);
    }

    public BlueprintEntity merge(BlueprintEntity entity) {
        return dao.update(entity);
    }

    public List<BlueprintEntity> mergeAll(List<BlueprintEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(BlueprintEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
