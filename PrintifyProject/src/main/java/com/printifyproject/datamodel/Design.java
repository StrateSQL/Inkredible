package com.printifyproject.datamodel;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Designs", schema = "dbo", catalog = "printify-db")
public class Design {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DesignId", nullable = false)
    private int designId;
    @Basic
    @Column(name = "Title", nullable = true, length = 2147483647)
    private String title;
    @Basic
    @Column(name = "Description", nullable = true, length = 2147483647)
    private String description;
    @Basic
    @Column(name = "Image", nullable = true, length = 2147483647)
    private String image;
    @OneToMany(mappedBy = "designsByDesignId")
    private Collection<Product> productsByDesignId;

    public int getDesignId() {
        return designId;
    }

    public void setDesignId(int designId) {
        this.designId = designId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design = (Design) o;
        return designId == design.designId && Objects.equals(title, design.title) && Objects.equals(description, design.description) && Objects.equals(image, design.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designId, title, description, image);
    }

    public Collection<Product> getProductsByDesignId() {
        return productsByDesignId;
    }

    public void setProductsByDesignId(Collection<Product> productsByDesignId) {
        this.productsByDesignId = productsByDesignId;
    }
}
