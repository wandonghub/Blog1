package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShareNoteController {
    @Resource
    private NoteService noteService;
    @PostMapping("/note/share.do")
    public JsonResult execute(String noteId) {
        JsonResult jsonResult=noteService.shareNote(noteId);
        return jsonResult;
    }
}
