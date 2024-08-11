package com.sridhar.bottle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/admin/greet/{username}")
    public String greet(@PathVariable("username") String username) {
        return "Hello admin"+username;
    }
    @GetMapping("/user/greet/{username}")
    public String greet1(@PathVariable("username") String username) {
        return "Hello user"+username;
    }
}
