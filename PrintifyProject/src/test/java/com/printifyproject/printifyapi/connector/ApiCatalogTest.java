package com.printifyproject.printifyapi.connector;

import com.printifyproject.printifyapi.api.ApiCatalog;
import com.printifyproject.printifyapi.catalog.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiCatalogTest {
    ApiCatalog apiCatalog;

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger();
        apiCatalog = new ApiCatalog(logger);
    }

    @Test
    void getBlueprint() {
        Blueprint blueprintId5 = apiCatalog.getBlueprint(5);
        assertEquals("Men's Cotton Crew Tee", blueprintId5.getTitle());
        assertEquals("Next Level", blueprintId5.getBrand());
        assertEquals("3600", blueprintId5.getModel());

        //The following blueprint ids do not exist
        assertEquals(null, apiCatalog.getBlueprint(0));
        assertEquals(null, apiCatalog.getBlueprint(-1));
        assertEquals(null, apiCatalog.getBlueprint(10000));
    }

    @Test
    void getBlueprints() {
//        System.out.println(apiCatalog.getBlueprints());

    }

    @Test
    void getPrintProvider() {
        /* Dimona Tee is a U.S. based t-shirt printing company */
        PrintProvider dimonaTee = apiCatalog.getPrintProvider(61);
        assertEquals("Dimona Tee", dimonaTee.getTitle());
        assertEquals("US", dimonaTee.getLocation().getCountry());

        //Following print provider ids don't exist
        assertEquals(null, apiCatalog.getPrintProvider(0));
        assertEquals(null, apiCatalog.getPrintProvider(-1));
        assertEquals(null, apiCatalog.getPrintProvider(10000));
    }

    //This is the method that takes no arguments and returns all print providers
    @Test
    void getPrintProviders() {
        List<PrintProvider> printProviderList = apiCatalog.getPrintProviders();

        assertEquals("AVMM", printProviderList.get(0).getTitle());
        assertEquals("LV", printProviderList.get(0).getLocation().getCountry());
    }

    //This is the testGetPrintProviders() method that takes a blueprint id (int) as arg, to search for Print Providers
    @Test
    void testGetPrintProviders() {
        List<PrintProvider> printProviderList = apiCatalog.getPrintProviders(5);
        // There are 12 print providers for blueprint id = 5, (Men's Cotton Crew Tee)
        assertEquals(12, printProviderList.size());

        // The second print provider for Men's cotton tee is Dimona Tee
        assertEquals(61, printProviderList.get(1).getPrintProviderKey());
        assertEquals("Dimona Tee", printProviderList.get(1).getTitle());

        //The following blueprint ids do not exist
        assertEquals(null, apiCatalog.getPrintProviders(0));
        assertEquals(null, apiCatalog.getPrintProviders(-1));
        assertEquals(null, apiCatalog.getPrintProviders(10000));
    }

    @Test
    void getShipping() {
        //Get shipping info from Print Provider: Dimona Tee, searching for Blueprint of Men Cotton Crew Tee
        Shipping shipping = apiCatalog.getShipping(5, 61);

        //Get the handling time from shipping
        HandlingTime handlingTime = shipping.getHandlingTime();
        assertEquals(10, handlingTime.getValue());
        assertEquals("day", handlingTime.getUnit());

        //Get the list of profiles
        List<Profile> profileList = shipping.getProfiles();
        assertEquals(4, profileList.size());
    }

    @Test
    void getVariants() {
        VariantSet variantSet = apiCatalog.getVariants(5, 61);
        assertEquals("Dimona Tee", variantSet.getTitle());
        assertEquals(61, variantSet.getVariantKey());
        assertEquals(18, variantSet.getVariants().size());  //Provider has 18 Variants
    }
}