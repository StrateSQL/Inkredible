package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlueprintEntityTest {

    private BlueprintEntity blueprintEntity;

    @BeforeEach
    void setUp() {
        blueprintEntity = new BlueprintEntity();
    }

    @Test
    void testBlueprintIdGetterSetter() {
        int id = 1;
        blueprintEntity.setBlueprintId(id);
        assertEquals(id, blueprintEntity.getBlueprintId());
    }

    @Test
    void testBlueprintKeyGetterSetter() {
        Integer key = 123;
        blueprintEntity.setBlueprintKey(key);
        assertEquals(key, blueprintEntity.getBlueprintKey());
    }

    @Test
    void testTitleGetterSetter() {
        String title = "Sample Title";
        blueprintEntity.setTitle(title);
        assertEquals(title, blueprintEntity.getTitle());
    }

    @Test
    void testModelGetterSetter() {
        String model = "Sample Model";
        blueprintEntity.setModel(model);
        assertEquals(model, blueprintEntity.getModel());
    }

    @Test
    void testBrandGetterSetter() {
        String brand = "Sample Brand";
        blueprintEntity.setBrand(brand);
        assertEquals(brand, blueprintEntity.getBrand());
    }

    @Test
    void testDescriptionGetterSetter() {
        String description = "Sample Description";
        blueprintEntity.setDescription(description);
        assertEquals(description, blueprintEntity.getDescription());
    }

    @Test
    void testEquals() {
        BlueprintEntity entity1 = new BlueprintEntity();
        entity1.setBlueprintId(1);
        entity1.setTitle("Title");

        BlueprintEntity entity2 = new BlueprintEntity();
        entity2.setBlueprintId(1);
        entity2.setTitle("Title");

        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        BlueprintEntity entity = new BlueprintEntity();
        entity.setBlueprintId(1);
        entity.setTitle("Title");

        int expectedHashCode = Objects.hash(entity.getBlueprintId(), entity.getBlueprintKey(),
                entity.getTitle(), entity.getModel(),
                entity.getBrand(), entity.getDescription());
        assertEquals(expectedHashCode, entity.hashCode());
    }

    @Test
    void testBlueprintPrintProvidersGetterSetter() {
        Collection<BlueprintPrintProviderEntity> providers = Collections.emptyList();
        blueprintEntity.setBlueprintPrintProviders(providers);
        assertEquals(providers, blueprintEntity.getBlueprintPrintProviders());
    }

}
