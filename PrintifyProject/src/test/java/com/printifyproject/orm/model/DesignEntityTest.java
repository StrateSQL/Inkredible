package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesignEntityTest {

    private DesignEntity designEntity;

    @BeforeEach
    void setUp() {
        designEntity = new DesignEntity();
    }

    @Test
    void testDesignIdGetterSetter() {
        int testDesignId = 1;
        designEntity.setDesignId(testDesignId);
        assertEquals(testDesignId, designEntity.getDesignId());
    }

    @Test
    void testTitleGetterSetter() {
        String testTitle = "Test Title";
        designEntity.setTitle(testTitle);
        assertEquals(testTitle, designEntity.getTitle());
    }

    @Test
    void testDescriptionGetterSetter() {
        String testDescription = "Test Description";
        designEntity.setDescription(testDescription);
        assertEquals(testDescription, designEntity.getDescription());
    }

    @Test
    void testImageGetterSetter() {
        String testImage = "Test Image";
        designEntity.setImage(testImage);
        assertEquals(testImage, designEntity.getImage());
    }

    @Test
    void testEquals() {
        DesignEntity design1 = new DesignEntity();
        design1.setDesignId(1);
        design1.setTitle("Title");
        design1.setDescription("Description");
        design1.setImage("Image");

        DesignEntity design2 = new DesignEntity();
        design2.setDesignId(1);
        design2.setTitle("Title");
        design2.setDescription("Description");
        design2.setImage("Image");

        assertEquals(design1, design2);
    }

    @Test
    void testHashCode() {
        designEntity.setDesignId(1);
        designEntity.setTitle("Title");
        designEntity.setDescription("Description");
        designEntity.setImage("Image");

        assertEquals(Objects.hash(1, "Title", "Description", "Image"), designEntity.hashCode());
    }

    @Test
    void testProductsGetterSetter() {
        Collection<ProductEntity> testProducts = Collections.emptyList();
        designEntity.setProducts(testProducts);
        assertEquals(testProducts, designEntity.getProducts());
    }
}
