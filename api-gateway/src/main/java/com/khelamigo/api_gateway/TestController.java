package com.khelamigo.api_gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/test")
public class TestController {
    
    @GetMapping
    public String getRequest() {
        return "Test";
    }
    
}
