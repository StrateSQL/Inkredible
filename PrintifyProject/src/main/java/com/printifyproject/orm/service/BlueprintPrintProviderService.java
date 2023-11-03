package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderDao;
import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlueprintPrintProviderService {

    @Autowired
    private BlueprintPrintProviderDao dao;

    @Autowired
    private BlueprintService blueprintService;

    @Autowired
    private PrintProviderService printProviderService;

    public BlueprintPrintProviderEntity add(BlueprintPrintProviderEntity entity) {
        return dao.insert(entity);
    }

    public List<BlueprintPrintProviderEntity> add(List<BlueprintPrintProviderEntity> entities) {
        for (BlueprintPrintProviderEntity entity : entities) {
            dao.insert(entity);
        }
        return entities;
    }

    public Optional<BlueprintPrintProviderEntity> findById(int id) {
        return dao.findById(id);
    }

    public Optional<BlueprintPrintProviderEntity> findByKeys(
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

    public void importPrintifyApi(ApiCatalog apiCatalog) {
        List<BlueprintEntity> blueprintEntities = blueprintService.findAll();
        List<BlueprintPrintProviderEntity> blueprintPrintProviderEntities = new ArrayList<>();

        processBlueprints(apiCatalog, blueprintEntities, blueprintPrintProviderEntities);
        add(blueprintPrintProviderEntities);
    }

    private void processBlueprints(ApiCatalog apiCatalog, List<BlueprintEntity> blueprintEntities, List<BlueprintPrintProviderEntity> blueprintPrintProviderEntities) {
        for (BlueprintEntity blueprintEntity : blueprintEntities) {
            List<PrintProvider> printProviders = apiCatalog.getPrintProviders(blueprintEntity.getBlueprintKey());
            for (PrintProvider printProvider : printProviders) {
                checkAndAddPrintProvider(blueprintEntity, printProvider, blueprintPrintProviderEntities);
            }
        }
    }

    private void checkAndAddPrintProvider(BlueprintEntity blueprintEntity, PrintProvider printProvider, List<BlueprintPrintProviderEntity> blueprintPrintProviderEntities) {
        PrintProviderEntity printProviderEntity = printProviderService.transformPrintProviderToEntity(printProvider);

        PrintProviderEntity existingPrintProviderEntity = printProviderService.findByKey(printProviderEntity.getPrintProviderKey());

        if (existingPrintProviderEntity == null) {
            printProviderService.add(printProviderEntity);
        } else {
            printProviderEntity = existingPrintProviderEntity;
        }

        Optional<BlueprintPrintProviderEntity> blueprintPrintProviderEntity = findByKeys(blueprintEntity, printProviderEntity);

        if (blueprintPrintProviderEntity.isEmpty()) {
            BlueprintPrintProviderEntity newEntity = new BlueprintPrintProviderEntity(blueprintEntity, printProviderEntity);
            blueprintPrintProviderEntities.add(newEntity);
        }
    }


}
