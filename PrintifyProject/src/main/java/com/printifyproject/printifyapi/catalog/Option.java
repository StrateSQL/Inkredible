package com.printifyproject.printifyapi.catalog;

public class Option {
    private String Size = "";
    private String Color = "";

    public Option() {
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        this.Size = size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }
}
