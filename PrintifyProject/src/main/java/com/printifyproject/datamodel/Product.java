package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private long productId;

    @Column(name = "ProductKey")
    private String productKey;

    private Design design;

    private PrintSpec printSpec;

    @Column(name = "IsPublished")
    private boolean isPublished;

    //Constructor for hibernate
    public Product() { }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public PrintSpec getPrintSpec() {
        return printSpec;
    }

    public void setPrintSpec(PrintSpec printSpec) {
        this.printSpec = printSpec;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}
