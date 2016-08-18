package com.sky.product.controllers;

import com.sky.product.domain.Product;
import com.sky.product.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Adam on 17/08/2016.
 */
@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    /**
     * Returns a list of all the products that are available for the location specified.
     *
     * @param locationId the id of the location whose available products are to be retrieved
     * @return a list of products available in the specified location
     */
    @GetMapping(path = "/{locationId}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsForLocation(@PathVariable("locationId") Long locationId) {
        List<Product> products = locationService.getProductsForLocation(locationId);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
