package com.kshrd.jwt_testing.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @GetMapping("/home")
    public String getHomePage(){
        return "Hello from home page";
    }

    @GetMapping("/user_page")
    public String getUserPage(){
        return "Hello from user page";
    }

    @GetMapping("/admin_page")
    public String getAdminPage(){
        return "Hello from admin page";
    }

    @GetMapping("/user_admin")
    public String getUserAdminPage(){
        return "Hello from User and Admin page";
    }

}
