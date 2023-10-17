package com.printifyproject.printifyapi.model.catalog;

public class HandlingTime {
    // Properties
    private int value;
    private String unit = "";

    // Constructors
    public HandlingTime() {
    }

    // Getter and Setter for 'value'
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Getter and Setter for 'unit'
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
