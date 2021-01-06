package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

//    @Update("update cn_note set cn_note_title = #{cn_note_title},cn_note_body = #{cn_note_body},cn_note_last_modify_time = #{cn_note_last_modify_time} where cn_note_id = #{cn_note_id} ")
//    int update(Note note);
//    @Insert("insert into(cn_note_id,cn_notebook_id,cn_user_id,cn_note_status_id,cn_note_type_id,cn_note_title,cn_note_create_time,cn_note_last_modify_time) " +
//            "values(#{cn_note_id},#{cn_notebook_id},#{cn_user_id},#{cn_note_status_id},#{cn_note_type_id},#{cn_note_title},#{cn_note_create_time},#{cn_note_last_modify_time})")
    @Insert("insert into cn_note(cn_note_id,cn_notebook_id,cn_user_id,cn_note_status_id,cn_note_type_id,cn_note_title,cn_note_create_time,cn_note_last_modify_time,cn_note_body) " +
            "values(#{cn_note_id},#{cn_notebook_id},#{cn_user_id},#{cn_note_status_id},#{cn_note_type_id},#{cn_note_title},#{cn_note_create_time},#{cn_note_last_modify_time},#{cn_note_body})")
    int save(Note note);
//@Update("update cn_note set cn_note_status_id='2' where cn_note_id=#{noteId}")
//    int updateStatus(String noteId);
//@Update("update cn_note set cn_notebook_id=#{bookId}where cn_note_id=#{noteId}")
//    int updateNote(@Param("noteId") String noteId, @Param("bookId") String bookId);
//@Update("update cn_note set cn_note_type_id='2' where cn_note_id=#{noteId}")
//    int updateShare(@Param("noteId") String noteId);

//动态更新笔记信息
//@Update("<script>   update cn_note\n" +
//        "        <set>\n" +
////        "            <if test=\"cn_note_id ! =null\">\n" +
////        "                cn_note_id = #{cn_note_id},\n" +
////        "            </if>\n" +
//        "            <if test=\"cn_notebook_id != null\">\n" +
//        "                cn_notebook_id = #{cn_notebook_id},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_user_id != null\">\n" +
//        "                cn_user_id = #{cn_user_id},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_status_id != null\">\n" +
//        "                cn_note_status_id = #{cn_note_status_id},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_type_id != null\">\n" +
//        "                cn_note_type_id = #{cn_note_type_id},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_title != null\">\n" +
//        "                cn_note_title = #{cn_note_title},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_body != null\">\n" +
//        "                cn_note_body = #{cn_note_body},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_create_time != null\">\n" +
//        "                cn_note_create_time = #{cn_note_create_time},\n" +
//        "            </if>\n" +
//        "            <if test=\"cn_note_last_modify_time != null\">\n" +
//        "                cn_note_last_modify_time = #{cn_note_last_modify_time},\n" +
//        "            </if>\n" +
//        "        </set>\n" +
//        "        where cn_note_id = #{cn_note_id} </script>")
    @Update("<script> update cn_note\n" +
            "        <set>\n" +
            "            <if test=\"cn_notebook_id != null\">\n" +
            "                cn_notebook_id = #{cn_notebook_id},\n" +
            "            </if>\n" +
            "            <if test=\"cn_user_id != null\">\n" +
            "                cn_user_id = #{cn_user_id},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_status_id != null\">\n" +
            "                cn_note_status_id = #{cn_note_status_id},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_type_id != null\">\n" +
            "                cn_note_type_id = #{cn_note_type_id},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_title != null\">\n" +
            "                cn_note_title = #{cn_note_title},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_body != null\">\n" +
            "                cn_note_body = #{cn_note_body},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_create_time != null\">\n" +
            "                cn_note_create_time = #{cn_note_create_time},\n" +
            "            </if>\n" +
            "            <if test=\"cn_note_last_modify_time != null\">\n" +
            "                cn_note_last_modify_time = #{cn_note_last_modify_time},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where cn_note_id = #{cn_note_id} </script>")
    int dynamicUpdate(Note note);
}
