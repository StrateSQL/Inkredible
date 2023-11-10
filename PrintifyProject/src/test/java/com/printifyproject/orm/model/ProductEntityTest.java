package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductEntityTest {

    private ProductEntity productEntity;
    private DesignEntity designEntity;
    private PrintSpecEntity printSpecEntity;

    @BeforeEach
    void setUp() {
        productEntity = new ProductEntity();
        designEntity = new DesignEntity();
        printSpecEntity = new PrintSpecEntity();
    }

    @Test
    void testProductIdGetterSetter() {
        int testId = 1;
        productEntity.setProductId(testId);
        assertEquals(testId, productEntity.getProductId());
    }

    @Test
    void testProductKeyGetterSetter() {
        String testKey = "12345";
        productEntity.setProductKey(testKey);
        assertEquals(testKey, productEntity.getProductKey());
    }

    @Test
    void testIsPublishedGetterSetter() {
        productEntity.setPublished(true);
        assertTrue(productEntity.isPublished());
    }

    @Test
    void testDesignGetterSetter() {
        DesignEntity testDesign = new DesignEntity();
        productEntity.setDesign(testDesign);
        assertEquals(testDesign, productEntity.getDesign());
    }

    @Test
    void testPrintSpecGetterSetter() {
        PrintSpecEntity testPrintSpec = new PrintSpecEntity();
        productEntity.setPrintSpec(testPrintSpec);
        assertEquals(testPrintSpec, productEntity.getPrintSpec());
    }

    @Test
    void testEquals() {
        ProductEntity entity1 = new ProductEntity();
        entity1.setProductKey("12345");
        entity1.setPublished(true);

        ProductEntity entity2 = new ProductEntity();
        entity2.setProductKey("12345");
        entity2.setPublished(true);

        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        productEntity.setProductKey("12345");
        productEntity.setPublished(true);
        productEntity.setDesign(designEntity);
        productEntity.setPrintSpec(printSpecEntity);
        assertEquals(Objects.hash("12345", true, designEntity, printSpecEntity), productEntity.hashCode());
    }
}
