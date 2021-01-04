package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoadNeteController {
    @Resource
    private NoteService noteService;
    @RequestMapping("/note/loadNote.do")
    public JsonResult execute1(String noteId){
        JsonResult jsonResult = noteService.loadNote(noteId);
        return jsonResult;
    }
}
