package com.ivanzh.spring.cloud.learn.user.dao;

import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
public class UserinfoInsertSqlProvider {

    public String buildInsertSql(Userinfo userinfo){
        return new SQL(){{
            INSERT_INTO("userinfo");
            VALUES("username", "#{username}");
            VALUES("password", "#{password}");
            if(userinfo.getNameCn() != null && !"".equals(userinfo.getNameCn().trim()))
                VALUES("name_cn", "#{nameCn}");
            if(userinfo.getNameEn() != null && !"".equals(userinfo.getNameEn().trim()))
                VALUES("name_en", "#{nameEn}");
        }}.toString();
    }

}
