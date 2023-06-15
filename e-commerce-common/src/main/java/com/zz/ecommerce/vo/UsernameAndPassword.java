package com.zz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户名和密码
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/15 00:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPassword {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}

