package com.zz.ecommerce.advice;

import com.zz.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获处理
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/7 01:01
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(HttpServletRequest request, Exception ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());

        //spring boot 默认 logback 了解其思想和使用方式
        log.error("commerce service has error: [{}]", ex.getMessage(), ex);

        return response;
    }

}
