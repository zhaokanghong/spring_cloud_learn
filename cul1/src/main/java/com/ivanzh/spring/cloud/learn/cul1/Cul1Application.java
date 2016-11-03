package com.ivanzh.spring.cloud.learn.cul1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by kanghong.zhao on 2016-11-3.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Cul1Application {


    public static void main(String[] args) {
        new SpringApplication(Cul1Application.class).run(args);
    }
}
