package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderVariantDao;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderVariantEntity;
import com.printifyproject.orm.model.ColorEntity;
import com.printifyproject.orm.model.SizeEntity;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Variant;
import com.printifyproject.printifyapi.catalog.VariantSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BlueprintPrintProviderVariantService {
    private final ServiceHelper serviceHelper;

    @Autowired
    private BlueprintPrintProviderVariantDao dao;

    @Autowired
    private BlueprintPrintProviderService blueprintPrintProviderService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    public BlueprintPrintProviderVariantService(ServiceHelper serviceHelper) {
        this.serviceHelper = serviceHelper;
    }

    public BlueprintPrintProviderVariantEntity add(BlueprintPrintProviderVariantEntity entity) {
        Optional<BlueprintPrintProviderVariantEntity> existingEntity =
                dao.findByKeys(entity.getBlueprintPrintProvider().getId(), entity.getVariantKey());

        if (existingEntity.isPresent()) {
            copyState(entity, existingEntity.get());
            return existingEntity.get();
        } else {
            dao.insert(entity);
            return entity;
        }
    }

    private void copyState(BlueprintPrintProviderVariantEntity source, BlueprintPrintProviderVariantEntity target) {
        target.setTitle(source.getTitle());
        target.setSize(source.getSize());
        target.setColor(source.getColor());
    }

    public List<BlueprintPrintProviderVariantEntity> addAll(List<BlueprintPrintProviderVariantEntity> entities) throws ExecutionException, InterruptedException {
        CompletableFuture<List<BlueprintPrintProviderVariantEntity>> future =
                CompletableFuture.supplyAsync(() -> entities.stream().map(dao::insert).collect(Collectors.toList()));
        return future.get();
    }

    public Optional<BlueprintPrintProviderVariantEntity> findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderVariantEntity> findAll() {
        return dao.findAll();
    }

    public BlueprintPrintProviderVariantEntity update(BlueprintPrintProviderVariantEntity entity) {
        return dao.update(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(BlueprintPrintProviderVariantEntity entity) {
        dao.delete(entity);
    }

    public boolean existsById(int id) {
        return dao.existsById(id);
    }

    public long count() {
        return dao.count();
    }

    public void importPrintifyApi(ApiCatalog apiCatalog) {
        List<BlueprintPrintProviderEntity> blueprintPrintProviderEntities = blueprintPrintProviderService.findAll();

        for (var blueprintPrintProviderEntity : blueprintPrintProviderEntities) {
            processVariantSet(blueprintPrintProviderEntity, apiCatalog);
        }
    }

    @Transactional
    public void processVariantSet(BlueprintPrintProviderEntity blueprintPrintProviderEntity, ApiCatalog apiCatalog) {

        int blueprintId = blueprintPrintProviderEntity.getBlueprint().getBlueprintKey();
        int printProviderId = blueprintPrintProviderEntity.getPrintProvider().getPrintProviderKey();

        VariantSet variantSet = apiCatalog.getVariants(blueprintId, printProviderId);

        for (var variant : variantSet.getVariants()) {
            importVariant(blueprintPrintProviderEntity, variant);
        }

    }

    private void importVariant(BlueprintPrintProviderEntity blueprintPrintProviderEntity, Variant variant) {
        BlueprintPrintProviderVariantEntity entity = convertVariantToEntity(blueprintPrintProviderEntity, variant);
        serviceHelper.getBlueprintPrintProviderVariantService().add(entity);
    }

    private BlueprintPrintProviderVariantEntity convertVariantToEntity(BlueprintPrintProviderEntity blueprintPrintProviderEntity,Variant variant) {

        BlueprintPrintProviderVariantEntity entity = new BlueprintPrintProviderVariantEntity();
        entity.setBlueprintPrintProvider(blueprintPrintProviderEntity);

        entity.setVariantKey(variant.getVariantKey());
        entity.setTitle(variant.getTitle());

        entity.setSize(findOrCreateSize(variant.getOptions().getSize()));
        entity.setColor(findOrCreateColor(variant.getOptions().getColor()));

        return entity;
    }

    private SizeEntity findOrCreateSize(String sizeValue) {
        SizeService sizeService = serviceHelper.getSizeService();
        SizeEntity entity = sizeService.findBySize(sizeValue);
        if (entity == null) {
            entity = new SizeEntity();
            entity.setSize(sizeValue);
            sizeService.add(entity);
        }
        return entity;
    }

    private ColorEntity findOrCreateColor(String colorValue) {
        ColorService colorService = serviceHelper.getColorService();
        ColorEntity entity = colorService.findByColor(colorValue);
        if (entity == null) {
            entity = new ColorEntity();
            entity.setColor(colorValue);
            colorService.add(entity);
        }
        return entity;
    }

}
