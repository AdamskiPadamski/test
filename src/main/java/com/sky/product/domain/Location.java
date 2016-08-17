package com.sky.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 12/08/2016.
 */
@Entity
@Data
@EqualsAndHashCode(of = "name")
@ToString(exclude = { "customers", "products" })
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    private String name;
    @OneToMany
    @JsonIgnore
    private List<Customer> customers = new ArrayList<>();
    @OneToMany
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}
