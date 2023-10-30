package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ColorDao;
import com.printifyproject.orm.model.ColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorDao colorDao;

    public ColorEntity create(ColorEntity entity) {
        return colorDao.persist(entity);
    }

    public List<ColorEntity> createAll(List<ColorEntity> entities) {
        return colorDao.persistAll(entities);
    }

    public ColorEntity findById(int id) {
        return colorDao.findById(id);
    }

    public ColorEntity findByKey(String key) {
        return colorDao.findByKey(key);
    }

    public List<ColorEntity> findAll() {
        return colorDao.findAll();
    }

    public ColorEntity update(ColorEntity entity) {
        return colorDao.update(entity);
    }

    public ColorEntity merge(ColorEntity entity) {
        return colorDao.merge(entity);
    }

    public List<ColorEntity> mergeAll(List<ColorEntity> entities) {
        return colorDao.mergeAll(entities);
    }

    public void deleteById(int id) {
        colorDao.removeById(id);
    }

    public void delete(ColorEntity entity) {
        colorDao.remove(entity);
    }

    public boolean existsById(int id) {
        return colorDao.existsById(id);
    }

    public boolean exists(ColorEntity entity) {
        return colorDao.exists(entity);
    }

    public long count() {
        return colorDao.count();
    }
}
