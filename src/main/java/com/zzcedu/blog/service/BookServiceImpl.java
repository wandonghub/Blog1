package com.zzcedu.blog.service;

import com.zzcedu.blog.dao.BookDao;
import com.zzcedu.blog.entity.NoteBook;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Override
    public JsonResult loadUserBooks(String userId) {
        JsonResult jsonResult = new JsonResult();
        List<NoteBook> books = bookDao.findByUserId(userId);
        //创建返回结果
        jsonResult.setStatus(0);
        jsonResult.setMsg("查询笔记本成功");
        jsonResult.setData(books);
        return jsonResult;
    }
}
