package com.sky.product.controllers;

import com.sky.product.domain.Product;
import com.sky.product.exceptions.LocationNotFoundException;
import com.sky.product.services.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Adam on 18/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationControllerTest {

    @InjectMocks
    LocationController locationController;

    @Mock
    LocationService locationService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();
    }

    @Test
    public void testSuccessGetProductsForLocation() throws Exception {
        when(locationService.getProductsForLocation(any(Long.class))).thenReturn(new ArrayList<Product>());

        mockMvc.perform(get("/api/locations/1/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testFailureGetProductsForLocation() throws Exception {
        when(locationService.getProductsForLocation(any(Long.class))).thenThrow(new LocationNotFoundException(1L));

        mockMvc.perform(get("/api/locations/1/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
