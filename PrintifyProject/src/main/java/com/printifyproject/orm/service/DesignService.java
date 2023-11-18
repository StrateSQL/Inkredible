package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.DesignDao;
import com.printifyproject.orm.model.DesignEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DesignService {

    @Autowired
    private DesignDao dao;

    public DesignEntity add(DesignEntity entity) {

        return dao.insert(entity);
    }

    public List<DesignEntity> add(List<DesignEntity> entities) {
        entities.forEach(dao::insert);
        return entities;
    }

    public Optional<DesignEntity> findById(int id) {
        return dao.findById(id);
    }

    public List<DesignEntity> findAll() {
        return dao.findAll();
    }

    public DesignEntity update(DesignEntity entity) {

        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public long count() {
        return dao.count();
    }

    public List<String> getTitles() {
        List<DesignEntity> blueprints = dao.findAll();

        return blueprints.stream()
                .map(DesignEntity::getTitle)
                .toList();
    }
    public Optional<DesignEntity> findDesignByTitle(String title) {
        return dao.findByTitle(title);
    }

    public Optional<Integer> getIdByTitle(String title) {
        Optional<DesignEntity> design = dao.findByTitle(title);
        return design.map(DesignEntity::getDesignId);
    }
}
