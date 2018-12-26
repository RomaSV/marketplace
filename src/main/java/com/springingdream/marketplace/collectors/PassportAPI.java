package com.springingdream.marketplace.collectors;

import com.springingdream.marketplace.collectors.requests.UserRequest;
import org.springframework.web.client.RestTemplate;

public class PassportAPI {


    public static String getUserById(String host, Integer id) {
        final String uri = host + "/api/passport/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    public static Long auth(String host, UserRequest request) {
        final String uri = host + "/api/passport/auth";


        RestTemplate restTemplate = new RestTemplate();
        UserRequest userData = restTemplate.postForObject(uri, request, UserRequest.class);
        return userData.getUid();
    }
}
