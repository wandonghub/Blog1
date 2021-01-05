package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AddNoteController {
    @Resource
    private NoteService noteService;
    @PostMapping("/note/addNote.do")
    public JsonResult execute(String noteTitle,String userId,String bookId){
        JsonResult jsonResult =noteService.addNote(noteTitle,userId,bookId);
        return jsonResult;
    }
}
