package com.sky.product.services;

import com.sky.product.domain.Customer;
import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.exceptions.*;
import com.sky.product.repositories.CustomerRepository;
import com.sky.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adam on 14/08/2016.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    /**
     * Returns a list of products available to the customer i.e. their catalogue
     *
     * @param customerId the id of the customer whose catalogue is to be retrieved
     * @return list of products in the customer's catalogue
     * @throws CustomerNotFoundException if customer with specified id is not found
     */
    public List<Product> getCustomerCatalogue(Long customerId) {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));

        return productRepository.findByLocationEqualsOrLocationIsNull(customer.getLocation());
    }

    /**
     * Returns the location of a specified customer
     *
     * @param customerId the id of the customer whose location is to be retrieved
     * @return the location of the specified customer
     * @throws CustomerNotFoundException if customer with specified id is not found
     */
    public Location getCustomerLocation(Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));

        return customer.getLocation();
    }

}
