package com.sky.product.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Adam on 12/08/2016.
 */
@Controller
public class IndexController {

    /**
     * Retrieves a front-end web application
     *
     * @return a front-end web application
     */
    @GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getIndex() {
        return "index";
    }

}
