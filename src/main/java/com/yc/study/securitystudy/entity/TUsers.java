package com.yc.study.securitystudy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_users")
public class TUsers {

    private Integer id;

    private String username;

    private String password;
}
