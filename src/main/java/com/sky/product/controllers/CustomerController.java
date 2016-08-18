package com.sky.product.controllers;

import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Adam on 14/08/2016.
 */
@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * Returns a list of products that are available to the customer i.e. the catalogue.
     * The 'catalogue' is an abstract resource, with no physical representation on the server.
     * If the customer is not found, a 404 is returned with a body explaining the issue.
     *
     * @param customerId the id of the customer whose catalogue is to be retrieved
     * @return a list containing all of the products available to the customer i.e. the catalogue
     */
    @GetMapping(path = "/{customerId}/catalogue", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getCustomerCatalogue(@PathVariable("customerId") Long customerId) {
        List<Product> products = customerService.getCustomerCatalogue(customerId);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Returns the location of the requested customer.
     *
     * @param customerId the id of the customer whose location is to be retrieved
     * @return the customer's location
     */
    @GetMapping(path = "/{customerId}/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getCustomerLocation(@PathVariable("customerId") Long customerId) {
        Location location = customerService.getCustomerLocation(customerId);

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
