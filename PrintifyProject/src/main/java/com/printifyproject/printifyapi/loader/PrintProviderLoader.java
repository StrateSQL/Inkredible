package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.orm.service.PrintProviderService;
import com.printifyproject.orm.service.ServiceHelper;
import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.Location;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class PrintProviderLoader {
    private static final Logger logger = LogManager.getLogger();

    private final ServiceHelper serviceHelper;
    private final PrintProviderService printProviderService;

    public PrintProviderLoader() {
        this.serviceHelper = new ServiceHelper();;
        this.printProviderService = serviceHelper.getPrintProviderService();
    }

    public  void process() {
        try (ServiceHelper ignored = serviceHelper) {
            ApiCatalog apiCatalog = new ApiCatalog(logger);
            List<PrintProvider> printProviders = apiCatalog.getPrintProviders();

            List<PrintProviderEntity> entities = printProviders.stream()
                    .filter(printProvider -> "US".equals(printProvider.getLocation().getCountry()))
                    .map(PrintProviderLoader::transform)
                    .collect(Collectors.toList());

            printProviderService.add(entities);
        }
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
}
