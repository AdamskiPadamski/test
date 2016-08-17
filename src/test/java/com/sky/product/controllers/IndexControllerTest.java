package com.sky.product.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by Adam on 16/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testGetIndexPage() throws Exception {
        mockMvc.perform(get("/")
                .contentType(MediaType.TEXT_HTML_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }
}
