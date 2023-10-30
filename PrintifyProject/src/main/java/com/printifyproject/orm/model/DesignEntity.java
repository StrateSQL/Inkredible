package com.printifyproject.orm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "designs", schema = "inkcredible", catalog = "")
public class DesignEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DesignId", nullable = false)
    private int designId;
    @Basic
    @Column(name = "Title", nullable = true, length = 255)
    private String title;
    @Basic
    @Column(name = "Description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "Image", nullable = true, length = -1)
    private String image;
    @OneToMany(mappedBy = "design")
    private Collection<ProductEntity> productsByDesignId;

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
        DesignEntity that = (DesignEntity) o;
        return designId == that.designId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designId, title, description, image);
    }

    public Collection<ProductEntity> getProductsByDesignId() {
        return productsByDesignId;
    }

    public void setProductsByDesignId(Collection<ProductEntity> productsByDesignId) {
        this.productsByDesignId = productsByDesignId;
    }
}
