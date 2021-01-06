package com.zzcedu.blog.controller;

import com.zzcedu.blog.service.NoteService;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MoveNoteController {
    @Resource
    private NoteService noteService;
    @PostMapping("/note/move.do")
    public JsonResult execute(String noteId,String bookId){
      JsonResult jsonResult=  noteService.moveNote(noteId,bookId);
      return jsonResult;
    }
}
