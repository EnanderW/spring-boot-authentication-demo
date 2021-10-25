package com.example.springbootovningar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {

    @Autowired
    Service service;

    @PutMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/test-auth")
    public String helloWorld(@RequestHeader("username") String username, @RequestHeader("password") String password) {
        if (!service.authenticate(username, password))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);


        return "Hello World!";
    }

}
