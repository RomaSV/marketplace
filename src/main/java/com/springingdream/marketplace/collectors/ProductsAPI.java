package com.springingdream.marketplace.collectors;

import com.springingdream.marketplace.collectors.requests.ProductRequest;
import org.springframework.web.client.RestTemplate;


public class ProductsAPI {

    public static String getAllProducts(String host) {
        final String uri = host + "/products";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    public static String getProductById(String host, Integer id) {
        final String uri = host + "/products/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    public static String postProduct(String host, ProductRequest request) {
        final String uri = host + "/products";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(uri, request, String.class);
    }

    public static void putProduct(String host, Integer id, ProductRequest request) {
        final String uri = host + "/products/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, request);
    }

    public static void deleteProductById(String host, Integer id) {
        final String uri = host + "/products/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
    }

}
