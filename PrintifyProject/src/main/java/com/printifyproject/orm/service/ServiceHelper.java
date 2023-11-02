package com.printifyproject.orm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceHelper implements AutoCloseable {

    private static final Logger logger = LogManager.getLogger(ServiceHelper.class);
    private static ClassPathXmlApplicationContext ctx;

    /**
     * Initializes the ServiceHelper and loads the Spring application context.
     */
    public ServiceHelper() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
    }

    /**
     * Retrieves a BlueprintService bean from the Spring application context.
     *
     * @return BlueprintService bean
     */
    public BlueprintService getBlueprintService() {
        return ctx.getBean(BlueprintService.class);
    }

    /**
     * Retrieves a PrintProviderService bean from the Spring application context.
     *
     * @return PrintProviderService bean
     */
    public PrintProviderService getPrintProviderService() {
        return ctx.getBean(PrintProviderService.class);
    }

    /**
     * Retrieves a BlueprintPrintProviderService bean from the Spring application context.
     *
     * @return BlueprintPrintProviderService bean
     */
    public BlueprintPrintProviderService getBlueprintPrintProviderService() {
        return ctx.getBean(BlueprintPrintProviderService.class);
    }

    /**
     * Closes the Spring application context.
     */
    public void closeContext() {
        ctx.close();
    }

    public void close() {
        ctx.close();
    }
}
