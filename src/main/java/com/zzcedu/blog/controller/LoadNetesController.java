package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoadNetesController {
    @Resource
    private NoteService noteService;
    @RequestMapping("/note/loadNotes.do")
    public JsonResult execute(String bookId){
        JsonResult jsonResult = noteService.loadNotes(bookId);
        return jsonResult;
    }
}
