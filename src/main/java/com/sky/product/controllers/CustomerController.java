package com.sky.product.controllers;

import com.sky.product.api.AddToCart;
import com.sky.product.domain.Product;
import com.sky.product.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
     * Returns the list of products currently in the specified customer's cart.
     * If the customer is not found, a 404 is returned with a body explaining the issue
     *
     * @param customerId the id of the customer whose cart products are to be retrieved
     * @return a list containing all of the products in the customer's cart
     */
    @GetMapping(path = "/{customerId}/cart/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getCustomerCartContents(@PathVariable("customerId") Long customerId) {
        List<Product> cartContents = customerService.getProductsInCustomerCart(customerId);

        return new ResponseEntity<>(cartContents, HttpStatus.OK);
    }

    /**
     * Adds the product with the id of that in the body to the products of the specified customer's cart.
     * If the customer or product is not found, a 404 is returned with a body explaining the issue.
     *
     * @param customerId the id of the customer whose cart is to be added to
     * @param addToCart an object containing the id of the product the customer wishes to add to their cart
     * @return an http status code of 201 on success
     */
    @PostMapping(path = "/{customerId}/cart/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductToCustomerCart(@PathVariable("customerId") Long customerId, @RequestBody @Valid AddToCart addToCart) {
        customerService.addProductToCustomerCart(customerId, addToCart.getProductId());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * Deletes a product specified by its id from the products in the cart of the specified customer.
     * If the customer is not found or the product is not in the customer's cart, a 404 is returned with a body
     * explaining the issue.
     *
     * @param customerId the id of the customer whose cart we wish to delete from
     * @param productId the id of the product the customer wishes to remove from their cart
     * @return an http status code of 204 on success
     */
    @DeleteMapping(path = "/{customerId}/cart/products/{productId}")
    public ResponseEntity deleteFromCustomerCart(@PathVariable("customerId") Long customerId, @PathVariable("productId") Long productId) {
        customerService.deleteProductFromCustomerCart(customerId, productId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
