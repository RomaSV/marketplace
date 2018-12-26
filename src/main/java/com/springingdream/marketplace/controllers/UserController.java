package com.springingdream.marketplace.controllers;

import com.springingdream.marketplace.collectors.PassportAPI;
import com.springingdream.marketplace.collectors.ProductsAPI;
import com.springingdream.marketplace.collectors.requests.ProductRequest;
import com.springingdream.marketplace.collectors.requests.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Value("${passportAPI.host}")
    private String HOST;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Get user by id")
    public String getProducts(@PathVariable int id) {
        return PassportAPI.getUserById(HOST, id);
    }

    @PostMapping(path = "/auth", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Auth")
    public Long updateProduct(@RequestBody UserRequest request) {
        return PassportAPI.auth(HOST, request);
    }
}