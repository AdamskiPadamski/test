package com.sky.product.controllers;

import com.sky.product.domain.Product;
import com.sky.product.exceptions.CustomerNotFoundException;
import com.sky.product.services.CustomerService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Adam on 15/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testGetCatalogue() throws Exception {
        when(customerService.getCustomerCatalogue(any(Long.class))).thenReturn(new ArrayList<Product>());

        mockMvc.perform(get("/api/customers/1/catalogue")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetCartProducts() throws Exception {
        when(customerService.getProductsInCustomerCart(any(Long.class))).thenReturn(new ArrayList<Product>());

        mockMvc.perform(get("/api/customers/1/cart/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAddProductToCart() throws Exception {
        String body = "{ \"productId\": 1 }";

        mockMvc.perform(post("/api/customers/1/cart/products/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void testDeleteProductFromCart() throws Exception {
        mockMvc.perform(delete("/api/customers/1/cart/products/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent())
                .andReturn();
    }

}
