package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintProviderEntityTest {

    private PrintProviderEntity printProviderEntity;

    @BeforeEach
    void setUp() {
        printProviderEntity = new PrintProviderEntity();
    }

    @Test
    void testPrintProviderIdGetterSetter() {
        int id = 1;
        printProviderEntity.setPrintProviderId(id);
        assertEquals(id, printProviderEntity.getPrintProviderId());
    }

    @Test
    void testPrintProviderKeyGetterSetter() {
        Integer key = 100;
        printProviderEntity.setPrintProviderKey(key);
        assertEquals(key, printProviderEntity.getPrintProviderKey());
    }

    @Test
    void testNameGetterSetter() {
        String name = "Provider Name";
        printProviderEntity.setName(name);
        assertEquals(name, printProviderEntity.getName());
    }

    @Test
    void testRegionGetterSetter() {
        String region = "Provider Region";
        printProviderEntity.setRegion(region);
        assertEquals(region, printProviderEntity.getRegion());
    }

    @Test
    void testCountryGetterSetter() {
        String country = "Provider Country";
        printProviderEntity.setCountry(country);
        assertEquals(country, printProviderEntity.getCountry());
    }

    @Test
    void testEquals() {
        PrintProviderEntity provider1 = new PrintProviderEntity();
        provider1.setPrintProviderId(1);
        provider1.setName("Name");

        PrintProviderEntity provider2 = new PrintProviderEntity();
        provider2.setPrintProviderId(1);
        provider2.setName("Name");

        assertEquals(provider1, provider2);
    }

    @Test
    void testHashCode() {
        printProviderEntity.setPrintProviderId(1);
        printProviderEntity.setName("Name");

        assertEquals(Objects.hash(1, null, "Name", null, null), printProviderEntity.hashCode());
    }

    @Test
    void testBlueprintPrintProvidersGetterSetter() {
        Collection<BlueprintPrintProviderEntity> blueprintPrintProviders = Collections.emptyList();
        printProviderEntity.setBlueprintprintprovidersByPrintProviderId(blueprintPrintProviders);
        assertEquals(blueprintPrintProviders, printProviderEntity.getBlueprintprintprovidersByPrintProviderId());
    }
}
