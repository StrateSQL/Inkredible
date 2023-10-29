package com.printifyproject.printifyapi.catalog;

public class ProfileItem {
    private String Currency = "";

    private int Cost;

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        this.Cost = cost;
    }
}
