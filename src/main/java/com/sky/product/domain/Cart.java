package com.sky.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 13/08/2016.
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = { "products", "customer" })
public class Cart {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @OneToOne
    private Customer customer;
    @ManyToMany
    private List<Product> products = new ArrayList<>();

    public void addCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.addCart(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.removeCart(this);
    }

}
