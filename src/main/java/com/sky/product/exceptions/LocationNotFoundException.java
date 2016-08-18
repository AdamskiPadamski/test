package com.sky.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adam on 17/08/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long locationId) {
        super("Could not find location with id " + locationId);
    }

}
