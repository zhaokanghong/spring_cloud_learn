package com.ivanzh.spring.cloud.learn.cul10.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by kanghong.zhao on 2016-10-19.
 */
@RestController
public class Cul10Controller {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        return mul(a + b);
    }

    @RequestMapping(value = "/minus" ,method = RequestMethod.GET)
    public Integer minus(@RequestParam Integer a, @RequestParam Integer b) {
        return mul(a - b);
    }

    @RequestMapping(value = "/mul" ,method = RequestMethod.GET)
    public Integer mul(@RequestParam Integer a, @RequestParam Integer b) {
        return mul(a * b);
    }

    @RequestMapping(value = "/div" ,method = RequestMethod.GET)
    public Integer div(@RequestParam Integer a, @RequestParam Integer b) {
        return mul(a / b);
    }

    private Integer mul(Integer r){
        return r * 10;
    }
}
