package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    @Select("select * from cn_user where cn_user_name=#{username}")
    User findByName(String username);
}
