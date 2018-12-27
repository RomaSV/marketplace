package com.springingdream.marketplace.collectors;

import com.springingdream.marketplace.collectors.requests.RateRequest;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class AdviserAPI {
    public static List<Integer> getGeneralRecommendations(String host, Integer userId, Integer page, Integer size) {

        RestTemplate restTemplate = new RestTemplate();
        String uri = host +
                "api/adviser/personal/" +
                userId;

        List<Integer> response = restTemplate.getForObject(uri, List.class);
        if (response != null) {
            return response.size() > size ? response.subList(page * size, (page + 1) * size) : response;
        } else {
            System.out.println("Response from Adviser Service is null.");
            return Collections.emptyList();
        }

    }

    public static void rateProduct(String host, RateRequest request) {
        final String uri = host + "/api/adviser/update";


        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, request, String.class);
    }
}
