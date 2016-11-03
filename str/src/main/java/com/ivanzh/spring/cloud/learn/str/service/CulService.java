package com.ivanzh.spring.cloud.learn.str.service;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kanghong.zhao on 2016-11-2.
 */
@Service
public class CulService {

    @Autowired
    RestTemplate restTemplate;

    final String SERVICE_NAME = "cul-service";

    public Integer add(Integer a, Integer b){
        Map map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
//        return restTemplate.getForObject("http://" + SERVICE_NAME + "/add?a=" + a + "&b=" + b, Integer.class, map);

        ResponseEntity<Integer> results  = restTemplate.exchange(
                "http://" + SERVICE_NAME + "/add?a={a}&b={b}",
                HttpMethod.GET,
                null,
                Integer.class,
                new Integer[]{a, b}
        );

        return results.getBody();
    }

}
