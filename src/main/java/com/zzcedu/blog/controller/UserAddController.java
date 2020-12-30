package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.UserService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserAddController {
    @Resource
    private UserService userService;
    @RequestMapping("/user/add.do")
    public JsonResult execute(String username,String password,String nick) throws NoSuchAlgorithmException {
        JsonResult jsonResult = userService.addUser(username, password, nick);
        return jsonResult;

    }
}
