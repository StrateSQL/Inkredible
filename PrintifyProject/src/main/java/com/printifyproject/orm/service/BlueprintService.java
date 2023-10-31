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

    public void add(List<BlueprintEntity> entities) {
        for (BlueprintEntity entity : entities) {
            add(entity);
        }
    }

    public BlueprintEntity add(BlueprintEntity entity) {
        BlueprintEntity existingEntity = dao.findByKey(entity.getBlueprintKey());

        if (existingEntity != null) {
            copyState(entity, existingEntity);
            return existingEntity;
        } else {
            dao.insert(entity);
            return entity;
        }
    }

    private void copyState(BlueprintEntity source, BlueprintEntity target) {
        target.setTitle(source.getTitle());
        target.setModel(source.getModel());
        target.setBrand(source.getBrand());
        target.setDescription(source.getDescription());
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
        return add(entity);
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
