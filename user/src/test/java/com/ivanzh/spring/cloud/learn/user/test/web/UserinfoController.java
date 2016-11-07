package com.ivanzh.spring.cloud.learn.user.test.web;

import com.ivanzh.spring.cloud.learn.user.UserApplication;
import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(UserApplication.class)
public class UserinfoController {

//    @Value("${local.server.port}")
    private int port = 4444;

    private String servicePathPre = "/user/";

//    private MockMvc mockMvc;
    private RestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test_成功创建用户() {
        String servicePath = servicePathPre + "create";
        String url = "http://localhost:" + port + servicePath;

        Userinfo createReq = new Userinfo();
        createReq.setUsername("edison");
        createReq.setNameCn("冠希");
        createReq.setNameEn("Edison");
        createReq.setPassword("12345");

        Userinfo userinfo = postJson(url, createReq, Userinfo.class, restTemplate);


        assertNotNull(userinfo.getId());
        assertEquals(createReq.getUsername(), userinfo.getUsername());
//        assertArrayEquals(excepted, actual);
    }

        public static <T, E> T postJson(String url,  E entity, Class<T> responseType, RestTemplate restTemplate){
            HttpHeaders headers =new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request=new HttpEntity(entity, headers);
            return restTemplate.postForObject(url, request, responseType);
        }

        public static <T> T postForObject(String url, Map<String, String> params, Class<T> responseType, RestTemplate restTemplate){

            MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();

            for(Map.Entry<String, String> entry : params.entrySet()){
                valueMap.add(entry.getKey(), entry.getValue());
            }

            if(restTemplate == null)
                restTemplate = new RestTemplate();

            return restTemplate.postForObject(url, valueMap, responseType);
        }


}
