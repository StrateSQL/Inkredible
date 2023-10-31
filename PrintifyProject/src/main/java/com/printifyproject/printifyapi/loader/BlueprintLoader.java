package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Blueprint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BlueprintLoader {
    private static final Logger logger = LogManager.getLogger();

    public static void process() {
        var apiCatalog = new ApiCatalog(logger);
        var blueprints = apiCatalog.getBlueprints();

        List<BlueprintEntity> entities = new ArrayList<>();

        for (var blueprint: blueprints) {
            if (blueprint.getTitle().toLowerCase().contains("shirt")) {
                entities.add(transform(blueprint));
            }
        }

        add(entities);
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

    private static void add(List<BlueprintEntity> entities) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        BlueprintService service = ctx.getBean(BlueprintService.class);
        service.add(entities);
        ctx.close();
    }
}
