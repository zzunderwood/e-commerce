package com.zz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 授权中心鉴权之后给客户端的token
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/15 00:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken {
    /**
     * JWT
     */
    private String token;
}
