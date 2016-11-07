package com.ivanzh.spring.cloud.learn.user.web;

import com.ivanzh.spring.cloud.learn.user.service.UserinfoService;
import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
@RestController
@RequestMapping(value="user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @PostMapping(value = "/create")
    public Userinfo createUser(@RequestBody Userinfo userinfo){
        return userinfoService.createUser(userinfo);
    }

    @GetMapping(value = "/{userId}")
    public Userinfo getUser(@PathVariable("userId") Integer userId){
        return userinfoService.getUserById(userId);
    }

//    @GetMapping(value = "/create")
//    public Userinfo createUser(){
//        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("12345");
//        userinfo.setNameCn("陈少峰");
//        userinfo.setPassword("12345");
//        userinfo = userinfoService.createUser(userinfo);
//        return userinfo;
////        return userinfoService.getUserById(userId);
//    }
}
