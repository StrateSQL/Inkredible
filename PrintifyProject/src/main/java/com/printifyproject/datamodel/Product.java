package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Products", schema = "dbo", catalog = "printify-db")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductId", nullable = false)
    private int productId;
    @Basic
    @Column(name = "ProductKey", nullable = true, length = 2147483647)
    private String productKey;
    @Basic
    @Column(name = "DesignId", nullable = true)
    private Integer designId;
    @Basic
    @Column(name = "PrintSpecId", nullable = true)
    private Integer printSpecId;
    @Basic
    @Column(name = "IsPublished", nullable = true)
    private Boolean isPublished;
    @ManyToOne
    @JoinColumn(name = "DesignId", referencedColumnName = "DesignId")
    private Design designsByDesignId;
    @ManyToOne
    @JoinColumn(name = "PrintSpecId", referencedColumnName = "PrintSpecId")
    private PrintSpec printSpecsByPrintSpecId;

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

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(productKey, product.productKey) && Objects.equals(designId, product.designId) && Objects.equals(printSpecId, product.printSpecId) && Objects.equals(isPublished, product.isPublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productKey, designId, printSpecId, isPublished);
    }

    public Design getDesignsByDesignId() {
        return designsByDesignId;
    }

    public void setDesignsByDesignId(Design designsByDesignId) {
        this.designsByDesignId = designsByDesignId;
    }

    public PrintSpec getPrintSpecsByPrintSpecId() {
        return printSpecsByPrintSpecId;
    }

    public void setPrintSpecsByPrintSpecId(PrintSpec printSpecsByPrintSpecId) {
        this.printSpecsByPrintSpecId = printSpecsByPrintSpecId;
    }
}
