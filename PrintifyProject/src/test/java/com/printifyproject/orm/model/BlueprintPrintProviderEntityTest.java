package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlueprintPrintProviderEntityTest {

    private BlueprintPrintProviderEntity entity;

    @BeforeEach
    void setUp() {
        entity = new BlueprintPrintProviderEntity();
    }

    @Test
    void testIdGetterSetter() {
        int id = 1;
        entity.setId(id);
        assertEquals(id, entity.getId());
    }

    @Test
    void testBlueprintGetterSetter() {
        BlueprintEntity blueprint = new BlueprintEntity();
        entity.setBlueprint(blueprint);
        assertEquals(blueprint, entity.getBlueprint());
    }

    @Test
    void testPrintProviderGetterSetter() {
        PrintProviderEntity printProvider = new PrintProviderEntity();
        entity.setPrintProvider(printProvider);
        assertEquals(printProvider, entity.getPrintProvider());
    }

    @Test
    void testColorsGetterSetter() {
        Set<BlueprintPrintProviderVariantEntity> colors = new HashSet<>();
        colors.add(new BlueprintPrintProviderVariantEntity());
        entity.setColors(colors);
        assertEquals(colors, entity.getColors());
    }

    @Test
    void testEquals() {
        BlueprintPrintProviderEntity entity1 = new BlueprintPrintProviderEntity();
        entity1.setId(1);

        BlueprintPrintProviderEntity entity2 = new BlueprintPrintProviderEntity();
        entity2.setId(1);

        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        entity.setId(1);
        assertEquals(Objects.hash(1), entity.hashCode());
    }
}
