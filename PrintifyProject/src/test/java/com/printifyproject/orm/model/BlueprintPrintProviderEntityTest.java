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
        Set<BlueprintPrintProviderVariantEntity> variants = new HashSet<>();
        BlueprintPrintProviderVariantEntity variant = new BlueprintPrintProviderVariantEntity();
        ColorEntity color = new ColorEntity();
        color.setColor("Green");
        variant.setColor(color);
        variant.setVariantKey(123456);
        variant.setSize("XXXL");

        variants.add(new BlueprintPrintProviderVariantEntity());
        entity.setBlueprintPrintProviderVariants(variants);
        assertEquals(variants, entity.getBlueprintPrintProviderVariants());
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
