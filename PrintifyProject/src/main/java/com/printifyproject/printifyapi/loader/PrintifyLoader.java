package com.printifyproject.printifyapi.loader;

import com.printifyproject.orm.service.*;
import com.printifyproject.printifyapi.api.ApiCatalog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintifyLoader {

    private static final Logger logger = LogManager.getLogger();

    public static void process() {
        ServiceHelper.initContext();
        ApiCatalog apiCatalog = new ApiCatalog(logger);
        ServiceHelper serviceHelper = new ServiceHelper();

        PrintProviderService printProviderService = serviceHelper.getPrintProviderService();
        printProviderService.importPrintifyApi(apiCatalog, "US");

        BlueprintService blueprintService = serviceHelper.getBlueprintService();
        blueprintService.importPrintifyApi(apiCatalog);

        BlueprintPrintProviderService blueprintPrintProviderService = serviceHelper.getBlueprintPrintProviderService();
        blueprintPrintProviderService.importPrintifyApi(apiCatalog);

        BlueprintPrintProviderVariantService blueprintPrintProviderVariantService = serviceHelper.getBlueprintPrintProviderVariantService();
        blueprintPrintProviderVariantService.importPrintifyApi(apiCatalog);
    }
}
