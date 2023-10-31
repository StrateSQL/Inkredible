package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.orm.service.PrintProviderService;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Location;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PrintProviderLoader {
    private static final Logger logger = LogManager.getLogger();
    public static void process () {
        var apiCatalog = new ApiCatalog(logger);
        var printProviders = apiCatalog.getPrintProviders();

        List<PrintProviderEntity> entities = new ArrayList<>();

        for (var printProvider: printProviders) {
            if (printProvider.getLocation().getCountry().equals("US")) {
                entities.add(transform(printProvider));
            }
        }

        add(entities);
    }

    private static PrintProviderEntity transform(PrintProvider printProvider) {
        PrintProviderEntity entity = new PrintProviderEntity();
        Location location = printProvider.getLocation();

        entity.setName(printProvider.getTitle());
        entity.setPrintProviderKey(printProvider.getPrintProviderKey());
        entity.setCountry(location.getCountry());
        entity.setRegion(location.getRegion());

        return entity;
    }

    private static void add(List<PrintProviderEntity> entities) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        PrintProviderService service = ctx.getBean(PrintProviderService.class);
        service.add(entities);
        ctx.close();
    }
}
