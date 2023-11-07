package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products", schema = "inkcredible")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductId", nullable = false)
    private int productId;

    @Column(name = "ProductKey", nullable = true, length = -1, unique = true)
    private String productKey;

    @Column(name = "IsPublished")
    private boolean isPublished = false;
    @ManyToOne
    @JoinColumn(name = "DesignId")
    private DesignEntity design;

    @ManyToOne
    @JoinColumn(name = "PrintSpecId")
    private PrintSpecEntity printSpec;

    public ProductEntity() {
    }

    public ProductEntity(DesignEntity design, PrintSpecEntity printSpec) {
        this.isPublished = false;
        this.design = design;
        this.printSpec = printSpec;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public DesignEntity getDesign() {
        return design;
    }

    public void setDesign(DesignEntity design) {
        this.design = design;
    }

    public PrintSpecEntity getPrintSpec() {
        return printSpec;
    }

    public void setPrintSpec(PrintSpecEntity printSpec) {
        this.printSpec = printSpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return isPublished == that.isPublished && Objects.equals(productKey, that.productKey) && Objects.equals(design, that.design) && Objects.equals(printSpec, that.printSpec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productKey, isPublished, design, printSpec);
    }
}
