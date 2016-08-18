package com.sky.product.services;

import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.exceptions.LocationNotFoundException;
import com.sky.product.repositories.LocationRepository;
import com.sky.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adam on 17/08/2016.
 */
@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProductRepository productRepository;

    /**
     * Returns a list of the products available in the specified location
     *
     * @param locationId the id of the location whose available products are to be retrieved
     * @return the list of available products for the specified location
     * @throws LocationNotFoundException if customer with specified id is not found
     */
    public List<Product> getProductsForLocation(Long locationId) {
        Location location = locationRepository.findOne(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));

        return productRepository.findByLocationEqualsOrLocationIsNull(location);
    }
}
