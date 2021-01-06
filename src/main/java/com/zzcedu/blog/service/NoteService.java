package com.zzcedu.blog.service;

import com.zzcedu.blog.util.JsonResult;

public interface NoteService {
    JsonResult loadNotes(String bookId);
    JsonResult loadNote(String noteId);

    JsonResult updateNote(String title, String userId,String body);

    JsonResult addNote(String noteTitle,String userId ,String bookId);

    JsonResult deleteNote(String noteId);

    JsonResult moveNote(String noteId, String bookId);

    JsonResult shareNote(String noteId);

}
