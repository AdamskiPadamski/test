package com.sky.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 12/08/2016.
 */
@Entity
@Data
@EqualsAndHashCode(of = "name")
@ToString(exclude = { "location" })
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

}
