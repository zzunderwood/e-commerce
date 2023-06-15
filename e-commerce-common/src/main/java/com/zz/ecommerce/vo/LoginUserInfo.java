package com.zz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登陆用户信息
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/15 00:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;


}
