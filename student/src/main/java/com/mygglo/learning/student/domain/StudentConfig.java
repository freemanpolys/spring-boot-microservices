package com.mygglo.learning.student.domain;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Configuration
public class StudentConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate  = new RestTemplate();
        return restTemplate;
    }
}
