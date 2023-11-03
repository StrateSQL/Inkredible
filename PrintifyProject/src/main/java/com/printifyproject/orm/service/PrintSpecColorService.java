package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintSpecColorDao;
import com.printifyproject.orm.model.PrintSpecColorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrintSpecColorService {

    @Autowired
    private PrintSpecColorDao dao;

    public PrintSpecColorEntity add(PrintSpecColorEntity entity) {
        return dao.insert(entity);
    }

    public List<PrintSpecColorEntity> add(List<PrintSpecColorEntity> entities) {
        entities.forEach(dao::insert);
        return entities;
    }

    public Optional<PrintSpecColorEntity> findById(int id) {
        return dao.findById(id);
    }

    public List<PrintSpecColorEntity> findByPrintSpecAndColor(int printSpecId, int colorId) {
        return dao.findByPrintSpecAndColor(printSpecId, colorId);
    }

    public List<PrintSpecColorEntity> findAll() {
        return dao.findAll();
    }

    public PrintSpecColorEntity update(PrintSpecColorEntity entity) {
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
}
