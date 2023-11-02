package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderColorDao;
import com.printifyproject.orm.model.BlueprintPrintProviderColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlueprintPrintProviderColorService {

    @Autowired
    private BlueprintPrintProviderColorDao dao;

    public BlueprintPrintProviderColorEntity add(BlueprintPrintProviderColorEntity entity) {
        return dao.insert(entity);
    }

    public List<BlueprintPrintProviderColorEntity> add(List<BlueprintPrintProviderColorEntity> entities) {
        for (BlueprintPrintProviderColorEntity entity : entities) {
            dao.insert(entity);
        }
        return entities;
    }

    public BlueprintPrintProviderColorEntity findById(int id) {
        return dao.findById(id);
    }

    public BlueprintPrintProviderColorEntity findByKey(int key) {
        return dao.findByKey(key);
    }

    public List<BlueprintPrintProviderColorEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderColorEntity update(BlueprintPrintProviderColorEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintPrintProviderColorEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(BlueprintPrintProviderColorEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
