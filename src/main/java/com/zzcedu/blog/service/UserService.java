package com.zzcedu.blog.service;

import com.zzcedu.blog.util.JsonResult;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    JsonResult checkLogin(String username,String password) throws NoSuchAlgorithmException;

    JsonResult addUser(String username, String password, String nick) throws NoSuchAlgorithmException;

}
