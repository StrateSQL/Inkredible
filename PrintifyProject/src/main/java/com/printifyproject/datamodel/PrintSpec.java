package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "PrintSpecs")
public class PrintSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrintSpecId")
    private long printSpecId;

    @Column(name = "Name")
    private String name;

    @Column(name = "BlueprintPrintProviderId")
    private BlueprintPrintProvider blueprintPrintProvider;

    private Collection<Color> selectedColors;

    private Collection<Size> selectedSizes;

    @Column(name = "GossMargin")
    private float grossMargin;

    //Constructor for hibernate
    public PrintSpec() { }

    public long getPrintSpecId() {
        return printSpecId;
    }

    public void setPrintSpecId(long printSpecId) {
        this.printSpecId = printSpecId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlueprintPrintProvider getBlueprintPrintProvider() {
        return blueprintPrintProvider;
    }

    public void setBlueprintPrintProvider(BlueprintPrintProvider blueprintPrintProvider) {
        this.blueprintPrintProvider = blueprintPrintProvider;
    }

    public Collection<Color> getSelectedColors() {
        return selectedColors;
    }

    public void setSelectedColors(Collection<Color> selectedColors) {
        this.selectedColors = selectedColors;
    }

    public Collection<Size> getSelectedSizes() {
        return selectedSizes;
    }

    public void setSelectedSizes(Collection<Size> selectedSizes) {
        this.selectedSizes = selectedSizes;
    }

    public float getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(float grossMargin) {
        this.grossMargin = grossMargin;
    }
}
