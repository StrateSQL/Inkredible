package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "PrintProviders")
public class PrintProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrintProviderId")
    private long printProviderId;

    @Column(name = "PrintProviderKey")
    private int printProviderKey;

    @Column(name = "Name")
    private String name;

    @Column(name = "Region")
    private String region;

    @Column(name = "Country")
    private String country;

    //Constructor for hibernate
    public PrintProvider() { }

    public long getPrintProviderId() {
        return printProviderId;
    }

    public void setPrintProviderId(long printProviderId) {
        this.printProviderId = printProviderId;
    }

    public int getPrintProviderKey() {
        return printProviderKey;
    }

    public void setPrintProviderKey(int printProviderKey) {
        this.printProviderKey = printProviderKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
