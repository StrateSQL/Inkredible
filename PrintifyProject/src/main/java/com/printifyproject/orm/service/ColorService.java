package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ColorDao;
import com.printifyproject.orm.model.ColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ColorService {

    @Autowired
    private ColorDao dao;

    public ColorEntity add(ColorEntity entity) {
        return dao.create(entity);
    }


    public ColorEntity findById(int id) {
        return dao.findById(id);
    }

    public ColorEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<ColorEntity> findAll() {
        return dao.findAll();
    }

    public ColorEntity update(ColorEntity entity) {
        return dao.update(entity);
    }

    public ColorEntity merge(ColorEntity entity) {
        return dao.update(entity);
    }

    public List<ColorEntity> mergeAll(List<ColorEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(ColorEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(ColorEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
