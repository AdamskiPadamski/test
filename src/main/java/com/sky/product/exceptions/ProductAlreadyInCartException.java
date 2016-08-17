package com.sky.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adam on 16/08/2016.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductAlreadyInCartException extends RuntimeException {

    public ProductAlreadyInCartException(Long customerId, Long productId) {
        super("Product with id " + productId + " already among products of cart for customer with id " + customerId);
    }
}
