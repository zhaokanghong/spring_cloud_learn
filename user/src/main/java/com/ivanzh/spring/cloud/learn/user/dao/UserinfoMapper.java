package com.ivanzh.spring.cloud.learn.user.dao;

import com.ivanzh.spring.cloud.learn.user.vo.Userinfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by kanghong.zhao on 2016-11-7.
 */
@Mapper
public interface UserinfoMapper {

    @Select("select * from userinfo where id = #{userId}")
    Userinfo getById(Integer userId);

    @InsertProvider(type = UserinfoInsertSqlProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(Userinfo userinfo);

}
