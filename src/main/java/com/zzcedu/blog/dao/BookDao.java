package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.NoteBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    @Select("select * from cn_notebook where cn_user_id = #{userId}")
    List<NoteBook> findByUserId(String userId);
    //创建笔记本
    @Insert("insert into cn_notebook(cn_notebook_id,cn_user_id,cn_notebook_type_id,cn_notebook_name,cn_notebook_desc,cn_notebook_createtime) " +
            "values(#{cn_notebook_id},#{cn_user_id},#{cn_notebook_type_id},#{cn_notebook_name},#{cn_notebook_desc},#{cn_notebook_createtime});")
    int save(NoteBook book);
}
