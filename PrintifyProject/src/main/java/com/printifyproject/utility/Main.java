package com.printifyproject.utility;

import com.printifyproject.datamodel.Color;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        doSomething();
        apiTest();
        //dbTest();
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void doSomething() {
        logger.info("This is an info message.");
        logger.error("This is an error message.");
    }

     //public static void dbTest() {
     //    Color color;
     //    color = new Color();
     //    color.setHex("123");
     //    color.setColor("Black");
//
//
     //    try (Session session = DbInterface.openSession()) {
     //        session.beginTransaction();
     //        session.persist(color);
     //        session.getTransaction().commit();
     //    }
     //}

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
