package com.zzcedu.blog.service;

import com.zzcedu.blog.util.JsonResult;

public interface NoteService {
    JsonResult loadNotes(String bookId);
    JsonResult loadNote(String noteId);

    JsonResult updateNote(String title, String noteId, String body);
}
