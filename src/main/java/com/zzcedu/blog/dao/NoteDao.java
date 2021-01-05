package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
//根据bookId查询note
public interface NoteDao {
    @Select("select * from cn_note where cn_notebook_id = #{bookId} and cn_note_status_id='1'")
    List<Note> findByBookId(String bookId);
    @Select("select * from cn_note where cn_note_id=#{noteId}")
    Note findById(String noteId);
    @Update("update cn_note set cn_note_title = #{cn_note_title},cn_note_body = #{cn_note_body},cn_note_last_modify_time = #{cn_note_last_modify_time} where cn_note_id = #{cn_note_id} ")
    int update(Note note);
//    @Insert("insert into(cn_note_id,cn_notebook_id,cn_user_id,cn_note_status_id,cn_note_type_id,cn_note_title,cn_note_create_time,cn_note_last_modify_time) " +
//            "values(#{cn_note_id},#{cn_notebook_id},#{cn_user_id},#{cn_note_status_id},#{cn_note_type_id},#{cn_note_title},#{cn_note_create_time},#{cn_note_last_modify_time})")
    @Insert("insert into cn_note(cn_note_id,cn_notebook_id,cn_user_id,cn_note_status_id,cn_note_type_id,cn_note_title,cn_note_create_time,cn_note_last_modify_time,cn_note_body) " +
            "values(#{cn_note_id},#{cn_notebook_id},#{cn_user_id},#{cn_note_status_id},#{cn_note_type_id},#{cn_note_title},#{cn_note_create_time},#{cn_note_last_modify_time},#{cn_note_body})")
    int save(Note note);
@Update("update cn_note set cn_note_status_id='2' where cn_note_id=#{noteId}")
    int updateStatus(String noteId);
}
