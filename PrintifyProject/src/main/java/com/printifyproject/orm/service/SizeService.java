package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.SizeDao;
import com.printifyproject.orm.model.SizeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class SizeService {

    private final SizeDao dao = new SizeDao(); // In real scenarios, you would inject this.

    public void add(SizeEntity entity) {
        dao.insert(entity);
    }

    public void add(List<SizeEntity> entities) {
        entities.forEach(dao::insert);
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

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(SizeEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(SizeEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
