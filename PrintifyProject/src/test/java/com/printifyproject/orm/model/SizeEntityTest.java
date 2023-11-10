package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeEntityTest {

    private SizeEntity sizeEntity;

    @BeforeEach
    void setUp() {
        sizeEntity = new SizeEntity();
    }

    @Test
    void testIdGetterSetter() {
        int testId = 1;
        sizeEntity.setId(testId);
        assertEquals(testId, sizeEntity.getId(), "Getter or setter for id is not working correctly");
    }

    @Test
    void testSizeGetterSetter() {
        String testSize = "Medium";
        sizeEntity.setSize(testSize);
        assertEquals(testSize, sizeEntity.getSize(), "Getter or setter for size is not working correctly");
    }

    @Test
    void testBlueprintPrintProviderVariantsGetterSetter() {
        Set<BlueprintPrintProviderVariantEntity> testVariants = new HashSet<>();
        testVariants.add(new BlueprintPrintProviderVariantEntity());
        sizeEntity.setBlueprintPrintProviderVariants(testVariants);
        assertEquals(testVariants, sizeEntity.getBlueprintPrintProviderVariants(), "Getter or setter for blueprintPrintProviderVariants is not working correctly");
    }

}
