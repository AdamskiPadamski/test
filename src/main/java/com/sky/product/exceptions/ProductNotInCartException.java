package com.sky.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adam on 16/08/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotInCartException extends RuntimeException {

    public ProductNotInCartException(Long customerId, Long productId) {
        super("Product with id " + productId + " was not found in cart of customer with id " + customerId);
    }
}
