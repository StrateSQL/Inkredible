package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderDao;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
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


    public BlueprintPrintProviderEntity findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return dao.update(entity);
    }

    public BlueprintPrintProviderEntity merge(BlueprintPrintProviderEntity entity) {
        return dao.merge(entity);
    }

    public List<BlueprintPrintProviderEntity> mergeAll(List<BlueprintPrintProviderEntity> entities) {
        return dao.mergeAll(entities);
    }

    public void deleteById(int id) {
        dao.removeById(id);
    }

    public void delete(BlueprintPrintProviderEntity entity) {
        dao.remove(entity);
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
