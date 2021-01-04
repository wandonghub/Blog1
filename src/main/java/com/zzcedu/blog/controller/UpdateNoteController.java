package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UpdateNoteController {
    @Resource
    private NoteService noteService;
    @RequestMapping("/note/update.do")
    public JsonResult execute(String title ,String noteId,String body){
        JsonResult jsonResult = noteService.updateNote(title, noteId, body);
        return jsonResult;

    }
}
