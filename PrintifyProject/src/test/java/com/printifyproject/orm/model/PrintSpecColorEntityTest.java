package com.printifyproject.orm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintSpecColorEntityTest {

    private PrintSpecColorEntity printSpecColorEntity;
    private PrintSpecEntity printSpec;
    private ColorEntity color;

    @BeforeEach
    void setUp() {
        printSpecColorEntity = new PrintSpecColorEntity();
        printSpec = new PrintSpecEntity();
        color = new ColorEntity();
    }

    @Test
    void testPrintSpecColorIdGetterSetter() {
        int testId = 1;
        printSpecColorEntity.setPrintSpecColorId(testId);
        assertEquals(testId, printSpecColorEntity.getPrintSpecColorId());
    }

    @Test
    void testPrintSpecGetterSetter() {
        printSpecColorEntity.setPrintSpec(printSpec);
        assertEquals(printSpec, printSpecColorEntity.getPrintSpec());
    }

    @Test
    void testColorGetterSetter() {
        printSpecColorEntity.setColor(color);
        assertEquals(color, printSpecColorEntity.getColor());
    }

    @Test
    void testEquals() {
        PrintSpecColorEntity entity1 = new PrintSpecColorEntity(printSpec, color);
        PrintSpecColorEntity entity2 = new PrintSpecColorEntity(printSpec, color);

        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCode() {
        printSpecColorEntity.setPrintSpecColorId(1);
        assertEquals(Objects.hash(1), printSpecColorEntity.hashCode());
    }
}
