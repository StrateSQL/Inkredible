package com.printifyproject.utility;

import com.printifyproject.orm.model._Product;
import com.printifyproject.orm.service._ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        doSomething();
        //apiTest();
        //dbTest();
    }

    private static final Logger logger = LogManager.getLogger();

    public static void doSomething() {
        logger.info("This is an info message.");
        logger.error("This is an error message.");
        ormTest();
    }

     public static void ormTest() {
         //Create Spring application context
         ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

         //Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
         _ProductService productService = ctx.getBean(_ProductService.class);

         //Do some data operation

         productService.add(new _Product(1, "Bulb"));
         productService.add(new _Product(2, "Dijone mustard"));

         System.out.println("listAll: " + productService.listAll());

         //Test transaction rollback (duplicated key)

         try {
             productService.addAll(Arrays.asList(new _Product(3, "Book"), new _Product(4, "Soap"), new _Product(1, "Computer")));
         } catch (DataAccessException dataAccessException) {
         }

         //Test element list after rollback
         System.out.println("listAll: " + productService.listAll());

         ctx.close();
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
