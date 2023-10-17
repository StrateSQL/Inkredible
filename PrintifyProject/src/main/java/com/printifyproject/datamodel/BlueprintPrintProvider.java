package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BlueprintPrintProviders", schema = "dbo", catalog = "printify-db")
public class BlueprintPrintProvider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderId", nullable = false)
    private int blueprintPrintProviderId;
    @Basic
    @Column(name = "BlueprintId", nullable = true)
    private Integer blueprintId;
    @Basic
    @Column(name = "PrintProviderId", nullable = true)
    private Integer printProviderId;
    @OneToMany(mappedBy = "blueprintPrintProvidersByBlueprintPrintProviderId")
    private Collection<BlueprintPrintProviderColor> blueprintPrintProviderColorsByBlueprintPrintProviderId;
    @OneToMany(mappedBy = "blueprintPrintProvidersByBlueprintPrintProviderId")
    private Collection<BlueprintPrintProviderSize> blueprintPrintProviderSizesByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "BlueprintId", referencedColumnName = "BlueprintId")
    private Blueprint blueprintsByBlueprintId;
    @ManyToOne
    @JoinColumn(name = "PrintProviderId", referencedColumnName = "PrintProviderId")
    private PrintProvider printProvidersByPrintProviderId;
    @OneToMany(mappedBy = "blueprintPrintProvidersByBlueprintPrintProviderId")
    private Collection<PrintSpec> printSpecsByBlueprintPrintProviderId;

    public int getBlueprintPrintProviderId() {
        return blueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderId(int blueprintPrintProviderId) {
        this.blueprintPrintProviderId = blueprintPrintProviderId;
    }

    public Integer getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(Integer blueprintId) {
        this.blueprintId = blueprintId;
    }

    public Integer getPrintProviderId() {
        return printProviderId;
    }

    public void setPrintProviderId(Integer printProviderId) {
        this.printProviderId = printProviderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueprintPrintProvider that = (BlueprintPrintProvider) o;
        return blueprintPrintProviderId == that.blueprintPrintProviderId && Objects.equals(blueprintId, that.blueprintId) && Objects.equals(printProviderId, that.printProviderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderId, blueprintId, printProviderId);
    }

    public Collection<BlueprintPrintProviderColor> getBlueprintPrintProviderColorsByBlueprintPrintProviderId() {
        return blueprintPrintProviderColorsByBlueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderColorsByBlueprintPrintProviderId(Collection<BlueprintPrintProviderColor> blueprintPrintProviderColorsByBlueprintPrintProviderId) {
        this.blueprintPrintProviderColorsByBlueprintPrintProviderId = blueprintPrintProviderColorsByBlueprintPrintProviderId;
    }

    public Collection<BlueprintPrintProviderSize> getBlueprintPrintProviderSizesByBlueprintPrintProviderId() {
        return blueprintPrintProviderSizesByBlueprintPrintProviderId;
    }

    public void setBlueprintPrintProviderSizesByBlueprintPrintProviderId(Collection<BlueprintPrintProviderSize> blueprintPrintProviderSizesByBlueprintPrintProviderId) {
        this.blueprintPrintProviderSizesByBlueprintPrintProviderId = blueprintPrintProviderSizesByBlueprintPrintProviderId;
    }

    public Blueprint getBlueprintsByBlueprintId() {
        return blueprintsByBlueprintId;
    }

    public void setBlueprintsByBlueprintId(Blueprint blueprintsByBlueprintId) {
        this.blueprintsByBlueprintId = blueprintsByBlueprintId;
    }

    public PrintProvider getPrintProvidersByPrintProviderId() {
        return printProvidersByPrintProviderId;
    }

    public void setPrintProvidersByPrintProviderId(PrintProvider printProvidersByPrintProviderId) {
        this.printProvidersByPrintProviderId = printProvidersByPrintProviderId;
    }

    public Collection<PrintSpec> getPrintSpecsByBlueprintPrintProviderId() {
        return printSpecsByBlueprintPrintProviderId;
    }

    public void setPrintSpecsByBlueprintPrintProviderId(Collection<PrintSpec> printSpecsByBlueprintPrintProviderId) {
        this.printSpecsByBlueprintPrintProviderId = printSpecsByBlueprintPrintProviderId;
    }
}
