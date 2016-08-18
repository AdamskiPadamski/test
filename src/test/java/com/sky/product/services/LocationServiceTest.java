package com.sky.product.services;

import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.exceptions.LocationNotFoundException;
import com.sky.product.repositories.LocationRepository;
import com.sky.product.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Adam on 18/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {

    @InjectMocks
    LocationService locationService;

    @Mock
    LocationRepository locationRepository;

    @Mock
    ProductRepository productRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(locationService).build();
    }

    @Test
    public void testSuccessGetCustomerCatalogue() {
        Location location = new Location();
        location.addProduct(new Product());

        when(locationRepository.findOne(any(Long.class))).thenReturn(Optional.of(location));
        when(productRepository.findByLocationEqualsOrLocationIsNull(any(Location.class))).thenReturn(location.getProducts());

        List<Product> result = locationService.getProductsForLocation(1L);

        assertTrue(result.size() == 1);
    }

    @Test(expected = LocationNotFoundException.class)
    public void testFailureGetProductsForLocation() {
        when(locationRepository.findOne(any(Long.class))).thenReturn(Optional.empty());

        locationService.getProductsForLocation(1L);
    }
}
