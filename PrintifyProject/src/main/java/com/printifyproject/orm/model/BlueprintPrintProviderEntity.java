package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "blueprintprintproviders", schema = "inkcredible")
public class BlueprintPrintProviderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BlueprintPrintProviderId", nullable = false)
    private int blueprintPrintProviderId;
    @Basic
    @Column(name = "BlueprintId", nullable = true, insertable = false, updatable = false)
    private Integer blueprintId;
    @Basic
    @Column(name = "PrintProviderId", nullable = true, insertable = false, updatable = false)
    private Integer printProviderId;
    @OneToMany(mappedBy = "blueprintprintprovidersByBlueprintPrintProviderId")
    private Collection<BlueprintPrintProviderColorEntity> blueprintprintprovidercolorsByBlueprintPrintProviderId;
    @ManyToOne
    @JoinColumn(name = "BlueprintId", referencedColumnName = "BlueprintId")
    private BlueprintEntity blueprintsByBlueprintId;
    @ManyToOne
    @JoinColumn(name = "PrintProviderId", referencedColumnName = "PrintProviderId")
    private PrintProviderEntity printprovidersByPrintProviderId;
    @OneToMany(mappedBy = "blueprintprintprovidersByBlueprintPrintProviderId")
    private Collection<BlueprintPrintProviderSizeEntity> blueprintprintprovidersizesByBlueprintPrintProviderId;
    @OneToMany(mappedBy = "blueprintprintprovidersByBlueprintPrintProviderId")
    private Collection<PrintSpecEntity> printspecsByBlueprintPrintProviderId;

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
        BlueprintPrintProviderEntity that = (BlueprintPrintProviderEntity) o;
        return blueprintPrintProviderId == that.blueprintPrintProviderId && Objects.equals(blueprintId, that.blueprintId) && Objects.equals(printProviderId, that.printProviderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueprintPrintProviderId, blueprintId, printProviderId);
    }

    public Collection<BlueprintPrintProviderColorEntity> getBlueprintprintprovidercolorsByBlueprintPrintProviderId() {
        return blueprintprintprovidercolorsByBlueprintPrintProviderId;
    }

    public void setBlueprintprintprovidercolorsByBlueprintPrintProviderId(Collection<BlueprintPrintProviderColorEntity> blueprintprintprovidercolorsByBlueprintPrintProviderId) {
        this.blueprintprintprovidercolorsByBlueprintPrintProviderId = blueprintprintprovidercolorsByBlueprintPrintProviderId;
    }

    public BlueprintEntity getBlueprintsByBlueprintId() {
        return blueprintsByBlueprintId;
    }

    public void setBlueprintsByBlueprintId(BlueprintEntity blueprintsByBlueprintId) {
        this.blueprintsByBlueprintId = blueprintsByBlueprintId;
    }

    public PrintProviderEntity getPrintprovidersByPrintProviderId() {
        return printprovidersByPrintProviderId;
    }

    public void setPrintprovidersByPrintProviderId(PrintProviderEntity printprovidersByPrintProviderId) {
        this.printprovidersByPrintProviderId = printprovidersByPrintProviderId;
    }

    public Collection<BlueprintPrintProviderSizeEntity> getBlueprintprintprovidersizesByBlueprintPrintProviderId() {
        return blueprintprintprovidersizesByBlueprintPrintProviderId;
    }

    public void setBlueprintprintprovidersizesByBlueprintPrintProviderId(Collection<BlueprintPrintProviderSizeEntity> blueprintprintprovidersizesByBlueprintPrintProviderId) {
        this.blueprintprintprovidersizesByBlueprintPrintProviderId = blueprintprintprovidersizesByBlueprintPrintProviderId;
    }

    public Collection<PrintSpecEntity> getPrintspecsByBlueprintPrintProviderId() {
        return printspecsByBlueprintPrintProviderId;
    }

    public void setPrintspecsByBlueprintPrintProviderId(Collection<PrintSpecEntity> printspecsByBlueprintPrintProviderId) {
        this.printspecsByBlueprintPrintProviderId = printspecsByBlueprintPrintProviderId;
    }
}
