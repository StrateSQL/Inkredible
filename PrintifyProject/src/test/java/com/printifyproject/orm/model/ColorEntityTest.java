package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorEntityTest {

    private ColorEntity colorEntity;

    @BeforeEach
    void setUp() {
        colorEntity = new ColorEntity();
    }

    @Test
    void testIdGetterSetter() {
        int testId = 1;
        colorEntity.setId(testId);
        assertEquals(testId, colorEntity.getId());
    }

    @Test
    void testColorGetterSetter() {
        String testColor = "Red";
        colorEntity.setColor(testColor);
        assertEquals(testColor, colorEntity.getColor());
    }

    @Test
    void testHexGetterSetter() {
        String testHex = "#FF0000";
        colorEntity.setHex(testHex);
        assertEquals(testHex, colorEntity.getHex());
    }

    @Test
    void testBlueprintPrintProviderVariantsGetterSetter() {
        Set<BlueprintPrintProviderVariantEntity> variants = new HashSet<>();
        variants.add(new BlueprintPrintProviderVariantEntity());
        colorEntity.setBlueprintPrintProviderVariants(variants);
        assertEquals(variants, colorEntity.getBlueprintPrintProviderVariants());
    }
}
