package com.ivanzh.spring.cloud.learn.user.service;

import com.ivanzh.spring.cloud.learn.user.dao.UserinfoMapper;
import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
@Service
@Transactional(readOnly = true)
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    @Transactional(readOnly = false)
    public Userinfo createUser(Userinfo userinfo) {
        userinfoMapper.insert(userinfo);
        return getUserById(userinfo.getId());
    }

    @Override
    public Userinfo getUserById(Integer id) {
        return userinfoMapper.getById(id);
    }

    @Override
    public Userinfo getUserByUsername(String username) {
        return null;
    }
}
