package com.sky.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by Adam on 12/08/2016.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    private String name;
    private String category;
    @ManyToOne
    @JsonIgnore
    private Location location;

    public void addLocation(Location location) {
        this.location = location;
        location.addProduct(this);
    }

    public void removeLocation() {
        location.removeProduct(this);
        this.location = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
