package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintSpecEntityTest {

    private PrintSpecEntity printSpecEntity;

    @BeforeEach
    void setUp() {
        printSpecEntity = new PrintSpecEntity();
    }

    @Test
    void testPrintSpecIdGetterSetter() {
        int testId = 1;
        printSpecEntity.setPrintSpecId(testId);
        assertEquals(testId, printSpecEntity.getPrintSpecId());
    }

    @Test
    void testNameGetterSetter() {
        String testName = "Test Name";
        printSpecEntity.setName(testName);
        assertEquals(testName, printSpecEntity.getName());
    }

    @Test
    void testGossMarginGetterSetter() {
        Double testGossMargin = 10.0;
        printSpecEntity.setGossMargin(testGossMargin);
        assertEquals(testGossMargin, printSpecEntity.getGossMargin());
    }

    @Test
    void testBlueprintPrintProviderGetterSetter() {
        BlueprintPrintProviderEntity testBlueprintPrintProvider = new BlueprintPrintProviderEntity();
        printSpecEntity.setBlueprintPrintProvider(testBlueprintPrintProvider);
        assertEquals(testBlueprintPrintProvider, printSpecEntity.getBlueprintPrintProvider());
    }

    @Test
    void testColorsGetterSetter() {
        Set<PrintSpecColorEntity> testColors = new HashSet<>();
        testColors.add(new PrintSpecColorEntity());
        printSpecEntity.setColors(testColors);
        assertEquals(testColors, printSpecEntity.getColors());
    }

    @Test
    void testProductsGetterSetter() {
        Collection<ProductEntity> testProducts = Collections.emptyList();
        printSpecEntity.setProducts(testProducts);
        assertEquals(testProducts, printSpecEntity.getProducts());
    }

    @Test
    void testEquals() {
        PrintSpecEntity entity1 = new PrintSpecEntity();
        entity1.setPrintSpecId(1);
        entity1.setName("Name");

        PrintSpecEntity entity2 = new PrintSpecEntity();
        entity2.setPrintSpecId(1);
        entity2.setName("Name");

        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        printSpecEntity.setPrintSpecId(1);
        assertEquals(Objects.hash(1), printSpecEntity.hashCode());
    }
}
