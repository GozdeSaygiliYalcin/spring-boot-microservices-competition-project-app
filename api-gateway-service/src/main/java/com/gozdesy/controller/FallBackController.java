package com.gozdesy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @RequestMapping("/userService")
    public String userServiceFallBack() {
        return "User Service is taking longer than expected. Please try again later";
    }

    @RequestMapping("/departmentService")
    public String departmentServiceFallBack() {
        return "Department Service is taking longer than expected. Please try again later";
    }

}
