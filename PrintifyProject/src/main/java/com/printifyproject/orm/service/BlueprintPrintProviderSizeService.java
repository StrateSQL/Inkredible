package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderSizeDao;
import com.printifyproject.orm.model.BlueprintPrintProviderSizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlueprintPrintProviderSizeService {

    @Autowired
    private BlueprintPrintProviderSizeDao dao;

    public BlueprintPrintProviderSizeEntity add(BlueprintPrintProviderSizeEntity entity) {
        return dao.create(entity);
    }


    public BlueprintPrintProviderSizeEntity findById(Integer id) {
        return dao.findById(id);
    }

    public BlueprintPrintProviderSizeEntity findByKey(String key) {
        return dao.findByKey(key);
    }

    public List<BlueprintPrintProviderSizeEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderSizeEntity update(BlueprintPrintProviderSizeEntity entity) {
        return dao.update(entity);
    }

    public BlueprintPrintProviderSizeEntity merge(BlueprintPrintProviderSizeEntity entity) {
        return dao.update(entity);  // Using update (merge) for both purposes
    }

    public List<BlueprintPrintProviderSizeEntity> mergeAll(List<BlueprintPrintProviderSizeEntity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            entities.set(i, dao.update(entities.get(i)));
        }
        return entities;
    }

    public void delete(Integer id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintPrintProviderSizeEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(Integer id) {
        return dao.existsById(id);
    }

    public boolean exists(BlueprintPrintProviderSizeEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
