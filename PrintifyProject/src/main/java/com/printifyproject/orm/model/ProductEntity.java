package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products", schema = "inkcredible", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductId", nullable = false)
    private int productId;
    @Basic
    @Column(name = "ProductKey", nullable = true, length = -1)
    private String productKey;
    @Basic
    @Column(name = "DesignId", nullable = true, insertable = false, updatable = false)
    private Integer designId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true, insertable = false, updatable = false)
    private Integer printSpecId;
    @Basic
    @Column(name = "IsPublished", nullable = true)
    private Byte isPublished;
    @ManyToOne
    @JoinColumn(name = "DesignId")
    private DesignEntity design;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId")
    private PrintSpecEntity printSpec;

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

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public Integer getPrintSpecId() {
        return printSpecId;
    }

    public void setPrintSpecId(Integer printSpecId) {
        this.printSpecId = printSpecId;
    }

    public Byte getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Byte isPublished) {
        this.isPublished = isPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && Objects.equals(productKey, that.productKey) && Objects.equals(designId, that.designId) && Objects.equals(printSpecId, that.printSpecId) && Objects.equals(isPublished, that.isPublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productKey, designId, printSpecId, isPublished);
    }

    public DesignEntity getDesign() {
        return design;
    }

    public void setDesign(DesignEntity designsByDesignId) {
        this.design = designsByDesignId;
    }

    public PrintSpecEntity getPrintSpec() {
        return printSpec;
    }

    public void setPrintSpec(PrintSpecEntity printspecsByPrintSpecId) {
        this.printSpec = printspecsByPrintSpecId;
    }
}
