package com.ivanzh.spring.cloud.learn.user.test.service;

import com.ivanzh.spring.cloud.learn.user.UserApplication;
import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(UserApplication.class)
public class UserinfoService {

    @Autowired
    private com.ivanzh.spring.cloud.learn.user.service.UserinfoService userinfoService;

    @Transactional(readOnly = true)
    @Test
    public void test_成功创建用户() throws Exception {
        Userinfo createReq = new Userinfo();
        createReq.setUsername("edison");
        createReq.setNameCn("冠希");
        createReq.setNameEn("Edison");
        userinfoService.createUser(createReq);

        assertNotNull(createReq.getId());
    }

}
