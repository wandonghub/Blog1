package com.zzcedu.blog.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应实体
 * 各种响应最后都用这个响应实体类来封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonResult {
    //响应状态
    //0是成功，其他的都是失败
    private Integer status;
    //封装后台的响应信息
    private  String msg;
    //封装后台传给前台的数据
    private Object data;
}
