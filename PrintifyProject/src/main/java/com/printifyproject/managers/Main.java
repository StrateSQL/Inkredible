package com.printifyproject.managers;

import com.printifyproject.printifyapi.api.ApiUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        //getBlueprintData();
        //PrintifyLoader.process();
        //PublicationManager.UploadProductToPrintify(2);
        //PublishExample.publishProduct();

        ApiUpload apiUpload = new ApiUpload(logger);
        //PublicationManager.processImage("2023-10-26 11.36.05.png");
        //PublicationManager
    }


    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void doSomething() {
        logger.info("This is an info message.");
        logger.error("This is an error message.");


    }

    public static void apiTest() {
        //var apiCatalog = new ApiCatalog(logger);
        //var blueprint = apiCatalog.getBlueprint(14);
        //var blueprints = apiCatalog.getBlueprints();
        //var printProvider = apiCatalog.getPrintProvider(29);
        //var printProviders = apiCatalog.getPrintProviders();
        //var blueprintPrintProviders = apiCatalog.getPrintProviders(14);
        //var shipping = apiCatalog.getShipping(14, 29);
        //var variants = apiCatalog.getVariants(14, 29);
    }



}
