package com.ivanzh.spring.cloud.learn.str.web;

import com.ivanzh.spring.cloud.learn.str.service.CulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kanghong.zhao on 2016-11-3.
 */
@RestController
public class StrController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private CulService culService;

    @RequestMapping(value = "/concat" ,method = RequestMethod.GET)
    public String concat(@RequestParam String a, @RequestParam String b) {
        return a.concat(b);
    }

    @RequestMapping(value = "/addToStr" ,method = RequestMethod.GET)
    public String addToStr(@RequestParam Integer a, @RequestParam Integer b) {
        Integer result = culService.add(a, b);
        return a + " + " + b + " = " + result;
    }

}
