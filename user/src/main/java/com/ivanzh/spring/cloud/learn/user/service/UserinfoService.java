package com.ivanzh.spring.cloud.learn.user.service;

import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
public interface UserinfoService {

    Userinfo createUser(Userinfo userinfo);

    Userinfo getUserById(Integer id);

    Userinfo getUserByUsername(String username);

}
