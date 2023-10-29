package com.printifyproject.printifyapi.catalog;

public class PrintDetail {
    private String printOnSide;
    private String separatorType;
    private String separatorColor;

    public String getPrintOnSide() {
        return printOnSide;
    }

    public void setPrintOnSide(String printOnSide) {
        this.printOnSide = printOnSide;
    }

    public String getSeparatorType() {
        return separatorType;
    }

    public void setSeparatorType(String separatorType) {
        this.separatorType = separatorType;
    }

    public String getSeparatorColor() {
        return separatorColor;
    }

    public void setSeparatorColor(String separatorColor) {
        this.separatorColor = separatorColor;
    }
}
