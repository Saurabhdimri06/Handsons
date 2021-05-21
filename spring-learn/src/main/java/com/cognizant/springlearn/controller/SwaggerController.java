package com.cognizant.springlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //note - this is a spring-boot controller, not @RestController
public class SwaggerController {
    @RequestMapping ("/swagger")
    public String home() {
    	return "redirect:/swagger-ui.html";
    }
}
