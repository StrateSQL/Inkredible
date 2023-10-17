package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PrintProviders", schema = "dbo", catalog = "printify-db")
public class PrintProvider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PrintProviderId", nullable = false)
    private int printProviderId;
    @Basic
    @Column(name = "PrintProviderKey", nullable = true)
    private Integer printProviderKey;
    @Basic
    @Column(name = "Name", nullable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "Region", nullable = true, length = 2147483647)
    private String region;
    @Basic
    @Column(name = "Country", nullable = true, length = 2147483647)
    private String country;
    @OneToMany(mappedBy = "printProvidersByPrintProviderId")
    private Collection<BlueprintPrintProvider> blueprintPrintProvidersByPrintProviderId;

    public int getPrintProviderId() {
        return printProviderId;
    }

    public void setPrintProviderId(int printProviderId) {
        this.printProviderId = printProviderId;
    }

    public Integer getPrintProviderKey() {
        return printProviderKey;
    }

    public void setPrintProviderKey(Integer printProviderKey) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintProvider that = (PrintProvider) o;
        return printProviderId == that.printProviderId && Objects.equals(printProviderKey, that.printProviderKey) && Objects.equals(name, that.name) && Objects.equals(region, that.region) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printProviderId, printProviderKey, name, region, country);
    }

    public Collection<BlueprintPrintProvider> getBlueprintPrintProvidersByPrintProviderId() {
        return blueprintPrintProvidersByPrintProviderId;
    }

    public void setBlueprintPrintProvidersByPrintProviderId(Collection<BlueprintPrintProvider> blueprintPrintProvidersByPrintProviderId) {
        this.blueprintPrintProvidersByPrintProviderId = blueprintPrintProvidersByPrintProviderId;
    }
}
