package com.sky.product.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Adam on 12/08/2016.
 */
@Entity
@Data
@EqualsAndHashCode(of = "email")
@ToString(exclude = { "cart", "location" })
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToOne
    @NotNull
    private Location location;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Cart cart;

    public Customer() {
        cart = new Cart();
        cart.addCustomer(this);
    }

    public void addLocation(Location location) {
        this.location = location;
        location.addCustomer(this);
    }

}
