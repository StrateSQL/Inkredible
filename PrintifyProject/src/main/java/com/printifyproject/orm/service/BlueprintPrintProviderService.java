package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderDao;
import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlueprintPrintProviderService {

    @Autowired
    private BlueprintPrintProviderDao dao;

    public BlueprintPrintProviderEntity add(BlueprintPrintProviderEntity entity) {
        return dao.insert(entity);
    }

    public List<BlueprintPrintProviderEntity> add(List<BlueprintPrintProviderEntity> entities) {
        for (BlueprintPrintProviderEntity entity : entities) {
            dao.insert(entity);
        }
        return entities;
    }

    public BlueprintPrintProviderEntity findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderEntity> findByKeys(
            BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        return dao.findByKeys(blueprint, printProvider);
    }

    public List<BlueprintPrintProviderEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintPrintProviderEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(BlueprintPrintProviderEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
