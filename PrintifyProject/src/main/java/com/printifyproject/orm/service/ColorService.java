package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ColorDao;
import com.printifyproject.orm.model.ColorEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ColorService {

    private final ColorDao dao = new ColorDao(); // In real scenarios, you would inject this.

    public void add(ColorEntity entity) {
        dao.insert(entity);
    }

    public void add(List<ColorEntity> entities) {
        entities.forEach(dao::insert);
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

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(ColorEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(ColorEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
