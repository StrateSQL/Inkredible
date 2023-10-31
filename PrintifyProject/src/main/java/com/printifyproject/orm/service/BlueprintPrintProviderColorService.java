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
        return dao.persist(entity);
    }



    public BlueprintPrintProviderColorEntity findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderColorEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderColorEntity update(BlueprintPrintProviderColorEntity entity) {
        return dao.update(entity);
    }

    public BlueprintPrintProviderColorEntity merge(BlueprintPrintProviderColorEntity entity) {
        return dao.merge(entity);
    }

    public List<BlueprintPrintProviderColorEntity> mergeAll(List<BlueprintPrintProviderColorEntity> entities) {
        return dao.mergeAll(entities);
    }

    public void deleteById(int id) {
        dao.removeById(id);
    }

    public void delete(BlueprintPrintProviderColorEntity entity) {
        dao.remove(entity);
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
