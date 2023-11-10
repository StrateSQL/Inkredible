package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintSpecDao;
import com.printifyproject.orm.dao.ProductDao;
import com.printifyproject.orm.model.PrintSpecEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrintSpecService {

    private final PrintSpecDao dao;
    private final ProductDao productDao;

    @Autowired
    public PrintSpecService(PrintSpecDao dao, ProductDao productDao) {
        this.dao = dao;
        this.productDao = productDao;
    }

    public PrintSpecEntity add(PrintSpecEntity entity) {
        return dao.insert(entity);
    }

    public List<PrintSpecEntity> add(List<PrintSpecEntity> entities) {
        for (PrintSpecEntity entity : entities) {
            dao.insert(entity);
        }
        return entities;
    }

    public Optional<PrintSpecEntity> findById(int id) {
        return dao.findById(id);
    }

    public List<PrintSpecEntity> findAll() {
        return dao.findAll();
    }

    public PrintSpecEntity update(PrintSpecEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintSpecEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintSpecEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }

    public List<String> getNames() {
        List<PrintSpecEntity> printSpec = dao.findAll();

        return printSpec.stream()
                .map(PrintSpecEntity::getName)
                .toList();
    }
    public Optional<PrintSpecEntity> findBlueprintByTitle(String title) {
        return dao.findByName(title);
    }
    public Optional<Integer> getIdByTitle(String title) {
        Optional<PrintSpecEntity> printSpec = dao.findByName(title);
        return printSpec.map(PrintSpecEntity::getPrintSpecId);
    }

}
