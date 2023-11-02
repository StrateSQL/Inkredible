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

    public void add(BlueprintPrintProviderSizeEntity entity) {
        dao.insert(entity);
    }

    public void add(List<BlueprintPrintProviderSizeEntity> entities) {
        for (BlueprintPrintProviderSizeEntity entity : entities) {
            dao.insert(entity);
        }
    }

    public BlueprintPrintProviderSizeEntity findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderSizeEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderSizeEntity update(BlueprintPrintProviderSizeEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintPrintProviderSizeEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(BlueprintPrintProviderSizeEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }
}
