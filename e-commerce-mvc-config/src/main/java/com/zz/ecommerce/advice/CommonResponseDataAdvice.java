package com.zz.ecommerce.advice;

import com.zz.ecommerce.annotation.IgnoreResponseAdvice;
import com.zz.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 实现统一响应
 *
 * @Author zhaozhen
 * @Version 1.0
 * @Date 2023/6/6 17:07
 */
@RestControllerAdvice("com.zz.ecommerce")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否对响应进行处理
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        if (o == null) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
        }else {
            response.setData(o);
        }
        return response;
    }
}
