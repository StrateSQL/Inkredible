package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiCatalogTest {
    ApiCatalog apiCatalog;

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger();
        apiCatalog = new ApiCatalog(logger);
    }

    @Test
    void getBlueprint() {
    }

    @Test
    void getBlueprints() {
        System.out.println(apiCatalog.getBlueprints());

    }

    @Test
    void getPrintProvider() {
        /* Dimona Tee is a U.S. based t-shirt printing company */
        PrintProvider dimonaTee = apiCatalog.getPrintProvider(61);
        assertEquals("Dimona Tee", dimonaTee.getTitle());
        assertEquals("US", dimonaTee.getLocation().getCountry());

        assertEquals(null, apiCatalog.getPrintProvider(0));
        assertEquals(null, apiCatalog.getPrintProvider(-1));
        assertEquals(null, apiCatalog.getPrintProvider(1000));
        System.out.println(apiCatalog.getPrintProvider(100).getLocation().getCountry());
    }

    @Test
    void getPrintProviders() {
        List<PrintProvider> printProviderList = apiCatalog.getPrintProviders();

        assertEquals("AVMM", printProviderList.get(0).getTitle());
        assertEquals("LV", printProviderList.get(0).getLocation().getCountry());
    }

    @Test
    void testGetPrintProviders() {
    }

    @Test
    void getShipping() {
    }

    @Test
    void getVariants() {
    }
}