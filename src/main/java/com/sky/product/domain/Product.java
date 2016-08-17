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
@ToString(exclude = { "location", "carts" })
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    private String name;
    private String category;
    @ManyToOne
    private Location location;
    @ManyToMany
    @JsonIgnore
    private List<Cart> carts = new ArrayList<>();

    public void addLocation(Location location) {
        this.location = location;
        location.addProduct(this);
    }

    public void removeLocation() {
        location.removeProduct(this);
        this.location = null;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void removeCart(Cart cart) {
        carts.remove(cart);
    }

}
