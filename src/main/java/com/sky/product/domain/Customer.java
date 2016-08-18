package com.sky.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ToString(exclude = { "location" })
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
    @JsonIgnore
    private String password;
    @ManyToOne
    @NotNull
    private Location location;

    public void addLocation(Location location) {
        this.location = location;
        location.addCustomer(this);
    }

}
