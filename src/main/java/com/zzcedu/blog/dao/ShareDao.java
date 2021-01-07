package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.Note;
import com.zzcedu.blog.entity.Share;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShareDao {
    @Insert("insert into cn_share(cn_share_id,cn_share_title,cn_share_body,cn_note_id)" +
            "values(#{cn_share_id},#{cn_share_title},#{cn_share_body},#{cn_note_id})")
    void save(Share share);
    @Select("select * from cn_share where cn_share_title like #{keyword} limit #{start},5")
    List<Share> findLikeTitle(@Param("keyword") String keyword, @Param("start") int start);
    @Select("select * from cn_share where cn_share_id=#{shareId}")
    Share findById(@Param("shareId") String shareId);
}
