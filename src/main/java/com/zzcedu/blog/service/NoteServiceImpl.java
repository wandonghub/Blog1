package com.zzcedu.blog.service;

import com.zzcedu.blog.dao.NoteDao;
import com.zzcedu.blog.entity.Note;
import com.zzcedu.blog.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteDao noteDao;
    @Override
    public JsonResult loadNotes(String bookId) {
        JsonResult jsonResult = new JsonResult();
        List<Note> notes = noteDao.findByBookId(bookId);
        jsonResult.setStatus(0);
        jsonResult.setMsg("查询笔记成功");
        jsonResult.setData(notes);
        return jsonResult;
    }

    @Override
    public JsonResult loadNote(String noteId) {
        JsonResult jsonResult = new JsonResult();
        Note byId = noteDao.findById(noteId);
        jsonResult.setStatus(0);
        jsonResult.setMsg("查询成功");
        jsonResult.setData(byId);
        return jsonResult;
    }

    @Override
    public JsonResult updateNote(String title, String noteId, String body) {
        JsonResult jsonResult = new JsonResult();
        Note note = Note.builder().cn_note_id(noteId).cn_note_body(body).cn_note_title(title).cn_note_last_modify_time(System.currentTimeMillis()).build();
        int update = noteDao.update(note);
        if (update>0){
            jsonResult.setMsg("保存笔记成功");
            jsonResult.setStatus(0);
            return jsonResult;
        }
        jsonResult.setStatus(1);
        jsonResult.setMsg("保存笔记失败");
        return jsonResult;
    }
}
