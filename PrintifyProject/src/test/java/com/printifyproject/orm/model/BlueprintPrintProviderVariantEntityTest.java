package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlueprintPrintProviderVariantEntityTest {

    private BlueprintPrintProviderVariantEntity entity;

    @BeforeEach
    void setUp() {
        entity = new BlueprintPrintProviderVariantEntity();
    }

    @Test
    void testIdGetterSetter() {
        int id = 1;
        entity.setId(id);
        assertEquals(id, entity.getId());
    }

    @Test
    void testBlueprintPrintProviderGetterSetter() {
        BlueprintPrintProviderEntity blueprintPrintProvider = new BlueprintPrintProviderEntity();
        entity.setBlueprintPrintProvider(blueprintPrintProvider);
        assertEquals(blueprintPrintProvider, entity.getBlueprintPrintProvider());
    }

    @Test
    void testVariantKeyGetterSetter() {
        int variantKey = 123;
        entity.setVariantKey(variantKey);
        assertEquals(variantKey, entity.getVariantKey());
    }

    @Test
    void testTitleGetterSetter() {
        String title = "Sample Title";
        entity.setTitle(title);
        assertEquals(title, entity.getTitle());
    }

    @Test
    void testSizeGetterSetter() {
        SizeEntity size = new SizeEntity();
        entity.setSize(size);
        assertEquals(size, entity.getSize());
    }

    @Test
    void testColorGetterSetter() {
        ColorEntity color = new ColorEntity();
        entity.setColor(color);
        assertEquals(color, entity.getColor());
    }
}
