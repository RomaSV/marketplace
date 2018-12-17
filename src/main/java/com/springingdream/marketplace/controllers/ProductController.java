package com.springingdream.marketplace.controllers;

import com.springingdream.marketplace.collectors.ProductsAPI;
import com.springingdream.marketplace.collectors.requests.ProductRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Value("${productsAPI.host}")
    private String HOST;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Get all the products")
    public String getProducts() {
        return ProductsAPI.getAllProducts(HOST);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Get product by id")
    public String getProductById(@PathVariable int id) {
        return ProductsAPI.getProductById(HOST, id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Add a new product")
    public String addProduct(@RequestBody ProductRequest request) {
        return ProductsAPI.postProduct(HOST, request);
    }

    @PutMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Update a new product")
    public void updateProduct(@RequestBody ProductRequest request, @PathVariable int id) {
        ProductsAPI.putProduct(HOST, id, request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Get all the products")
    public void deleteProductById(@PathVariable int id) {
        ProductsAPI.deleteProductById(HOST, id);
    }
}
