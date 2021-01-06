package com.zzcedu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Share {
    private String cn_share_id;
    private String cn_share_title;
    private String cn_share_body;
    private String cn_note_id;

}
