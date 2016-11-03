package com.ivanzh.spring.cloud.learn.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by kanghong.zhao on 2016-11-3.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args){
        new SpringApplication(ZuulApplication.class).run(args);
    }

}
