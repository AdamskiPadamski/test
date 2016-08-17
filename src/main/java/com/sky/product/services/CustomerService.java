package com.sky.product.services;

import com.sky.product.domain.Cart;
import com.sky.product.domain.Customer;
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
     */
    public List<Product> getCustomerCatalogue(Long customerId) {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));

        return productRepository.findByLocationEqualsOrLocationIsNull(customer.getLocation());
    }

    /**
     * Returns the products in the specified customer's basket
     *
     * @param customerId the id of the customer whose basket's products are to be retrieved
     * @return list of products in the customer's basket
     */
    public List<Product> getProductsInCustomerCart(Long customerId) {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));

        return customer.getCart().getProducts();
    }

    /**
     * Adds the product with the specified id to the basket of the customer with the specified id
     *
     * @param customerId the id of the customer whose basket is to be added to
     * @param productId the id of the product that is to be added to the basket
     */
    public void addProductToCustomerCart(Long customerId, Long productId) {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        Product product = productRepository.findOne(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        if (!customer.getCart().getProducts().contains(product)) {
            customer.getCart().addProduct(product);
            customerRepository.save(customer);
        } else {
            throw new ProductAlreadyInCartException(customerId, productId);
        }

    }

    /**
     * Deletes the product with specified id from the basket of the customer with the specified id
     *
     * @param customerId the id of the customer whose basket is to be modified
     * @param productId the id of the product to add to the basket
     */
    public void deleteProductFromCustomerCart(Long customerId, Long productId) {
        Customer customer = customerRepository.findOne(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        Product product = productRepository.findOne(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        Cart cart = customer.getCart();
        if (cart.getProducts().contains(product)) {
            cart.removeProduct(product);
        } else {
            throw new ProductNotInCartException(customerId, productId);
        }

        customerRepository.save(customer);
    }

}
