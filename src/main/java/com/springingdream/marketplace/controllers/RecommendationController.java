package com.springingdream.marketplace.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springingdream.marketplace.collectors.AdviserAPI;
import com.springingdream.marketplace.collectors.ProductsAPI;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Value("${adviserAPI.host}")
    private String ADVISER_HOST;

    @Value("${productsAPI.host}")
    private String PRODUCTS_HOST;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    @ApiOperation(value = "Get general recommendations")
    @SuppressWarnings("unchecked")
    public List<JsonNode> getRecommendations(@RequestParam(value = "userId") int userId,
                                           @RequestParam(value = "page") int page,
                                           @RequestParam(value = "size") int size) {

        List<Integer> productIds = AdviserAPI.getGeneralRecommendations(ADVISER_HOST, userId, page, size);

        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> products = new ArrayList<>();
        for (Integer id : productIds) {
            JsonNode product = null;
            try {
                product = mapper.readTree(ProductsAPI.getProductById(PRODUCTS_HOST, id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            products.add(product);
        }
        return products;
    }
}