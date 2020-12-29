package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface UserDao {
    @Select("select * from cn_user")
    List<User> findAll();
}
