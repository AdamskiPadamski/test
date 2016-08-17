package com.sky.product.repositories;

import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adam on 12/08/2016.
 */
@Repository
public interface ProductRepository extends OptionalCrudRepository<Product, Long> {

    List<Product> findByLocationEqualsOrLocationIsNull(Location location);

}
