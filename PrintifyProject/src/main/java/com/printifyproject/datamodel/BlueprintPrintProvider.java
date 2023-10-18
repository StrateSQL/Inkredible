package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "BlueprintPrintProviders")
public class BlueprintPrintProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlueprintPrintProviderId")
    private long blueprintPrintProviderId;

    private Blueprint blueprint;

    private PrintProvider printProvider;

    private Collection<Color> availableColors;

    private Collection<Size> availableSizes;

    //Constructor for hibernate
    public BlueprintPrintProvider() { }

    public long getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(long blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
    }

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        this.blueprint = blueprint;
    }

    public PrintProvider getPrintProvider() {
        return printProvider;
    }

    public void setPrintProvider(PrintProvider printProvider) {
        this.printProvider = printProvider;
    }

    public Collection<Color> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(Collection<Color> availableColors) {
        this.availableColors = availableColors;
    }

    public Collection<Size> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(Collection<Size> availableSizes) {
        this.availableSizes = availableSizes;
    }

}
