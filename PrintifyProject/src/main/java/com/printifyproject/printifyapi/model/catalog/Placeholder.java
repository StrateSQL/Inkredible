package com.printifyproject.printifyapi.model.catalog;

public class Placeholder {
    private String Position = "";
    private int Height;
    private int Width;

    public Placeholder() {
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        this.Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        this.Width = width;
    }
}
