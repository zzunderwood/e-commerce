package com.zz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用响应对象
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/6 14:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {
    private Integer code;

    private String message;

    private T Data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
