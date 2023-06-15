package com.zz.ecommerce.controller;

import com.alibaba.fastjson.JSON;
import com.zz.ecommerce.annotation.IgnoreResponseAdvice;
import com.zz.ecommerce.service.IJWTService;
import com.zz.ecommerce.vo.JwtToken;
import com.zz.ecommerce.vo.UsernameAndPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外暴露的授权服务接口
 *
 * @Author zz
 * @Version 1.0
 * @Date 2023/6/15 02:44
 */
@Slf4j
@RestController
@RequestMapping("/authority")
public class AuthorityController {
    private final IJWTService ijwtService;

    public AuthorityController(IJWTService ijwtService) {
        this.ijwtService = ijwtService;
    }

    /**
     * 从授权中心获取token(其实就是登陆功能)，且返回信息中没有统一响应的包装
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/token")
    @IgnoreResponseAdvice
    public JwtToken token(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception {
        log.info("request to get token with param:[{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken(ijwtService.generateToken(
                usernameAndPassword.getUsername(), usernameAndPassword.getPassword())
        );
    }

    /**
     * 注册用户并返回token
     *
     * @return
     */
    @IgnoreResponseAdvice
    @PostMapping("/register")
    public JwtToken register(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception {
        log.info("register user with param:[{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken(ijwtService.registerUserAndGenerateToken(usernameAndPassword));
    }

}
