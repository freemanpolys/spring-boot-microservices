package com.mygglo.learning.gateway.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@RestController
public class SchoolGatewayController {
    private final RestTemplate restTemplate;

    public SchoolGatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/school-list")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(restTemplate.getForObject("http://school/list",String.class));
    }

}
