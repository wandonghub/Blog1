package com.zzcedu.blog.service;

import com.zzcedu.blog.util.JsonResult;

public interface BookService {
    JsonResult loadUserBooks(String userId);
}
