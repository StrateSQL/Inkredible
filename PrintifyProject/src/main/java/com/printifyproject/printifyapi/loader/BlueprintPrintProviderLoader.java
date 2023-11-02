package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.orm.service.BlueprintPrintProviderService;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.PrintProviderService;
import com.printifyproject.orm.service.ServiceHelper;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BlueprintPrintProviderLoader {

    private static final Logger logger = LogManager.getLogger();
    private final ServiceHelper serviceHelper;
    private final BlueprintService blueprintService;
    private final BlueprintPrintProviderService blueprintPrintProviderService;
    private final PrintProviderService printProviderService;

    public BlueprintPrintProviderLoader() {
        this.serviceHelper = new ServiceHelper();;
        this.blueprintService = serviceHelper.getBlueprintService();
        this.blueprintPrintProviderService = serviceHelper.getBlueprintPrintProviderService();
        this.printProviderService = serviceHelper.getPrintProviderService();
    }

    public void process() {
        try (ServiceHelper ignored = serviceHelper) {
            ApiCatalog apiCatalog = new ApiCatalog(logger);

            List<BlueprintEntity> blueprintEntities = blueprintService.findAll();
            List<BlueprintPrintProviderEntity> blueprintPrintProviderEntities = blueprintPrintProviderService.findAll();

            processBlueprints(apiCatalog, blueprintEntities, blueprintPrintProviderEntities);
            blueprintPrintProviderService.add(blueprintPrintProviderEntities);
        }
    }

    private void processBlueprints(ApiCatalog apiCatalog, List<BlueprintEntity> bEntities, List<BlueprintPrintProviderEntity> bppEntities) {
        for (var blueprint : bEntities) {
            List<PrintProvider> printProviders = apiCatalog.getPrintProviders(blueprint.getBlueprintKey());
            for (var printProvider : printProviders) {
                checkAndAddPrintProvider(blueprint, printProvider, bppEntities);
            }
        }
    }

    private void checkAndAddPrintProvider(BlueprintEntity blueprintEntity, PrintProvider printProvider, List<BlueprintPrintProviderEntity> bppEntities) {
        PrintProviderEntity printProviderEntity = PrintProviderService.transform(printProvider);

        // Check if the PrintProviderEntity already exists in the database
        PrintProviderEntity existingPrintProviderEntity = printProviderService.findByKey(printProviderEntity.getPrintProviderKey());

        if (existingPrintProviderEntity == null) {
            // If it doesn't exist, save the PrintProviderEntity
            printProviderService.add(printProviderEntity);
        } else {
            // If it exists, update the reference to use the existing entity
            printProviderEntity = existingPrintProviderEntity;
        }

        // Now, check if the BlueprintPrintProviderEntity already exists
        var blueprintPrintProviderEntity = blueprintPrintProviderService.findByKeys(blueprintEntity, printProviderEntity);

        if (blueprintPrintProviderEntity.isEmpty()) {
            BlueprintPrintProviderEntity bppEntity = new BlueprintPrintProviderEntity(blueprintEntity, printProviderEntity);
            bppEntities.add(bppEntity);
        }
    }

}
