package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.NoteBook;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    @Select("select * from cn_notebook where cn_user_id = #{userId}")
    List<NoteBook> findByUserId(String userId);
}
