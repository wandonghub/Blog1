package com.zzcedu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    private String cn_note_id;
    private String cn_notebook_id;
    private String cn_user_id;
    private String cn_note_status_id;
    private String cn_note_type_id;
    private String cn_note_title;
    private String cn_note_body;
    private Long cn_note_create_time;
    private Long cn_note_last_modify_time;



}
