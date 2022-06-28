package com.hkt.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 794073612@qq.com
 * @time 16:48 2022/6/11
 **/

@Data
@TableName("user")
public class Users {
    private Integer id;
    private String username;
    private String password;
}
