package com.zzcedu.blog.dao;

import com.zzcedu.blog.entity.Share;
import org.apache.ibatis.annotations.Insert;

public interface ShareDao {
    @Insert("insert into cn_share(cn_share_id,cn_share_title,cn_share_body,cn_note_id)" +
            "values(#{cn_share_id},#{cn_share_title},#{cn_share_body},#{cn_note_id})")
    void save(Share share);
}
