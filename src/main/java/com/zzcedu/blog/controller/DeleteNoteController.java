package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DeleteNoteController {
    @Resource
    private NoteService noteService;
    @PostMapping("/note/delete.do")
    public JsonResult execute(String noteId){
        JsonResult jsonResult = noteService.deleteNote(noteId);
        return jsonResult;
    }
}
