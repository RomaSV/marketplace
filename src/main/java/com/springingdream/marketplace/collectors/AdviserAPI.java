package com.springingdream.marketplace.collectors;

import org.springframework.web.client.RestTemplate;

import java.util.*;

public class AdviserAPI {
    public static List<Integer> getGeneralRecommendations(String host, Integer userId, Integer page, Integer size) {
        final StringBuilder uri = new StringBuilder()
                .append(host)
                .append("/api/adviser/recommendations?userId=")
                .append(userId)
                .append("&page=")
                .append(page)
                .append("&size=")
                .append(size)
                .append("&useClusters=true");

        RestTemplate restTemplate = new RestTemplate();
        ApiResponse<LinkedHashMap<String, Object>> response = restTemplate.getForObject(uri.toString(), ApiResponse.class);
        return (List<Integer>)response.getBody().get("content");
    }
}
