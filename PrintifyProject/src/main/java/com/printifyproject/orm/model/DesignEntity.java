package com.printifyproject.orm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "designs", schema = "inkcredible")
public class DesignEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DesignId", nullable = false)
    private int designId;

    @Column(name = "Title", nullable = false, length = 255, unique = true)
    @NotNull
    @Size(max = 255)
    private String title;

    @Column(name = "Description", nullable = false, length = -1)
    @NotNull
    private String description;

    @Column(name = "Image", nullable = false, length = -1)
    @NotNull
    private String image;

    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<ProductEntity> products;

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

    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }

}
