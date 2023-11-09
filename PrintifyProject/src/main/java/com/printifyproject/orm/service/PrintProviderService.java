package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.PrintProviderDao;
import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Location;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PrintProviderService {

    @Autowired
    private PrintProviderDao dao;

    public void add(List<PrintProviderEntity> entities) {
        for (PrintProviderEntity entity : entities) {
                add(entity);
        }
    }

    public PrintProviderEntity add(PrintProviderEntity entity) {
        PrintProviderEntity existingEntity = dao.findByKey(entity.getPrintProviderKey());

        if (existingEntity != null) {
            copyState(entity, existingEntity);
            return existingEntity;
        } else {
            dao.insert(entity);
            return entity;
        }
    }

    private void copyState(PrintProviderEntity source, PrintProviderEntity target) {
        target.setName(source.getName());
        target.setRegion(source.getRegion());
        target.setCountry(source.getCountry());
    }

    public PrintProviderEntity findById(int id) {
        return dao.findById(id);
    }

    public PrintProviderEntity findByKey(Integer key) {
        return dao.findByKey(key);
    }

    public List<PrintProviderEntity> findAll() {
        return dao.findAll();
    }

    public PrintProviderEntity update(PrintProviderEntity entity) {
        return add(entity);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public void delete(PrintProviderEntity entity) {
        dao.delete(entity);
    }

    public boolean exists(int id) {
        return dao.existsById(id);
    }

    public boolean exists(PrintProviderEntity entity) {
        return dao.exists(entity);
    }

    public long count() {
        return dao.count();
    }

    public void importPrintifyApi(ApiCatalog apiCatalog, String countryFilter) {
        List<PrintProvider> printProviders = apiCatalog.getPrintProviders();

        List<PrintProviderEntity> entities = printProviders.stream()
                .filter(printProvider -> printProvider.getLocation().getCountry().equals(countryFilter))
                .map(this::transformPrintProviderToEntity)
                .collect(Collectors.toList());

        add(entities);
    }

    public PrintProviderEntity transformPrintProviderToEntity(PrintProvider printProvider) {
        PrintProviderEntity entity = new PrintProviderEntity();
        Location location = printProvider.getLocation();

        entity.setName(printProvider.getTitle());
        entity.setPrintProviderKey(printProvider.getPrintProviderKey());
        entity.setCountry(location.getCountry());
        entity.setRegion(location.getRegion());

        return entity;
    }

    public List<String> getNames() {
        List<PrintProviderEntity> allPrintProviders = dao.findAll();

        return allPrintProviders.stream()
                .map(PrintProviderEntity::getName)
                .collect(Collectors.toList());
    }

    public Optional<PrintProviderEntity> getPrintProviderByName(String name) {
        return dao.findByName(name);
    }

    public Optional<Integer> getIdByName(String name) {
        Optional<PrintProviderEntity> printProvider = dao.findByName(name);
        return printProvider.map(PrintProviderEntity::getPrintProviderId);
    }

    public Optional<Integer> getKeyByName(String name) {
        Optional<PrintProviderEntity> printProvider = dao.findByName(name);
        return printProvider.map(PrintProviderEntity::getPrintProviderKey);
    }


}
