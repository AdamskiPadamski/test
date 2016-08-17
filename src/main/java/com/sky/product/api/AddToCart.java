package com.sky.product.api;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Created by Adam on 15/08/2016.
 */
@Data
@ToString
public class AddToCart {

    @NotNull
    private Long productId;

}
