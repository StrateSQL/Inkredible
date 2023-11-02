package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.ServiceHelper;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Blueprint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class BlueprintLoader {
    private static final Logger logger = LogManager.getLogger();
    private final ServiceHelper serviceHelper;
    private final BlueprintService blueprintService;
    public BlueprintLoader() {
        this.serviceHelper = new ServiceHelper();;
        this.blueprintService = serviceHelper.getBlueprintService();
    }

    public void process() {
        try (ServiceHelper ignored = serviceHelper) {
            ApiCatalog apiCatalog = new ApiCatalog(logger);
            List<Blueprint> blueprints = apiCatalog.getBlueprints();

            List<BlueprintEntity> entities = blueprints.stream()
                    .filter(blueprint -> blueprint.getTitle().toLowerCase().contains("shirt"))
                    .map(BlueprintLoader::transform)
                    .collect(Collectors.toList());

            blueprintService.add(entities);
        }
    }

    private static BlueprintEntity transform(Blueprint blueprint) {
        BlueprintEntity entity = new BlueprintEntity();

        entity.setBlueprintKey(blueprint.getBlueprintKey());
        entity.setTitle(blueprint.getTitle());
        entity.setModel(blueprint.getModel());
        entity.setBrand(blueprint.getBrand());
        entity.setDescription(blueprint.getDescription());

        return entity;
    }
}
