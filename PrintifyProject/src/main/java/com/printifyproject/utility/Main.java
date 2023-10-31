package com.printifyproject.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.printifyproject.printifyapi.loader.*;

public class Main {

    public static void main(String[] args) {

        PrintifyLoader.process();

    }


    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void doSomething() {
        logger.info("This is an info message.");
        logger.error("This is an error message.");
        //colorExample();

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
