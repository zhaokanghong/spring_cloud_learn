package com.ivanzh.spring.cloud.learn.str;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kanghong.zhao on 2016-11-3.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StrApplication {

    public static void main(String[] args) {
        new SpringApplication(StrApplication.class).run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
