package com.printifyproject.orm.examples;

import com.printifyproject.printifyapi.loader.PrintifyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //getBlueprintData();
        PrintifyLoader.process();
        //PublicationManager.UploadProductToPrintify(2);
        //PublishExample.publishProduct();
        //ApiProduct apiProduct = new ApiProduct(logger);
        //ServiceHelper.initContext();
        //ServiceHelper serviceHelper = new ServiceHelper();
        //ProductService productService = serviceHelper.getProductService();
        //ProductEntity product = productService.findById(9).orElse(null);
        //product = productService.uploadPrintifyProduct(product);
        //product = productService.publishPrintify(product);
        //product = productService.modifyPrintifyProduct(product);
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
