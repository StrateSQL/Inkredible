package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.ColorDao;
import com.printifyproject.orm.model.ColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ColorService {

    @Autowired
    private ColorDao dao;

    public ColorEntity add(ColorEntity entity) {
        return dao.insert(entity);
    }

    public List<ColorEntity> add(List<ColorEntity> entities) {
        entities.parallelStream().forEach(dao::insert); // Parallelized operation
        return entities;
    }

    public Optional<ColorEntity> findById(int id) {
        return dao.findById(id);
    }

    public ColorEntity findByColor(String color) {
        return dao.findByColor(color);
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

    public Set<String> getColorsByBlueprintPrintProviderId(int blueprintPrintProviderId) {
        return dao.findColorsByBlueprintPrintProviderId(blueprintPrintProviderId);
    }

    public Set<String> getColorsByPrintSpecId(int printSpecId) {
        return dao.findColorsByPrintSpecId(printSpecId);
    }
}
