package com.sky.product.services;

import com.sky.product.domain.Customer;
import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.exceptions.CustomerNotFoundException;
import com.sky.product.repositories.CustomerRepository;
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
 * Created by Adam on 16/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    ProductRepository productRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerService).build();
    }

    @Test
    public void testSuccessGetCustomerCatalogue() {
        Customer customer = new Customer();
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        products.add(product);

        when(customerRepository.findOne(any(Long.class))).thenReturn(Optional.of(customer));
        when(productRepository.findByLocationEqualsOrLocationIsNull(any(Location.class))).thenReturn(products);

        List<Product> result = customerService.getCustomerCatalogue(1L);

        assertTrue(result.size() == 1);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testFailureGetCustomerCatalogue() {
        when(customerRepository.findOne(any(Long.class))).thenReturn(Optional.empty());

        customerService.getCustomerCatalogue(1L);
    }

    @Test
    public void testSuccessGetCustomerLocation() {
        Customer customer = new Customer();
        Location location = new Location();
        location.setName("test");

        customer.addLocation(location);

        when(customerRepository.findOne(any(Long.class))).thenReturn(Optional.of(customer));

        Location result = customerService.getCustomerLocation(1L);

        assertTrue(location.getName().equals(result.getName()));
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testFailureGetCustomerLocation() {
        when(customerRepository.findOne(any(Long.class))).thenReturn(Optional.empty());

        customerService.getCustomerLocation(1L);
    }

}
